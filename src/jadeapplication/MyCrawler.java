package jadeapplication;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyCrawler extends WebCrawler {    
    
    private DBController controller =new DBController();
    
            @Override
            public boolean shouldVisit(Page referringPage, WebURL url) {
                
                    String newURL = url.getURL().toLowerCase();
                    String pageDomain =referringPage.getWebURL().getDomain().toLowerCase();                    
                    return !newURL.contains(pageDomain);
            }
            @Override
            public void visit(Page page) {
              
                 String url = page.getWebURL().getURL();
                 int status =page.getStatusCode();
                 String parent =page.getWebURL().getParentUrl();
                 String anchor =page.getWebURL().getAnchor();                 
                 controller.insert("LINK : "+url+" STATUS : "+status+" TEXT : "+anchor+" FOUND : "+parent);           
            }
            
            @Override
            public void onUnexpectedStatusCode(String urlStr, int statusCode, String contentType,String description){
        try {
            if(statusCode==12007 && Whois.isAvailable(Whois.getUrlDomainName(urlStr))==true){                
                controller.insert("Expired Domain : "+urlStr );
            }
        } catch (IOException ex) {
           
        }
                    
            }
}