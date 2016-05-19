/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actor;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import models.Customer;
import play.libs.Json;

/**
 *
 * @author michael papamichael
 */
public class CustomerActorProtocol {

    public static class SortCustomers {
        
        public final List<Customer> customerList;

        public SortCustomers(JsonNode customerJson) {
            List<Customer> customerNotSortedList = new ArrayList<>();

            customerJson.forEach(customerNode -> {
                customerNotSortedList.add(Json.fromJson(customerNode, Customer.class));
            });
          
            Comparator<Customer> byDueTime = (c1, c2) -> c1.getDueTime().compareTo(c2.getDueTime());
            
            customerList = customerNotSortedList.parallelStream().sorted(byDueTime) .collect(Collectors.toList());  
            
        }
        
    }
}
