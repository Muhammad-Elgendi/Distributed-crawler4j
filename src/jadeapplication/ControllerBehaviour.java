/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadeapplication;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import jade.core.behaviours.Behaviour;

public class ControllerBehaviour extends Behaviour {

    String crawlStorageFolder = "/mnt/Disk/crawlerData";
    int numberOfCrawlers = 141;
    int maxPerHost = 200;
    int maxTotalConnections = 5000;
    String agentName = "seo-spider-beta";
    String[] seeds = {"https://sitesuccessful.com/top-75-free-directories/"};

    public ControllerBehaviour() {

    }

    public ControllerBehaviour(String folder, Integer numberOfCrawlers, Integer maxPerHost, Integer maxTotalConnections, String UserAgentName, String[] seed) {
        if (folder != null) {
            this.crawlStorageFolder = folder;
        }
        if (numberOfCrawlers != null) {
            this.numberOfCrawlers = numberOfCrawlers;
        }
        if (maxPerHost != null) {
            this.maxPerHost = maxPerHost;
        }
        if (maxTotalConnections != null) {
            this.maxTotalConnections = maxTotalConnections;
        }
        if (UserAgentName != null) {
            this.agentName = UserAgentName;
        }
        if (seed != null) {
            this.seeds = seed;
        }
    }
    
       public ControllerBehaviour(Job myJob) {
           this.agentName=myJob.agentName;
           this.crawlStorageFolder=myJob.crawlStorageFolder;
           this.maxPerHost=myJob.maxPerHost;
           this.maxTotalConnections=myJob.maxTotalConnections;
           this.numberOfCrawlers=myJob.numberOfCrawlers;
           this.seeds=myJob.seeds;
    }

    public ControllerBehaviour(String[] seed) {
        if (seed != null) {
            this.seeds = seed;
        }
    }

    @Override
    public void action() {

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setMaxConnectionsPerHost(maxPerHost);
        config.setMaxTotalConnections(maxTotalConnections);
        config.setRespectNoFollow(false);
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        robotstxtConfig.setUserAgentName(agentName);
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        try {
            CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
            controller.addSeed(seeds[0]);

            controller.startNonBlocking(() -> {
                return new MyCrawler();
            }, numberOfCrawlers);
            if(seeds.length > 1){    
                for(int i = 1 ; i< seeds.length ;i++){
                    controller.addSeed(seeds[i]);
                }                
            }
            controller.waitUntilFinish();
        } catch (Exception e) {
        }
    }

    @Override
    public boolean done() {
        return true;
    }
}
