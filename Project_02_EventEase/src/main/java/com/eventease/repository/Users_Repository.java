package com.eventease.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventease.model.Users;

@Repository
public interface Users_Repository extends JpaRepository<Users, Integer>{
	
	 Optional<Users> findByEmail(String email);

}
