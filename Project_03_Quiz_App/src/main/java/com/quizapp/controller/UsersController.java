package com.quizapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quizapp.model.Users;
import com.quizapp.service.UsersService;

@RestController
public class UsersController {

	UsersService usersService;
	
	UsersController(UsersService usersService){
		this.usersService = usersService;
	}
	
	@PostMapping("/InsertUser")
	public void InsertUser(@RequestBody Users users) {
		usersService.InsertUser(users);
	}
	
	@GetMapping("/GetUserByEmail/{email}")
	public Users GetUserByEmail(@PathVariable String email) {
		return usersService.GetUserByEmail(email);
	}
	
	@GetMapping("/AllUsers")
	public List<Users> GetAllUsers(){
		return usersService.GetAllUsers();
	}
	
	@DeleteMapping("/DeleteUser/{email}")
	public void DeleteUser(@PathVariable String email) {
		
		usersService.DeleteUser(email);
	}
}
