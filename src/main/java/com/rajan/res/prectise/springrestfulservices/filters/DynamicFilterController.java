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
        return  executeFilter("SomeBeanFilter",Arrays.asList("value1"),someBean);
    }

    @GetMapping("filterTwo")
    public MappingJacksonValue secondFilterType(){
        List<SomeBean> someBeanList = Arrays.asList(new SomeBean("value1","value2","value3"), new SomeBean("value34","value45","value234")
                ,new SomeBean("value11111","value22222","value33333"));

        return executeFilter("SomeBeanFilter",Arrays.asList("value1","value3"),null);
    }

    private MappingJacksonValue executeFilter(String filterName,List<String> filteredValues,SomeBean bean){

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(filteredValues.iterator().next());
        FilterProvider filters = new SimpleFilterProvider().addFilter(filterName,filter);
        MappingJacksonValue mapping = new MappingJacksonValue(bean);
        mapping.setFilters(filters);
        return mapping;
    }


}
