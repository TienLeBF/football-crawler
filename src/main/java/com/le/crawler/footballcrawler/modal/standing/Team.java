package com.le.crawler.footballcrawler.modal.standing;

import java.io.Serializable;

public class Team implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String stt;
    private String imageUrl;
    private String points;
    private String result;

    public String getStt() {
        return this.stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPoints() {
        return this.points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
