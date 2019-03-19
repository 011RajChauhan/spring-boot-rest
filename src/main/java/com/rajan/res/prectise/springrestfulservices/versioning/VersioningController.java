package com.rajan.res.prectise.springrestfulservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    /*example of URI versioning*/

    @GetMapping("person/uri1")
    public Person uri1(){
        return new Person("rajan chauhan");
    }

    @GetMapping("person/uri2")
    public PersonTwo uri2(){
        return new PersonTwo(new Name("sandeep","Chauhan"));
    }

    /*end of URI versioning*/

    /*parameter versioning*/
    @GetMapping(value = "person/param", params = "version=1")
    public Person parama1() {
        return new Person("rajan chauhan");
    }

    @GetMapping(value = "person/param", params = "version=2")
    public PersonTwo param2(){
        return new PersonTwo(new Name("sandeep","Chauhan"));
    }

    /*end of parameter versioning*/

    /*header versioning*/
    @GetMapping(value = "person/header", headers = "p-version=1")
    public Person header1() {
        return new Person("rajan chauhan");
    }

    @GetMapping(value = "person/header", headers = "p-version=2")
    public PersonTwo header2(){
        return new PersonTwo(new Name("sandeep","Chauhan"));
    }

    /*end of mime versioning*/

    /*header versioning*/
    @GetMapping(value = "person/mime", produces = "application/vnd.company.app-v1+json")
    public Person mime1() {
        return new Person("rajan chauhan");
    }

    @GetMapping(value = "person/mime", produces = "application/vnd.company.app-v2+json")
    public PersonTwo mime2(){
        return new PersonTwo(new Name("sandeep","Chauhan"));
    }

    /*end of mime versioning*/
}
