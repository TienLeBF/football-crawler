package com.le.crawler.footballcrawler.modal.match;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "cricleMatch")
public class CricleMatch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name = "name")
	private String name;
	@XmlAttribute(name = "matchs")
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
