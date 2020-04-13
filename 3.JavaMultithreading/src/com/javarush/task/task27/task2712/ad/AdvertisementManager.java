package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.*;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    List<Advertisement> advForTablet = new ArrayList<>();
    long bestPrice;
    private int timeSeconds;
    int maxWeight = timeSeconds;
    private List<Advertisement> bestItems = new ArrayList<>();
    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public List<Advertisement> processVideos() {
        List<Advertisement> advList = storage.list();
        List<Advertisement> advWithHits = new ArrayList<>();
        if (advList.isEmpty()) {
            throw new NoVideoAvailableException();
        }
        for (Advertisement advertisement : advList) {
            if (advertisement.getHits() > 0) advWithHits.add(advertisement);
        }

        makeAllSets(advWithHits);

        for (Advertisement adv : bestItems) {
            adv.revalidate();
            ConsoleHelper.writeMessage(adv.toString());
        }
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

        return bestItems;

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
        if (bestItems == null) {
            if (calcWeight(advList) <= maxWeight) {
                bestItems = advList;
                bestPrice = calcPrice(advList);
            }
        } else {
            if (calcWeight(advList) <= maxWeight && calcPrice(advList) >= bestPrice) {
                bestItems = advList;
                bestPrice = calcPrice(advList);
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
