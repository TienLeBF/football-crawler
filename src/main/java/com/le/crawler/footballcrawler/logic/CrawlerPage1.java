package com.le.crawler.footballcrawler.logic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.le.crawler.footballcrawler.modal.match.CricleMatch;

public class CrawlerPage1 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = null;
        try {
            String path = "/home/le/hjhj/test.txt";
            File file = new File(path);
            if (!file.getParentFile().exists()) {
                System.out.println("Directory contain file not exists -> create " + file.getPath());
                file.getParentFile().mkdirs();
            }
            Gson gson = new Gson();
            String json = "123";
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(json.getBytes());
        } catch (Exception e) {
            fileOutputStream.close();
            // TODO: handle exception
        }
    }

    public List<CricleMatch> process() {
        String url = "https://www.google.com/search?sxsrf=ALeKk02SuH34OswVCiUwOVJjOM5dhEDXwQ%3A1605506341928&ei=JRWyX7KNOIaJmAWzn7eoBQ&q=africa+cup+2019&oq=afr&gs_lcp=CgZwc3ktYWIQARgAMgQIIxAnMgQIIxAnMgQIIxAnMgcIABDJAxBDMgQILhBDMgQIABBDMgQIABBDMgQIABBDMgIIADICCAA6BwgjEMkDECc6BwguELEDEEM6CAgAELEDEIMBOg0ILhCxAxCDARAUEIcCOgoILhCxAxAUEIcCOgUIABCxA1C-C1i-C2DQEmgAcAB4AIABaYgBzwGSAQMwLjKYAQCgAQGqAQdnd3Mtd2l6wAEB&sclient=psy-ab#sie=lg;/m/0r3tvzw;2;/m/01l5zn;mt;fp;1;;";
        List<CricleMatch> data = null;
        try {
            data = new ArrayList<>(); // CrawlerCommon().processMatch(url);
            String path = "";
            File file = new File(path);
            if (file.getParentFile().exists()) {
                System.out.println("Directory contain file not exists -> create " + file.getPath());
                file.getParentFile().mkdirs();
            }
            Gson gson = new Gson();
            String json = gson.toJson(data);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(json.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}
