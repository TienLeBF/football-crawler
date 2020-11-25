package com.le.crawler.football.modal;

import java.util.ArrayList;
import java.util.List;

public class CricleMatch {
    private String name;
    private List<Match> matchs;

    public CricleMatch() {
        this.matchs = new ArrayList<Match>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Match> getMatchs() {
        return this.matchs;
    }

    public void setMatchs(List<Match> matchs) {
        this.matchs = matchs;
    }

}
