package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;

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
        String address = null;
        ConsoleHelper.writeMessage("Enter server name please: ");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
        String line;
        while(!checkIPv4(line = br.readLine())) {

        }
        address = line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return address;
    }

    protected int getServerPort() {
        int port = 7777;
        ConsoleHelper.writeMessage("Enter port:");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            port = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return port;
    }

    public class SocketThread extends Thread {

    }


}
