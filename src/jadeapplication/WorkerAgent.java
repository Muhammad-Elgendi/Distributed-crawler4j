package jadeapplication;

import jade.core.Agent;

public class WorkerAgent extends Agent {

    @Override
    protected void setup() {

        System.out.println("Agent " + getAID().getName() + " has Started");
        String[] seeds = {"https://sitesuccessful.com/top-75-free-directories/",
            "http://www.egy303.com/eg/",
            "https://www.dm0z.com/",
            "http://www.raddadi.com/",
            "http://dir.m5zn.com/",
            "https://www.202020.net/",
            "https://be-s.cc/",
            "http://www.bettna.com/weblinks/index.asp"
        };
        addBehaviour(new ReceiveBehaviour(this));
//        addBehaviour(new ControllerBehaviour(seeds));
    }

    @Override
    protected void takeDown() {
        System.out.println("Agent " + getAID().getName() + " has went away");
//        doDelete();
    }

}
