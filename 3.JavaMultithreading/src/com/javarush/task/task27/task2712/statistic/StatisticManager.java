package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.AdvertisementStorage;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {

    private static StatisticManager instance;
    private StatisticStorage statisticStorage;

    private StatisticManager() {
        this.statisticStorage = new StatisticStorage();
    }

    public static synchronized StatisticManager getInstance() {
        if (instance == null) {
            instance = new StatisticManager();
        }
        return instance;
    }


    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public Map<String, Long> getRevenuePerDay() {
        Map<String, Long> result = new TreeMap<>(Collections.reverseOrder());
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        for (EventDataRow eventDataRow : statisticStorage.get(EventType.SELECTED_VIDEOS)) {
            VideoSelectedEventDataRow videoSelectedEventDataRow = (VideoSelectedEventDataRow) eventDataRow;
            String date = format.format(videoSelectedEventDataRow.getDate());
            long amount = videoSelectedEventDataRow.getAmount();
            if (!result.containsKey(date)) {
                result.put(date, amount);
            } else {
                result.put(date, result.get(date) + amount);
            }
        }
        return result;
    }

    public Map<String, Map<String, Integer>>  getCookWorkloading() {
        Map<String, Map<String, Integer>> statResult = new TreeMap(Collections.reverseOrder());
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        for (EventDataRow eventDataRow : statisticStorage.get(EventType.COOKED_ORDER)) {
            CookedOrderEventDataRow cookedOrderEventDataRow = (CookedOrderEventDataRow) eventDataRow;
            String data = format.format(cookedOrderEventDataRow.getDate());
            String cookName = cookedOrderEventDataRow.getCookName();
            int cookingTime = cookedOrderEventDataRow.getTime();
            if (!statResult.containsKey(data)) {
                Map<String, Integer> cookTimeMap = new TreeMap<>();
                cookTimeMap.put(cookName, cookingTime);
                statResult.put(data, cookTimeMap);
            } else {
                Map<String, Integer> map = statResult.get(data);
                if (!map.containsKey(cookName)) {
                    map.put(cookName, cookedOrderEventDataRow.getTime());
                } else {
                    map.put(cookName, map.get(cookName) + cookedOrderEventDataRow.getTime());
                }
                //statResult.put(data, map);
            }
        }
        return statResult;
    }

    public Map<String, Integer> getVideoSet(boolean active) {
        Map<String, Integer> videoSet = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        List<Advertisement> ads = AdvertisementStorage.getInstance().list();

        for (Advertisement ad : ads) {
            if (ad.getHits() > 0 && active) {
                videoSet.put(ad.getName(), ad.getHits());
            } else if (ad.getHits() < 1 && !active) {
                videoSet.put(ad.getName(), 0);
            }
        }
        return videoSet;
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();
        public StatisticStorage() {
            for (int i = 0; i < EventType.values().length; i++) {
                storage.put(EventType.values()[i], new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        private List<EventDataRow> get(EventType type) {
            return storage.get(type);
        }
    }

}
