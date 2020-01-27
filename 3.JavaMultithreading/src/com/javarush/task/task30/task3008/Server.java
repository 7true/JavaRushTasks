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

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = new Message(MessageType.NAME_REQUEST);
                connection.send(message);
                Message response = connection.receive();
                if (response.getType() == MessageType.USER_NAME && !response.getData().isEmpty() && !connectionMap.containsKey(response.getData())) {
                    connectionMap.put(response.getData(), connection);
                    message = new Message(MessageType.NAME_ACCEPTED);
                    connection.send(message);
                    return response.getData();
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> c : connectionMap.entrySet()) {
                if (!c.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, c.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message incomeConnect = connection.receive();
                if (incomeConnect.getType() == MessageType.TEXT) {
                    Message broadcast = new Message(MessageType.TEXT, userName + ": " + incomeConnect.getData());
                    sendBroadcastMessage(broadcast);

                } else {
                    ConsoleHelper.writeMessage("Failed to send message..");
                }
            }
        }

        @Override
        public void run() {
            super.run();
            ConsoleHelper.writeMessage("Connection established with " + socket.getRemoteSocketAddress());
            try (Connection connection = new Connection(socket)) {
                String userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Failed to connect..");
            }
        }
    }
}
