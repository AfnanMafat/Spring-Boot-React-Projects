package com.eventease.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eventease.model.Users;
import com.eventease.service.Users_Service;

@RestController
@CrossOrigin("http://localhost:5173/")
public class Users_Controller {

	Users_Service users_Service;
	
	public Users_Controller(Users_Service users_Service) {
		this.users_Service = users_Service;
	}
	
	@PostMapping("/InsertUser")
	public void InsertUser(@RequestBody Users users) {
		users_Service.InsertUser(users);
	}
	
	@GetMapping("/GetAllUsers")
	public List<Users> GetAllUsers(){
		return users_Service.GetAllUsers();
	}
	
	@GetMapping("/GetUser/{id}")
	public Optional<Users> GetUser(@PathVariable int id){
		return users_Service.GetUser(id);
	}
	
	@GetMapping("/GetUserByEmail/{email}")
	public Optional<Users> GetUserByEmail(@PathVariable String email){
		return users_Service.GetUserByEmail(email);
	}
	
	@PutMapping("/UpdateUser/{id}")
	public void UpdateUser(@RequestBody Users user, @PathVariable int id) {
		
		if(GetUser(id) == null) {
			return;
		}
		
		Users updateUsers = new Users();
		
		updateUsers.setId(id);
		updateUsers.setName(user.getName());
		updateUsers.setRole(user.getRole());
		updateUsers.setEmail(user.getEmail());
		updateUsers.setFeedbacks(user.getFeedbacks());
		updateUsers.setOrganizedEvents(user.getOrganizedEvents());
		updateUsers.setPassword(user.getPassword());
		updateUsers.setPhone(user.getPhone());
		updateUsers.setRole(user.getRole());
		updateUsers.setTickets(user.getTickets());
		
		users_Service.InsertUser(updateUsers);
	}
	
	@DeleteMapping("/DeleteUser/{id}")
	public void DeleteUser(@PathVariable int id) {
		users_Service.DeleteUser(id);
	}
}
