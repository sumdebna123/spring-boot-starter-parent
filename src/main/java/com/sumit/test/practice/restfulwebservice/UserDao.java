package com.sumit.test.practice.restfulwebservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	public static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1,"sumit",new Date()));
		users.add(new User(2,"moumita",new Date()));
		users.add(new User(3,"ishayu",new Date()));
	}
	
	//get all the users 
	public List<User> findAll(){
		return users;
	}
	
	//get one user
	public User findOne(Integer id) {
		for (User user: users) {
			if (user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	//Add one user 
	public User addUser(User user) {
		//validateUser(user);
		users.add(user);
		return user;
	}
	
	//Delete user by Id 
	public boolean deleteUserById(int id) {
		for (User user: users) {
			if (user.getId()==id) {
				return users.remove(user);
			}
		}
		return false;
	}
	
	//Validate add user 
	public void validateUser(User user) {
		if (user==null) {
			throw new BadRequestException("proper values are not provided for user creation.");
		} else if (user.getDate()==null) {
			throw new BadRequestException("User creation date is missing.");
		} else if (user.getName()==null) {
			throw new BadRequestException("User name is missing.");
		} else if (user.getId()==null) {
			throw new BadRequestException("User Id is missing.");
		}
	}

}
