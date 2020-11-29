package com.le.crawler.footballcrawler.modal.page;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.le.crawler.footballcrawler.modal.leaderboard.LeaderBoardTab;
import com.le.crawler.footballcrawler.modal.match.MatchTab;
import com.le.crawler.footballcrawler.modal.news.NewsTab;
import com.le.crawler.footballcrawler.modal.standing.StandingTab;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "page")
public class Page implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name = "matchs")
	private MatchTab matchs;
	@XmlAttribute(name = "newsTab")
	private NewsTab newsTab;
	@XmlAttribute(name = "leaderBoardTab")
	private LeaderBoardTab leaderBoardTab;
	@XmlAttribute(name = "standingTab")
	private StandingTab standingTab;

	public MatchTab getMatchs() {
		return matchs;
	}

	public void setMatchs(MatchTab matchs) {
		this.matchs = matchs;
	}

	public NewsTab getNewsTab() {
		return newsTab;
	}

	public void setNewsTab(NewsTab newsTab) {
		this.newsTab = newsTab;
	}

	public LeaderBoardTab getLeaderBoardTab() {
		return leaderBoardTab;
	}

	public void setLeaderBoardTab(LeaderBoardTab leaderBoardTab) {
		this.leaderBoardTab = leaderBoardTab;
	}

	public StandingTab getStandingTab() {
		return standingTab;
	}

	public void setStandingTab(StandingTab standingTab) {
		this.standingTab = standingTab;
	}

}
