package com.le.crawler.footballcrawler.modal.standing;

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
	@XmlAttribute(name = "stt")
	private String stt;
	@XmlAttribute(name = "imageUrl")
	private String imageUrl;
	@XmlAttribute(name = "points")
	private String points;
	@XmlAttribute(name = "result")
	private String result;

	public String getStt() {
		return this.stt;
	}

	public void setStt(String stt) {
		this.stt = stt;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPoints() {
		return this.points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
