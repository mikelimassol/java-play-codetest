/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import service.CustomerService;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import play.libs.Json;
import static play.mvc.Controller.request;
import play.mvc.Result;
import static play.mvc.Results.ok;
import service.CustomerService;

/**
 *
 * @author michael papamichael
 */
public class CustomerController {
    
    @Inject
    CustomerService customerService;
    
    /**
     * akka basic implementation to retrieve sorted customers
     * @return list of sorted customers
     */
    public CompletionStage<Result> index() {
        
        JsonNode customerJson = request().body().asJson();
        
        return CompletableFuture.supplyAsync(() -> customerService.sort(customerJson))
                .thenApply(customerList -> ok(Json.toJson(customerList)));
        
    }
}