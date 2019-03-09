package com.rajan.res.prectise.springrestfulservices.users;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {


    private int id;

    @Size(min=2, message = "name should at least contain two characters.")
    @NotNull(message = "name must is required")
    private String name;

    @Past(message = "date of birth cannot be future date.")
    @NotNull(message = "date is required")
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
