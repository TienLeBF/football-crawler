package com.le.crawler.footballcrawler.modal.match;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "gameGroup")
public class GameGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name = "name")
	private String name;
	@XmlAttribute(name = "games")
	private List<Game> games;
	
	
	public GameGroup() {
		games = new ArrayList<Game>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
	}

	
}
