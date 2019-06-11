package com.sumit.test.practice.restfulwebservice;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import net.bytebuddy.asm.Advice.Return;



@RestController
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(method=RequestMethod.GET,path="/users")	
	public List<User> getAllUser() {
		return userDao.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/user/{id}")	
	public Resource<User> getUser(@PathVariable int id) {
		User user = userDao.findOne(id);
		if (user==null) {
			throw new UserNotFoundException("id="+id);
		}
		
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo=linkTo(methodOn(this.getClass()).getAllUser());
		resource.add(linkTo.withRel("all_user"));
		return resource;
	}
	
	@PostMapping("/user")	
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		//userDao.validateUser(user);
		User usr=userDao.addUser(user);
		//created 
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(usr.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id){
		//userDao.deleteUserById(id);
		if (userDao.deleteUserById(id)) {
			return ResponseEntity.ok(null);
		} else {
			throw new UserNotFoundException("id="+id);
		}
			
	}
	
	
	
	
	//Add One

}
