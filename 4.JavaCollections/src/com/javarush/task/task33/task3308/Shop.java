package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@XmlRootElement
@XmlType(name = "shop")
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData = new String[5];

    @Override
    public String toString() {

        return "goods: " + "\n"
                + goods.names.get(0) + "\n"
                + goods.names.get(1) + "\n"
                + "count = " + count + "\n"
                + "profit = " + profit + "\n"
                + Arrays.toString(secretData);
    }

    static class Goods {
        @XmlElement
        public List<String> names = new ArrayList<>();
    }
}
