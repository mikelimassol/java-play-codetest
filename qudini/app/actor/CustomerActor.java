/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actor;

import akka.actor.Props;
import akka.actor.UntypedActor;


/**
 *
 * @author michael papamichael
 */
public class CustomerActor extends UntypedActor {

    public static Props props = Props.create(CustomerActor.class);
   
    public void onReceive(Object msg) throws Exception {
        if (msg instanceof CustomerActorProtocol.SortCustomers) {
            sender().tell(((CustomerActorProtocol.SortCustomers) msg).customerList, self());
        }
    }
}

