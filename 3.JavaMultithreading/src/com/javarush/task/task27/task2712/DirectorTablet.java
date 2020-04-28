package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class DirectorTablet {

    public void printAdvertisementProfit() throws ParseException {
        Map<String, Long> advProfitPerDayList = StatisticManager.getInstance().getRevenuePerDay();
        SimpleDateFormat prevFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat newFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Long total = 0L;
        for (Map.Entry<String, Long> entry : advProfitPerDayList.entrySet()) {
            Date date = prevFormat.parse(entry.getKey());
            total += entry.getValue();
            if (entry.getValue() > 0) {
                ConsoleHelper.writeMessage(String.format("%s - %.2f", newFormat.format(date), entry.getValue()/100.00));
            }
        }
        if (total > 0) {
            ConsoleHelper.writeMessage(String.format("Total - %.2f",total/100.00));
        }
    }

    public void printCookWorkloading() throws ParseException {
        Map<String, Map<String, Integer>> map = StatisticManager.getInstance().getCookWorkloading();
        SimpleDateFormat prevFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat newFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            Date date = prevFormat.parse(entry.getKey());
            ConsoleHelper.writeMessage(newFormat.format(date));
            for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet()) {
                ConsoleHelper.writeMessage(String.format("%s - %d min", innerEntry.getKey(), innerEntry.getValue() / 60));
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet() {
        Map<String, Integer> activeVideoSet = StatisticManager.getInstance().getVideoSet(true);
        for (Map.Entry<String, Integer> entry : activeVideoSet.entrySet()) {
            ConsoleHelper.writeMessage(String.format("%s - %d", entry.getKey(), entry.getValue()));
        }
    }

    public void printArchivedVideoSet() {
        Map<String, Integer> activeVideoSet = StatisticManager.getInstance().getVideoSet(false);
        for (Map.Entry<String, Integer> entry : activeVideoSet.entrySet()) {
            ConsoleHelper.writeMessage(String.format("%s", entry.getKey()));
        }
    }
}
