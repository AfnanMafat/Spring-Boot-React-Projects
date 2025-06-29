package com.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizapp.model.Users;

import jakarta.transaction.Transactional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

	Users findByEmail(String email);
	
	@Transactional
	void deleteByEmail(String email);
}
