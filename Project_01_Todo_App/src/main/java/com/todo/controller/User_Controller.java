package com.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.model.User;
import com.todo.service.User_Service;

@RestController
public class User_Controller {
	
	private User_Service service;
	
	public User_Controller(User_Service service) {
		this.service = service;
	}
	
	@PostMapping("/Insert")
	public void InsertTodo(@RequestBody User user) {
		service.InsertTodo(user);
	}
	
	@GetMapping("/GetAll")
	public List<User> GetAll(){
		return service.GetAll();
	}
	
	@GetMapping("/GetTodo/{id}")
	public Optional<User> GetTodo(@PathVariable long id){
		return service.GetTodo(id);
	}
	
	@PutMapping("/Update/{id}")
	public void UpdateTodo(@RequestBody User user,@PathVariable long id) {
		
		if(GetTodo(id) == null) {
			return;
		}
		
		User UpdateUser = new User();
		UpdateUser.setId(id);
		UpdateUser.setTitle(user.getTitle());
		UpdateUser.setDescription(user.getDescription());
		UpdateUser.setDue_date(user.getDue_date());
		UpdateUser.setPriority(user.getPriority());
		UpdateUser.setStatus(user.getStatus());
		
		service.InsertTodo(UpdateUser);
		
	}
	
	@DeleteMapping("/Delete/{id}")
	public void DeleteTodo(@PathVariable long id) {
		service.DeleteTodo(id);
	}

}
