/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;
import models.Customer;
import play.libs.Json;
import service.CustomerService;

/**
 *
 * @author michael papamichael
 */
public class CustomerServiceImpl implements CustomerService {


    @Override
    public List<Customer> sort(JsonNode customerJson) {
        List<Customer> customerList = new ArrayList<>();

        customerJson.forEach(customerNode -> {
            customerList.add(Json.fromJson(customerNode, Customer.class));
        });

        customerList.sort((c1, c2) -> c1.getDueTime().compareTo(c2.getDueTime()));

        return customerList;

    }
}
