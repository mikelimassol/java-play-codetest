/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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
    private DateTime duetime;
    
    @JsonSerialize(using =  JodaDateTimeSerializer.class)
    @JsonDeserialize(using = JodaDateTimeDeserializer.class)
    private DateTime jointime;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
    
   
    public DateTime getDuetime() {
        return duetime;
    }

    public void setDuetime(final DateTime dueTime) {
        this.duetime = dueTime;
    }
    
       
    public DateTime getJointime() {
        return jointime;
    }

    public void setJoinTime(final DateTime joinTime) {
        this.jointime = joinTime;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", duetime=" + duetime + ", jointime=" + jointime + '}';
    }
      
}