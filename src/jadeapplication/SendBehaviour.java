/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadeapplication;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author muhammad
 */
public class SendBehaviour extends Behaviour {
    MasterAgent sender;
    AID[] receivers;
    Job job;

    public SendBehaviour(MasterAgent sender,AID[] receivers,Job job) {
        this.sender=sender;
        this.receivers=receivers;
        this.job=job;
    }
    
    

    @Override
    public void action() {
        System.out.println("Sending a job ....");
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        for (int i = 0; i < receivers.length; ++i) {
            msg.addReceiver(receivers[i]);
        }
        try {
            msg.setContent(Whois.toString(job));
        } catch (IOException ex) {
            System.out.println("Error in send Behaviour");
        }
        sender.send(msg);
    }

    @Override
    public boolean done() {
        return true;
    }

}
