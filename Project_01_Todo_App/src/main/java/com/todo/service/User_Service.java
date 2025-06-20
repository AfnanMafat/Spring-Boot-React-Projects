package com.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.todo.model.User;
import com.todo.repository.User_Repository;

@Service
public class User_Service {
	
	private User_Repository repository;
	
	private User_Service(User_Repository repository) {
		this.repository = repository;
	}
	
	public void InsertTodo(User user) {
		repository.save(user);
	}

	public List<User> GetAll() {
		
		return repository.findAll();
		
	}

	public void DeleteTodo(long id) {
		
		repository.deleteById(id);
		
	}

	public Optional<User> GetTodo(long id) {
		
		return repository.findById(id);
	}

}
