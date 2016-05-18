/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Service.CustomerService;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import play.libs.Json;
import static play.mvc.Controller.request;
import play.mvc.Result;
import static play.mvc.Results.ok;


import views.html.*;

/**
 *
 * @author michael papamichael
 */
public class CustomerController {
    
    @Inject
    CustomerService customerService;
    
    /**
     * Api entry point
     * @return 
     */
    public CompletionStage<Result> index() {
        
        JsonNode customerJson = request().body().asJson();
        
        return CompletableFuture.supplyAsync(() -> customerService.sort(customerJson))
                .thenApply(customerList -> ok(Json.toJson(customerList)));
        
    }
}