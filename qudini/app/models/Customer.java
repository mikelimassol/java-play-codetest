/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import models.serializers.JodaDateTimeDeserializer;
import models.serializers.JodaDateTimeSerializer;
import org.joda.time.DateTime;

/**
 *
 * @author michael papamichael
 */
public class Customer {
    
    private Long id;
    
    private String name;
    
    @JsonSerialize(using =  JodaDateTimeSerializer.class)
    @JsonDeserialize(using =  JodaDateTimeDeserializer.class)
    @JsonProperty("duetime")
    private DateTime dueTime;
    
    @JsonSerialize(using =  JodaDateTimeSerializer.class)
    @JsonDeserialize(using = JodaDateTimeDeserializer.class)
    @JsonProperty("jointime")
    private DateTime joinTime;

    /**
     * 
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(final String name) {
        this.name = name;
    }
    
   /**
    * 
    * @return 
    */
    public DateTime getDueTime() {
        return dueTime;
    }

    /**
     * 
     * @param dueTime 
     */
    public void setDueTime(final DateTime dueTime) {
        this.dueTime = dueTime;
    }
    
    /**
     * 
     * @return join Time
     */
    public DateTime getJoinTime() {
        return joinTime;
    }

    /**
     * 
     * @param joinTime 
     */
    public void setJoinTime(final DateTime joinTime) {
        this.joinTime = joinTime;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", duetime=" + dueTime + ", jointime=" + joinTime + '}';
    }
      
}