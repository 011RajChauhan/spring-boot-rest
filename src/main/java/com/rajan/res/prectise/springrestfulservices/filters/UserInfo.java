package com.rajan.res.prectise.springrestfulservices.filters;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//annotation used at class level to ignore properties on sending response.
@JsonIgnoreProperties({"lastName"})
public class UserInfo {
    //annotation used to skip sending property in response.
    @JsonIgnore
    private String contact;
    private String firstName;
    private String lastName;
    public UserInfo(String contact, String firstName, String lastName) {
        this.contact = contact;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
