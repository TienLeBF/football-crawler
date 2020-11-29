package com.le.crawler.footballcrawler.modal.leaderboard;

import java.io.Serializable;

public class Player implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rank;
	private String name;
	private String imageUrl;
	private String team;
	private String counts;
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getCounts() {
		return counts;
	}
	public void setCounts(String counts) {
		this.counts = counts;
	}
	
}
