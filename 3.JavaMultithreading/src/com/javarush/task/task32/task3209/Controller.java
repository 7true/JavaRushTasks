package com.javarush.task.task32.task3209;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.ClientInfoStatus;

public class Controller {
    private View view;
    private HTMLDocument document;
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

    public void getPlainText() {
        StringWriter sWriter = new StringWriter();
        try {
            new HTMLEditorKit().write(sWriter, document, 0, document.le);
        } catch(Exception e) {
            ExceptionHandler.log(e);
        }
    }
}
