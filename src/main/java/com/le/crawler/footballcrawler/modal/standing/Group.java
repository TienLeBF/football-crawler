package com.le.crawler.footballcrawler.modal.standing;

import java.util.List;

public class Group {
    private String name;
    private List<com.le.crawler.footballcrawler.modal.standing.Team> teams;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.le.crawler.footballcrawler.modal.standing.Team> getTeams() {
        return this.teams;
    }

    public void setTeams(List<com.le.crawler.footballcrawler.modal.standing.Team> teams) {
        this.teams = teams;
    }

}
