/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import models.Customer;
import play.libs.Json;
import static play.mvc.Controller.request;
import play.mvc.Result;
import static play.mvc.Results.ok;

/**
 *
 * @author michael papamichael
 */
public class CustomerController {
    
    public CompletionStage<Result> index() {
        
        JsonNode customerJson = request().body().asJson();
        
        return CompletableFuture.supplyAsync(() -> sortCustomers(customerJson))
                .thenApply(customerList -> ok(Json.toJson(customerList)));
        
    }
    
    public List<Customer> sortCustomers(JsonNode customerJson){

        List<Customer> customerList = new ArrayList<>();
        
        customerJson.forEach(customerNode -> {
            customerList.add(Json.fromJson(customerNode, Customer.class));
        });
       
       customerList.sort(Comparator.comparing(e -> e.getDuetime()));
      
       return customerList;
       
    }
    
}
