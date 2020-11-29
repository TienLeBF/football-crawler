package com.le.crawler.footballcrawler.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.le.crawler.footballcrawler.logic.CrawlerCommon;
import com.le.crawler.footballcrawler.modal.page.Page;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "crawler")
@Path("/crawler")
public class CrawlerResource {
	@GET
	@Produces("application/json")
	public Page getAllCricleMatchs() {
		String url1 = "https://www.google.com/search?sxsrf=ALeKk02SuH34OswVCiUwOVJjOM5dhEDXwQ%3A1605506341928&ei=JRWyX7KNOIaJmAWzn7eoBQ&q=africa+cup+2019&oq=afr&gs_lcp=CgZwc3ktYWIQARgAMgQIIxAnMgQIIxAnMgQIIxAnMgcIABDJAxBDMgQILhBDMgQIABBDMgQIABBDMgQIABBDMgIIADICCAA6BwgjEMkDECc6BwguELEDEEM6CAgAELEDEIMBOg0ILhCxAxCDARAUEIcCOgoILhCxAxAUEIcCOgUIABCxA1C-C1i-C2DQEmgAcAB4AIABaYgBzwGSAQMwLjKYAQCgAQGqAQdnd3Mtd2l6wAEB&sclient=psy-ab#sie=lg;/m/0r3tvzw;2;/m/01l5zn;mt;fp;1;;";
		String url2 = "https://www.google.com/search?sxsrf=ALeKk02nHRdKjmNiuHkno7qiEAgKx_evpQ%3A1605265066917&ei=qmauX8a7N8uB-Qa9k5DoBw&q=afc+champion+league&oq=AFC&gs_lcp=CgZwc3ktYWIQARgAMgQIIxAnMggILhDJAxCRAjIFCAAQkQIyBAgAEEMyBAguEEMyBAgAEEMyBAguEEMyBAgAEEMyBwgAEBQQhwIyCggAELEDEIMBEAo6BwgAEMkDEEM6AgguOgsILhCxAxDHARCjAjoFCAAQsQM6CAgAELEDEIMBOg0ILhCxAxDHARCjAhBDOgoILhDHARCjAhBDOgsILhCxAxDHARCvAToKCC4QxwEQrwEQQzoCCAA6CAguEMcBEK8BOgcIABCxAxBDOgcILhCxAxBDUIA-WPVXYMpkaANwAXgAgAGaAYgBvQaSAQMwLjaYAQCgAQGqAQdnd3Mtd2l6wAEB&sclient=psy-ab#sie=lg;/g/11fk8dhgv3;2;/m/042gf2;mt;fp;1;;";
		return new CrawlerCommon().process(url1);
	}
}
