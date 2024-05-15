package br.com.ebanx.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Event {

 private Account destination;
 @JsonIgnore
 private String type;

    public Account getDestination() {
        return destination;
    }

    public void setDestination(Account destination) {
        this.destination = destination;
            }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
