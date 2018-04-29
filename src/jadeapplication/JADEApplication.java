package jadeapplication;

import jade.core.Runtime;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class JADEApplication {

    ContainerController myContainer;

    public static void main(String[] args) {

        JADEApplication jade = new JADEApplication();

        jade.test();

    }

    public void test() {

        //Create the JADE envioenment
        Runtime myRuntime = Runtime.instance();

        Profile myProfile = new ProfileImpl();

        myContainer = myRuntime.createMainContainer(myProfile);

        //Call the RMA GUI
        try {

            AgentController rma = myContainer.createNewAgent("rma", "jade.tools.rma.rma", null);
//            AgentController newWorker = myContainer.createNewAgent("Worker1", "jadeapplication.WorkerAgent", null);
            AgentController newMaster = myContainer.createNewAgent("Master", "jadeapplication.MasterAgent", null);

            rma.start();
//            newWorker.start();
            newMaster.start();

        } catch (StaleProxyException e) {

            e.printStackTrace();

        }

    }

}
