package com.le.crawler.footballcrawler.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.le.crawler.footballcrawler.resource.CrawlerResource;

@Component
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(CrawlerResource.class);
	}
}