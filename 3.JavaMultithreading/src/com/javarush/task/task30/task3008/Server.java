package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for(ConcurrentHashMap.Entry <String, Connection> pair : connectionMap.entrySet()) {
            try {
                pair.getValue().send(message);
            } catch (IOException e) {
                System.out.println("Сообщение не было отправлено пользователю " + pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен");
            while(true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandShake(Connection connection) throws IOException, ClassNotFoundException {
            Message message = new Message(MessageType.NAME_REQUEST, "What is your name?");

            connection.send(message);
            Message messageReceive = connection.receive();
            while (messageReceive.getType().equals(MessageType.USER_NAME) || messageReceive.getData().isEmpty() || connectionMap.containsKey(messageReceive.getData())) {
                serverHandShake(connection);
            }
            connectionMap.put(message.getData(), connection);
            message = new Message(MessageType.NAME_ACCEPTED, "Your name is accepted?");
            connection.send(message);
            return messageReceive.getData();
        }
    }
}
