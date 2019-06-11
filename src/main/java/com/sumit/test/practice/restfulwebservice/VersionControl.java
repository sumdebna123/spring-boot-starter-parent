package com.sumit.test.practice.restfulwebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionControl {
	@GetMapping("v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Sumit Debnath");
	}
	
	@GetMapping("v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2("Sumit" ,"Debnath");
	}
	
	@GetMapping(value ="/person/param", params ="version=1")
	public PersonV1 getPersonParamV1() {
		return new PersonV1("Sumit Debnath");
	}
	
	@GetMapping(value ="/person/param", params ="version=2")
	public PersonV2 getPersonParamV2() {
		return new PersonV2("Sumit" ,"Debnath");
	}
	
	@GetMapping(value ="/person/header", headers ="header-version=1")
	public PersonV1 getPersonHeaderV1() {
		return new PersonV1("Sumit Debnath");
	}
	
	@GetMapping(value ="/person/header", headers ="header-version=2")
	public PersonV2 getPersonHeaderV2() {
		return new PersonV2("Sumit" ,"Debnath");
	}

}
