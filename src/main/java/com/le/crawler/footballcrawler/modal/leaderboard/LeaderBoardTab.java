package com.le.crawler.footballcrawler.modal.leaderboard;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "leaderBoardTab")
public class LeaderBoardTab {
	@XmlAttribute(name = "leaderBoards")
	private List<LeaderBoard> leaderBoards;

	public List<LeaderBoard> getLeaderBoards() {
		return leaderBoards;
	}

	public void setLeaderBoards(List<LeaderBoard> leaderBoards) {
		this.leaderBoards = leaderBoards;
	}
}
