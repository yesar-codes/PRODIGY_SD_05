package com.prodigyinfotech;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScrapper {

    private static final String WEBSITE_TO_SCRAPE = "https://books.toscrape.com/";
    private static final String QUERY_CLASS_FOR_PRODUCT = ".product_pod";
    private static final String TITLE_OF_FILE = "Web-Scrapper for books";
    private static final String COMMA_SEPARATOR = ",";

    public static void main(String[] args) {

        try {
            Document document = Jsoup.connect(WEBSITE_TO_SCRAPE).get(); //Using the DOM API of Jsoup.
            Elements books = document.select(QUERY_CLASS_FOR_PRODUCT);
            //We use cssQuery to target the class through which all the books are assigned.

            System.out.println(TITLE_OF_FILE);
            for (Element book : books) {
                String title = book.select("h3 > a").text();
                //selecting the products title as they were stored in the 3rd header tag and in anchor html tag
                String price = book.select(".price_color").text();
                //selecting the price as the price tag was stored in the price color class

                System.out.println(title + COMMA_SEPARATOR + price);
            }
        } catch (IOException exception) {
            //When the above URL will fail then this input output exception will occur.
            System.err.println(exception.getMessage());
        }
    }
}
