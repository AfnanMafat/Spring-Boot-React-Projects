package com.quizapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quizapp.model.Users;
import com.quizapp.repository.UsersRepository;

@Service
public class UsersService {

	UsersRepository usersRepository;

	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public void InsertUser(Users users) {

		usersRepository.save(users);
	}

	public Users GetUserByEmail(String email) {

		return usersRepository.findByEmail(email);
	}

	public void DeleteUser(String email) {

		usersRepository.deleteByEmail(email);

	}

	public List<Users> GetAllUsers() {
		return usersRepository.findAll();
	}

}
