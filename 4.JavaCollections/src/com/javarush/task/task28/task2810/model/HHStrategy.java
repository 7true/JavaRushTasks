package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";
    //private final static String URL_FORMAT = "ttp://javarush.ru/testdata/big28data.html";
    private static final String userAgent = "Mozilla/5.0 (jsoup)";
    private static final int timeout = 5 * 1000;

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        int pageNumber = 0;
        ArrayList<Vacancy> vacancies = new ArrayList<>();
        while (true) {
            Document doc = getDocument(searchString, pageNumber);
            Elements elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
            if (elements.size() == 0) {
                break;
            }

            for (Element e : elements) {
                Vacancy vacancy = new Vacancy();
                vacancy.setTitle(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                vacancy.setCity(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                vacancy.setCompanyName(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                vacancy.setUrl(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));
                String salary = e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text();
                vacancy.setSalary(salary.length() == 0 ? "" : salary);
                vacancy.setSiteName(String.format(URL_FORMAT, "Киев", pageNumber));
                vacancies.add(vacancy);
            }

            ++pageNumber;
        }

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) {
        try {
            Document doc = Jsoup.connect(String.format(URL_FORMAT, searchString, page)).userAgent(userAgent).referrer("https://hh.ru/").get();
            return doc;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
