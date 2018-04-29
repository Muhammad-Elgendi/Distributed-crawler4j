/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadeapplication;

import java.io.Serializable;

/**
 *
 * @author muhammad
 */
public class Job implements Serializable{

    String crawlStorageFolder = "/mnt/Disk/crawlerData";
    int numberOfCrawlers = 141;
    int maxPerHost = 200;
    int maxTotalConnections = 5000;
    String agentName = "seo-spider-beta";
    String[] seeds = {"https://sitesuccessful.com/top-75-free-directories/"};
    
     public Job() {

    }

    public Job(String folder, Integer numberOfCrawlers, Integer maxPerHost, Integer maxTotalConnections, String UserAgentName, String[] seed) {
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

    public Job(String[] seed) {
        if (seed != null) {
            this.seeds = seed;
        }
    }


}
