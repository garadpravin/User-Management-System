package com.de.user.manage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.de.user.manage.entities.ResponsePayLoad;
import com.de.user.manage.entities.UserEntity;
import com.de.user.manage.repositories.*;

/**
 * @author Pravin Garad
 * This class UserController is implemented for REST APIs for User Management System.
 * APIs: addUser: To add new user, modifyUser: to update details of existing users, deleteUser: to delete the user details and getUser: to get details of User.
 * Here there is no password authentication maintained to update, delete and get details of user profile.
 * These are simple APIs which produces and consumes JASON payload.
 */

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepository user_repository;
	
	@PostMapping(path ="/addUser", produces = "application/json")
	public ResponsePayLoad addUser(@Valid @RequestBody UserEntity user)
	{
		ResponsePayLoad response = null;
		try
		{			
			UserEntity checkUser = user_repository.getByEmail(user.getEmail());
			
			if(checkUser == null)
			{
				user_repository.save(user);
				response = new ResponsePayLoad();
				response.setResponse("New User has been added");
				return response;
			}
			else
			{
				response = new ResponsePayLoad();
				response.setResponse("User with email id already exists");
				return response;
			}
				
		}catch(Exception ex)
		{
			response = new ResponsePayLoad();
			response.setResponse("Unexpected Error. Please try again or later. "+ex.getMessage());
			return response;
		}
		
	}
	
	@PutMapping(path ="/modifyUser", produces = "application/json")
	public ResponsePayLoad modifyUser(@Valid @RequestBody UserEntity user)
	{
		ResponsePayLoad response = null;
		
		try
		{
			UserEntity checkUser = user_repository.getByEmail(user.getEmail());
			
			if(checkUser == null)
			{
				response = new ResponsePayLoad();
				response.setResponse("User with email id does not exists");
				return response;
			}
			else
			{
				user_repository.save(user);
				response = new ResponsePayLoad();
				response.setResponse("User details has been updated.");
				return response;
			}
			
		}catch (Exception ex) 
		{
			response = new ResponsePayLoad();
			response.setResponse("Unexpected Error. Please try again or later. "+ex.getMessage());
			return response;
		}
	
	}
	
	@DeleteMapping(path ="/deleteUser", produces = "application/json")
	public ResponsePayLoad deleteUser(@Valid @RequestBody UserEntity user)
	{
		ResponsePayLoad response = null;
		
		try
		{
			UserEntity checkUser = user_repository.getByEmail(user.getEmail());
			
			if(checkUser == null)
			{
				response = new ResponsePayLoad();
				response.setResponse("User with email id does not exists");
				return response;
			}
			else
			{
				user_repository.delete(checkUser);
				response = new ResponsePayLoad();
				response.setResponse("User is deleted.");
				return response;
			}
			
		}catch (Exception ex) 
		{
			response = new ResponsePayLoad();
			response.setResponse("Unexpected Error. Please try again or later. ");
			return response;
		}

	
	}
	
	@GetMapping(path="/getUser/{email}", produces = "application/json")
	public ResponsePayLoad getUser(@PathVariable(value = "email") String email)
	{
		ResponsePayLoad response = null;
		
		try
		{
			UserEntity checkUser = user_repository.getByEmail(email);
			
			if(checkUser == null)
			{
				
				response = new ResponsePayLoad();
				response.setResponse("User not found");
				return response;
			}
			else
			{
				response = new ResponsePayLoad();
				response.setUser(checkUser);
				response.setResponse("User found");
				return response;
			}
			
		}catch(Exception ex)
		{
			response = new ResponsePayLoad();
			response.setResponse("Unexpected Error. Please try again or later. "+ex.getMessage());
			return response;
		}
		
		
	}
	
}