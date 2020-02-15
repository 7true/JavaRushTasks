package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {

    public static void main(String[] args) {

        BotClient botClient = new BotClient();
        System.out.println(botClient.getUserName());
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        String botName = "date_bot_" + (int) (Math.random() * 100);
        return botName;
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            String stringMessage = "Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.";
            sendTextMessage(stringMessage);
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] nameAndMessage = message.split(": ", 2);
            if (nameAndMessage.length == 2) {

                SimpleDateFormat sdf;
                Calendar c = Calendar.getInstance();
                String date;

                switch (nameAndMessage[1]) {
                    case "дата":
                        sdf = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    case "день":
                        sdf = new SimpleDateFormat("d");
                        break;
                    case "месяц":
                        sdf = new SimpleDateFormat("MMMM");
                        break;
                    case "год":
                        sdf = new SimpleDateFormat("YYYY");
                        break;
                    case "время":
                        sdf = new SimpleDateFormat("H:mm:ss");
                        break;
                    case "час":
                        sdf = new SimpleDateFormat("H");
                        break;
                    case "минуты":
                        sdf = new SimpleDateFormat("m");
                        break;
                    case "секунды":
                        sdf = new SimpleDateFormat("s");
                        break;
                    default:
                        sdf = null;
                        break;
                }
                if (sdf != null) {
                    date = sdf.format(c.getTime());
                    sendTextMessage("Информация для " + nameAndMessage[0] + ": " + date);
                }
            }
        }
    }
}
