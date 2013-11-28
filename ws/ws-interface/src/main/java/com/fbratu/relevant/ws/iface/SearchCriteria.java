package com.fbratu.relevant.ws.iface;

import java.io.Serializable;

/**
 * Author: Florin
 */
public class SearchCriteria implements Serializable{

    private String location;

    public SearchCriteria() {
    }

    public SearchCriteria(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
