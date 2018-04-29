/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadeapplication;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import static jadeapplication.Whois.stringToObject;
import java.io.IOException;


/**
 *
 * @author muhammad
 */
public class ReceiveBehaviour extends CyclicBehaviour {

    public ReceiveBehaviour(WorkerAgent receiver) {
        this.receiver = receiver;        
    }
    
    WorkerAgent receiver;
    
    @Override
    public void action() {

        ACLMessage msg = receiver.receive();
        if (msg != null) {
            String request = msg.getContent();
            try {
                Job myJob = (Job) Whois.fromString(request);
                receiver.addBehaviour(new ControllerBehaviour(myJob));
            } catch (IOException ex) {
                System.out.println("IOError in Receiving ...");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
               System.out.println("NotFoundError in Receiving ...");
            }
        } else {
            block();
        }

    }
}
