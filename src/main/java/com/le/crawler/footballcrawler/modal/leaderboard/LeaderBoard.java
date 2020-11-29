package com.le.crawler.footballcrawler.modal.leaderboard;

import java.util.List;

public class LeaderBoard {
	private String title;
	private List<Player> player;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Player> getPlayer() {
		return player;
	}
	public void setPlayer(List<Player> player) {
		this.player = player;
	}
}
