package com.sumit.test.practice.restfulwebservice;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class Filtering {

	@GetMapping(value = "/field")
	public MappingJacksonValue getField(@RequestParam(required = false) String fieldName) {
		MappingJacksonValue mappingVal = new MappingJacksonValue(new ValidateField("test1", "test2", "test3"));

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fieldName);
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("testFilter", filter);
		mappingVal.setFilters(filterProvider);

		return mappingVal;

	}

}
