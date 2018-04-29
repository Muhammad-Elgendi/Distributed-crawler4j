package jadeapplication;

import jade.core.AID;
import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MasterAgent extends Agent {

    ContainerController myContainer;

    @Override
    protected void setup() {
        //Create the JADE envioenment
        jade.core.Runtime myRuntime = jade.core.Runtime.instance();

        Profile myProfile = new ProfileImpl();

        myContainer = myRuntime.createAgentContainer(myProfile);
        System.out.println("Agent " + getAID().getName() + " has Started");
        AgentController createNewAgent;
         AgentController createNewAgent2;
          AgentController createNewAgent3;
           AgentController createNewAgent4;
        try {
            createNewAgent = myContainer.createNewAgent("Worker1", "jadeapplication.WorkerAgent", null);
            createNewAgent.start();
             createNewAgent2 = myContainer.createNewAgent("Worker2", "jadeapplication.WorkerAgent", null);
            createNewAgent2.start();
             createNewAgent3 = myContainer.createNewAgent("Worker3", "jadeapplication.WorkerAgent", null);
            createNewAgent3.start();
             createNewAgent4 = myContainer.createNewAgent("Worker4", "jadeapplication.WorkerAgent", null);
            createNewAgent4.start();
        } catch (StaleProxyException ex) {
           
        }        
        AID[] receivers = {new AID("Worker1", AID.ISLOCALNAME)};
        String[] seeds = {
        "https://www.tutorialspoint.com/seo/seo-useful-resources.htm",
        "http://www.seobook.com/",
        "https://www.webpageone.co.uk/global-seo.php",
        "http://websitetips.com/seo/resources/",
        "http://seo-resources.seo-index.com/",
        "http://seo-resources.seo-index.com/seo-tools/",
        "http://www.searchenginesbook.com/resources.html",
        "http://www.ranksmart.com/resources.html",
        "http://www.seochat.com/",
        "http://www.toprankblog.com/online-marketing-blog-resources/",
        "https://www.beanstalkim.com/learn/resources/",
        "http://www.getinposition.com/seo-resources.html",
        "http://www.getinposition.com/seo-resources-profitable-website.html",
        "http://www.salientmarketing.com/seo-resources/search-engine-history/grandfather-search-engine.html",
        "http://findmefaster.com/Search-Engine-Marketing-Tools.htm",
        "https://moz.com/seo-expert-quiz",
        "http://www.seopros.org/best-practices-references-resources/",
        "http://www.sem-advance.com/search-engine-optimization-resources.htm",
        "https://www.marketingterms.com/dictionary/search_engine_optimization/",
        "https://internetmarketingclt.com/about-us/resources/",
        "https://searchenginewatch.com/static/resources",
        "https://www.anvilmediainc.com/marketing-resources/articles/three-cs-of-search-engine-optimization-article/",
        "http://www.raisemyrank.com/seo-resources.htm",
        "http://oedb.org/ilibrarian/research-beyond-google/"            
        };
        Job job =new Job(seeds);
        addBehaviour(new SendBehaviour(this, receivers,job));
          AID[] receivers2 = {new AID("Worker2", AID.ISLOCALNAME)};
        String[] seeds2 = {
      "http://www.link-exchange.ws/seo-resources.htm",
"http://www.firstclickinc.com/online-marketing-resources/seo-glossary/",
"http://www.seo-asia.net/resources.html",
"http://www.arford.com/seo-resources",
"https://problogger.com/search-engine-optimization-tips-for-bloggers/",
"https://www.webduckdesigns.com/pages/resources.php",
"https://searchengineland.com/5-million-domain-sale-for-seocom-11506",
"http://www.ebizboosters.com/resources_seo.html",
"http://www.googlerank.com/",
"http://www.platgroupng.com/resources.php",
"https://www.conductor.com/",
"http://seonucleus.com/",
"http://www.maximumhit.com/webpartners.html",
"http://www.dotexcel.com.au/resource/seo.php",
"https://www.koozai.com/blog/search-marketing/seo-resources/top-search-engine-share/",
"http://www.seo-e.com/",
"https://uncw.edu/career/marketing.html",
"http://floodhammer.com/",
"https://www.udemy.com/whiteboard-seo/",
"http://www.seodesignsolutions.com/blog/about/",
"https://patientxagency.com/resources/",
"https://www.seoadvantage.com/about-seo-advantage.htm",
"http://www.onweb.co.in/contact_us.html",
"https://www.tampa-seo.com/faqs/",
"http://seo-tutorial.seoadministrator.com/"        
        };
        Job job2 =new Job(seeds2);
        addBehaviour(new SendBehaviour(this, receivers2,job2));
          AID[] receivers3 = {new AID("Worker3", AID.ISLOCALNAME)};
        String[] seeds3 = {
          "http://www.iseo-eur.com/resources.php",
"http://www.orientindia.biz/seo.aspx",
"http://www.seosix.org/",
"http://www.cyber-key.com/webmaster-resources.html",
"https://www.rit.edu/seo/",
"https://it.wisc.edu/about/division-of-information-technology/doit-departments/systems-engineering-and-operations-seo/",
"http://www.indianwebseo.com/resources/",
"https://www.addme.com/",
"https://luiscalmeida.info/resources/",
"https://www.ewebresults.com/site-map",
"http://www.highrankings.com/seo-faq",
"http://www.search-engines-optimization.com/seo-resources-1.html",
"http://immunoeresearch.com/about-us/resources/",
"http://www.minimalistic-design.info/traffic-seo/",
"http://www.suncoastmarketing.com/services/internet-marketing/search-engine-optimization-seo/",
"https://codex.wordpress.org/Search_Engine_Optimization_for_Wordpress",
"http://www.seovoices.com/interesting-resources/",
"https://www.internetmarketingninjas.com/marketing-resources/",
"http://www.akamaiseo.com/seo-blog/",
"http://www.websearchworkshop.co.uk/resources/",
"https://www.ama.org/volunteers/Chapter-Resources/Pages/Chapter-Resources.aspx",
"http://kenkai.com/uk-edinburgh-web-design.htm",
"http://www.01webdirectory.com/marketing_advertising_info.htm"


        };
        Job job3 =new Job(seeds3);
        addBehaviour(new SendBehaviour(this, receivers3,job3));
          AID[] receivers4 = {new AID("Worker4", AID.ISLOCALNAME)};
        String[] seeds4 = {
             "https://www.kentico.com/product/resources/whitepapers/how-kentico-cms-makes-seo-easy",
"http://www.capturecommerce.com/evaluate-backlinks.php",
"http://tibswebdevelopment.com/marketing/search-engine-optimization/",
"http://www.stevenforsyth.com/sitemap.htm",
"http://www.synthium.net/links/links.html",
"https://www.macronimous.com/resources/SEO-Life-Cycle.asp",
"http://www.microsysinfomedia.com/resource1.html",
"http://www.yo-so.com/online-marketing-resources-center.html",
"http://www.optimisations.co.uk/useful-resources.html",
"https://www.visualscope.com/seo-sem.html",
"http://www.seojobsfinder.com/article_2.html",
"http://www.anblik.com/review-category/best-webmaster-tools-and-resources/",
"http://www.websitemarketingplan.com/sem/",
"https://www.spritzweb.com/resources/good-website-characteristics.html",
"https://www.savit.in/outsourcing-india.asp",
"https://www.htmlvalidator.com/htmlval/resources.html",
"http://www.ladezign.net/digital-marketing-services/seo-search-engine-optimization/",
"https://www.searchenginejournal.com/11-steps-to-successful-seo-for-your-business/6112/",
"http://www.searchengineworkshops.com/partners.html",
"http://seo.uy/",
"http://www.cumbrowski.com/CarstenC/seosem_keyword_research.asp",
"http://websitehelpers.com/seo/",
"http://www.egnosis.co.il/seo.html",
"http://www.springboardseo.com/resources/google-algorithm-updates/2003.html",
"https://www.searchwarrant.ca/why-seo/",
"https://seranking.co.uk/",
"https://www.wiley.com/en-us/Professional+Search+Engine+Optimization+with+PHP%3A+A+Developer%27s+Guide+to+SEO-p-9780470100929"
        };
        Job job4 =new Job(seeds4);
        addBehaviour(new SendBehaviour(this, receivers4,job4));
    }

    @Override
    protected void takeDown() {
        System.out.println("Agent " + getAID().getName() + " has went away");
//        doDelete();
        /*
         * TODO : Notify the center
         */
    }
}
