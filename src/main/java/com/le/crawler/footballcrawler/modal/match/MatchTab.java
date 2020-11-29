package com.le.crawler.footballcrawler.modal.match;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "matchTab")
public class MatchTab {

	@XmlElement(name = "matchs")
	private List<GameGroup> matchs;

	public List<GameGroup> getmatchs() {
		return matchs;
	}

	public void setmatchs(List<GameGroup> matchs) {
		this.matchs = matchs;
	}

}
