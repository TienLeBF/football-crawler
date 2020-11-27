package com.le.crawler.footballcrawler.modal.match;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "cricleMatchs")
public class CricleMatchs {

	@XmlElement(name = "cricleMatch")
	private List<CricleMatch> cricleMatchs;

	public List<CricleMatch> getCricleMatchs() {
		return cricleMatchs;
	}

	public void setCricleMatchs(List<CricleMatch> cricleMatchs) {
		this.cricleMatchs = cricleMatchs;
	}

}
