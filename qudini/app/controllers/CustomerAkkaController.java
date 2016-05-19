/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import static akka.pattern.Patterns.ask;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import actor.CustomerActor;
import static actor.CustomerActorProtocol.SortCustomers;
import java.util.concurrent.CompletionStage;
import javax.inject.Singleton;
import play.libs.Json;
import play.mvc.Controller;
import static play.mvc.Controller.request;
import play.mvc.Result;
import static play.mvc.Results.ok;
import scala.compat.java8.FutureConverters;

/**
 *
 * @author michael papamichael
 */
@Singleton
public class CustomerAkkaController extends Controller {

    final ActorRef customerActor;

    @Inject
    public CustomerAkkaController(ActorSystem system) {
        customerActor = system.actorOf(CustomerActor.props);
    }

    /**
     * akka actor implementation to retrieve sorted customers
     * @return list of sorted customers
     */
    public CompletionStage<Result> index() {

        JsonNode customerJson = request().body().asJson();

        return FutureConverters.toJava(ask(customerActor, new SortCustomers(customerJson), 1000))
                .thenApply(customerList -> ok(Json.toJson(customerList)));

    }
}
