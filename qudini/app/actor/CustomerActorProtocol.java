/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actor;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;
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
            customerList = new ArrayList<>();

            customerJson.forEach(customerNode -> {
                customerList.add(Json.fromJson(customerNode, Customer.class));
            });

            customerList.sort((c1, c2) -> c1.getDueTime().compareTo(c2.getDueTime()));
        }
        
    }
}
