package com.le.crawler.footballcrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FootballCrawlerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		// SpringApplication.run(FootballCrawlerApplication.class, args);
		new FootballCrawlerApplication().configure(new SpringApplicationBuilder(FootballCrawlerApplication.class)).run(args);
	}

}
