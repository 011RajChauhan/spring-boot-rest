package com.rajan.res.prectise.springrestfulservices.filters;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

    @GetMapping("/filter")
    public UserInfo getFilterProperties(){
        return new UserInfo("9999697177","rajan","chauhan");
    }
}
