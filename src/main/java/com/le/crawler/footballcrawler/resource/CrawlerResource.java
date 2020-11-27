package com.le.crawler.footballcrawler.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.le.crawler.footballcrawler.logic.CrawlerPage1;
import com.le.crawler.footballcrawler.modal.match.CricleMatch;
import com.le.crawler.footballcrawler.modal.match.CricleMatchs;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "crawler")
@Path("/crawler")
public class CrawlerResource {
	@GET
	@Produces("application/json")
	public CricleMatchs getAllCricleMatchs() {
		CricleMatchs cricleMatchs = new CricleMatchs();
		
		List<CricleMatch> data =  new CrawlerPage1().process();
		cricleMatchs.setCricleMatchs(data);
		return cricleMatchs;
	}
}
