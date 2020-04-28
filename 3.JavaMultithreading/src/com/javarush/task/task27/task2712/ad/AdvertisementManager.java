package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    List<Advertisement> advWithHits = new ArrayList<>();
    private int timeSeconds;
    private long bestPrice;
    private List<Advertisement> bestItems = new ArrayList<>();
    private int maxWeight;
    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> advList = storage.list();
        maxWeight = timeSeconds;

        if (advList.isEmpty()) {
            throw new NoVideoAvailableException();
        }
        for (Advertisement advertisement : advList) {
            if (advertisement.getHits() > 0) {
                advWithHits.add(advertisement);
            }
        }

        makeAllSets(advWithHits);

        bestItems.sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return (int) (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
            }
        }.thenComparing(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o2.getDuration() - o1.getDuration();
            }
        }));
        if (bestItems.isEmpty()) {
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));
        } else {
            long totalAmount = 0;
            int totalDuration = 0;
            for (Advertisement ad : bestItems) {
                totalAmount += ad.getAmountPerOneDisplaying();
                totalDuration += ad.getDuration();
            }
            StatisticManager.getInstance().register(new VideoSelectedEventDataRow(bestItems, totalAmount, totalDuration));
        }

        for (Advertisement adv : bestItems) {
            adv.revalidate();
            ConsoleHelper.writeMessage(adv.toString());
        }

    }

    private int calcWeight(List<Advertisement> advList) {
        int sumW = 0;
        for (Advertisement a : advList) {
            sumW += a.getDuration();
        }
        return sumW;
    }

    private long calcPrice(List<Advertisement> advList) {
        long sumPrice = 0;
        for (Advertisement a : advList) {
            sumPrice += a.getAmountPerOneDisplaying();
        }
        return sumPrice;
    }

    private void checkSet(List<Advertisement> advList) {

        int currentWeight = calcWeight(advList);
        long currentPrice = calcPrice(advList);
        if (bestItems == null) {
            if (currentWeight <= maxWeight) {
                //allSets.add(advList);
                bestItems = advList;
                bestPrice = currentPrice;
            }
        } else {
            if (currentWeight <= maxWeight) {
                if (currentPrice > bestPrice) {
                    bestItems = advList;
                    bestPrice = currentPrice;
                } else if (currentPrice == bestPrice) {
                    if (currentWeight > calcWeight(bestItems)) {
                        bestItems = advList;
                    } else if (currentWeight == calcWeight(bestItems)) {
                        if (advList.size() < bestItems.size()) {
                            bestItems = advList;
                        }
                    }
                }
            }
        }
    }

    public void makeAllSets(List<Advertisement> advList) {
        if (advList.size() > 0) {
            checkSet(advList);
        }
        for (int i = 0; i < advList.size(); i++) {
            List<Advertisement> newSet = new ArrayList<>(advList);
            newSet.remove(i);
            makeAllSets(newSet);
        }
    }
}
