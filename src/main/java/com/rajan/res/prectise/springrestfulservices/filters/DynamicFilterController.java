package com.rajan.res.prectise.springrestfulservices.filters;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DynamicFilterController {

    @GetMapping("filterOne")
    public MappingJacksonValue firstFilterType(){
        SomeBean someBean = new SomeBean("value1","value2","value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("filterTwo")
    public MappingJacksonValue secondFilterType(){
        List<SomeBean> someBeanList = Arrays.asList(new SomeBean("value1","value2","value3"), new SomeBean("value34","value45","value234")
                ,new SomeBean("value11111","value22222","value33333"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(someBeanList);
        mapping.setFilters(filters);

        return mapping;
    }


}
