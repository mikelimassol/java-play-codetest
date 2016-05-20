/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.ImplementedBy;
import java.util.List;
import models.Customer;
import service.impl.CustomerServiceImpl;

/**
 *
 * @author michael papamichael
 */
@ImplementedBy(CustomerServiceImpl.class)
public interface CustomerService {
    
     /**
     * Accepts JsonNode for customers and returns a list of sorted customers
     * @param customerJson
     * @return 
     */
     List<Customer> sort(JsonNode customerJson);
     
}
