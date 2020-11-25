package com.le.crawler.football.run;

import com.le.crawler.football.logic.CrawlerPage1;
import com.le.crawler.football.logic.CrawlerPage2;

public class StartApp {
    public static void main(String[] args) {
        new CrawlerPage1().process();
        new CrawlerPage2().process();
    }
}
