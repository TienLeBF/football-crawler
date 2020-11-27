package com.le.crawler.footballcrawler.modal.news;

import java.io.Serializable;

public class News implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String url;
    private String title;
    private String namePage;
    private String day;
    private String imageUrl;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getNamePage() {
        return this.namePage;
    }

    public void setNamePage(String namePage) {
        this.namePage = namePage;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
