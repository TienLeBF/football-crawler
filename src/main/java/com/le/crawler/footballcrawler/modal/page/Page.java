package com.le.crawler.footballcrawler.modal.page;

import java.io.Serializable;

import com.le.crawler.footballcrawler.modal.leaderboard.LeaderBoards;
import com.le.crawler.footballcrawler.modal.match.Matchs;
import com.le.crawler.footballcrawler.modal.news.NewsPage;
import com.le.crawler.footballcrawler.modal.standing.Standings;

public class Page implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Matchs matchs;
	private NewsPage newsPage;
	private LeaderBoards leaderBoards;
	private Standings standings;

	public Matchs getMatchs() {
		return matchs;
	}

	public void setMatchs(Matchs matchs) {
		this.matchs = matchs;
	}

	public NewsPage getNewsPage() {
		return newsPage;
	}

	public void setNewsPage(NewsPage newsPage) {
		this.newsPage = newsPage;
	}

	public LeaderBoards getLeaderBoards() {
		return leaderBoards;
	}

	public void setLeaderBoards(LeaderBoards leaderBoards) {
		this.leaderBoards = leaderBoards;
	}

	public Standings getStandings() {
		return standings;
	}

	public void setStandings(Standings standings) {
		this.standings = standings;
	}

}
