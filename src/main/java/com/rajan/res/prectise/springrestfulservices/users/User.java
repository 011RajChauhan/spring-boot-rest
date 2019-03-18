package com.rajan.res.prectise.springrestfulservices.users;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "all details about user")
public class User {


    private int id;

    @Size(min=2, message = "name should at least contain two characters.")
    @NotNull(message = "name must is required")
    @ApiModelProperty(notes = "name should be more than 2 characters")
    private String name;

    @Past(message = "date of birth cannot be future date.")
    @NotNull(message = "date is required")
    @ApiModelProperty(notes = "birthdate should be less then current time")
    private Date dob;

    public User(String name, int id, Date dob) {
        this.name = name;
        this.id = id;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
