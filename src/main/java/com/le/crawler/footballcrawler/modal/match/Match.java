package com.le.crawler.footballcrawler.modal.match;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "match")
public class Match implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name = "teams")
    List<Team> teams;
	@XmlAttribute(name = "result")
    private String result;
	@XmlAttribute(name = "day")
    private String day;
	@XmlAttribute(name = "photoUrlPreview")
    private String photoUrlPreview;
	@XmlAttribute(name = "videoUrl")
    private String videoUrl;
	@XmlAttribute(name = "videoTime")
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
