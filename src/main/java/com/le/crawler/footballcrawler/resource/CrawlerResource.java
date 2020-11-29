package com.le.crawler.footballcrawler.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.le.crawler.footballcrawler.logic.CrawlerPage1;
import com.le.crawler.footballcrawler.modal.match.GameGroup;
import com.le.crawler.footballcrawler.modal.match.Matchs;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "crawler")
@Path("/crawler")
public class CrawlerResource {
	@GET
	@Produces("application/json")
	public Matchs getAllCricleMatchs() {
		Matchs cricleMatchs = new Matchs();
		
		List<GameGroup> data =  new CrawlerPage1().process();
		cricleMatchs.setmatchs(data);
		return cricleMatchs;
	}
}
