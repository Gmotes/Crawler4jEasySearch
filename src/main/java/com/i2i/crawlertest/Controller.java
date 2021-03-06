/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2i.crawlertest;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
 
public class Controller {
    public static void main(String[] args) throws Exception {
        String crawlStorageFolder = "/crawler/testdata";
        int numberOfCrawlers = 4;
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setPolitenessDelay(1000);
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
        controller.addSeed("http://www.gittigidiyor.com/");
        controller.start(Crawler.class, numberOfCrawlers);
    }
}
