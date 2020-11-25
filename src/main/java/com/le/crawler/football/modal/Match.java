package com.le.crawler.football.modal;

import java.util.ArrayList;
import java.util.List;

public class Match {
    List<Team> teams;
    private String result;
    private String day;
    private String photoUrlPreview;
    private String videoUrl;
    private String videoTime;

    public Match() {
        this.teams = new ArrayList<Team>();
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getPhotoUrlPreview() {
        return this.photoUrlPreview;
    }

    public void setPhotoUrlPreview(String photoUrlPreview) {
        this.photoUrlPreview = photoUrlPreview;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoTime() {
        return this.videoTime;
    }

    public void setVideoTime(String videoTime) {
        this.videoTime = videoTime;
    }

    public List<Team> getTeams() {
        return this.teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

}
