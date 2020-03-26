package com.javarush.task.task32.task3209;

import org.xml.sax.ErrorHandler;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;
import java.sql.ClientInfoStatus;

public class Controller {
    private View view;
    private HTMLDocument document = new HTMLDocument();
    private File currentFile;
    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void init() {
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }

    public void resetDocument() {
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }

        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();

    }
    public void setPlainText(String text) {
        resetDocument();
        StringReader sReader = new StringReader(text);
        try {
            new HTMLEditorKit().read(sReader, document, 0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        StringWriter sWriter = new StringWriter();
        try {
            new HTMLEditorKit().write(sWriter, document, 0, document.getLength());
            return sWriter.toString();
        } catch(Exception e) {
            ExceptionHandler.log(e);
        }
        return null;
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML editor");
        view.resetUndo();
        currentFile = null;

    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        int choice = fileChooser.showOpenDialog(view);
        fileChooser.setDialogTitle("Open File");
        FileReader fileReader = null;
        if (choice == JFileChooser.APPROVE_OPTION) {
            resetDocument();
            view.resetUndo();
            currentFile=fileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try {
                fileReader = new FileReader(currentFile);
                new HTMLEditorKit().read(fileReader, document, 0);
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            } finally {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    ExceptionHandler.log(e);
                }
            }
        }

    }

    public void saveDocument() {
        if (currentFile != null) {
            try {
                view.selectHtmlTab();
                resetDocument();
                view.setTitle(currentFile.getName());
                FileWriter fileWriter = new FileWriter(currentFile);
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
                fileWriter.close();
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        } else {
            saveDocumentAs();
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        int choice = fileChooser.showSaveDialog(view);
        FileWriter fileWriter = null;
        if (choice == JFileChooser.APPROVE_OPTION) {
            currentFile=fileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try {
                fileWriter = new FileWriter(currentFile);
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            } finally {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    ExceptionHandler.log(e);
                }
            }
        }

    }
}
