package com.le.crawler.footballcrawler.modal.news;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "newsTab")
public class NewsTab {
	@XmlAttribute(name = "manyNews")
	private List<News> manyNews;

	public List<News> getManyNews() {
		return this.manyNews;
	}

	public void setManyNews(List<News> manyNews) {
		this.manyNews = manyNews;
	}
}
