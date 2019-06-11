package com.sumit.test.practice.restfulwebservice;

import java.util.List;
import java.util.Locale;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorld {
	
	@Autowired
	public UserDao service;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path="/hello-world1")
	public String helloWorld() {
		return "Hello World 1";
	}
	
	@GetMapping(path="/hello-world-i18n")
	public String helloWorldi18n() {
		return messageSource.getMessage("good.morning.message", null,LocaleContextHolder.getLocale());
	}
	
	@GetMapping(path="/allUsers")
	public List<User> getAllUser(){
		return service.findAll();
		
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path="hello-world-bean/path-var/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello World, %s",name));
	}

	
	
	

}
