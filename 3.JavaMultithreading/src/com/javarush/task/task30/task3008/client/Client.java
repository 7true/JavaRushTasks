package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    protected Connection connection;
    private volatile boolean  clientConnected = false;

    public static final boolean checkIPv4(final String ip) {
        boolean isIPv4;
        try {
            final InetAddress inet = InetAddress.getByName(ip);
            isIPv4 = (inet.getHostAddress().equals(ip)
                    && inet instanceof Inet4Address) || ip.equals("localhost");
        } catch (final UnknownHostException e) {
            isIPv4 = false;
        }
        return isIPv4;
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Enter server name please: ");
        String address = ConsoleHelper.readString();
        return address;
    }

    protected int getServerPort() {
        int port = ConsoleHelper.readInt();
        return port;
    }

    protected String getUserName() {
        String userName = ConsoleHelper.readString();
        return userName;
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        SocketThread socketThread = new SocketThread();
        return socketThread;
    }

    protected void sendTextMessage(String text) {
        try {
            Message message = new Message(MessageType.TEXT, text);
            connection.send(message);
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Failed to connect to server");
            clientConnected = false;
        }
    }
    public class SocketThread extends Thread {

    }

}
