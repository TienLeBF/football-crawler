package com.le.crawler.footballcrawler.modal.match;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "team")
public class Team implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name = "name")
	private String name;
	@XmlAttribute(name = "avatar")
	private String avatar;
	@XmlAttribute(name = "goal")
	private String goal;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getGoal() {
		return this.goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

}
