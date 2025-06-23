package com.eventease.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eventease.model.Users;
import com.eventease.repository.Users_Repository;

@Service
public class Users_Service {

	Users_Repository users_Repository;
	
	public Users_Service(Users_Repository repository) {
		this.users_Repository = repository;
	}

	public void InsertUser(Users users) {
		
		users_Repository.save(users);
		
	}

	public List<Users> GetAllUsers() {
		
		return users_Repository.findAll();
		
	}

	public Optional<Users> GetUser(int id) {
		return users_Repository.findById(id);
	}

	public void DeleteUser(int id) {
		
		users_Repository.deleteById(id);
		
	}

	public Optional<Users> GetUserByEmail(String email) {
		return users_Repository.findByEmail(email);
	}
}
