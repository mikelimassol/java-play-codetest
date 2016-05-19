/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import play.mvc.Result;
import static play.mvc.Results.ok;
import views.html.*;

/**
 *
 * @author michael papamichael
 */
public class ApplicationController {
    
     /**
     * home page of the application.
     * @return 
     */
    public Result index() {
        return ok(index.render("Page that loads customers from file system and sends to our webservice to get sorted. This example uses basic akka for non blocking"));
    }
    
     /**
     * home page of the application.
     * @return 
     */
    public Result akka() {
        return ok(akka.render("Page that loads customers from file system and sends to our webservice to get sorted. This example uses akka actors for non blocking"));
    }
}
