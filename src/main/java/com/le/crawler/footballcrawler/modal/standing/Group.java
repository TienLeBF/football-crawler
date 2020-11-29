package com.le.crawler.footballcrawler.modal.standing;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "group")
public class Group {
	@XmlAttribute(name = "name")
	private String name;
	@XmlAttribute(name = "teams")
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
