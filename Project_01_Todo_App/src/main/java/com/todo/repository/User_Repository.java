package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.model.User;

@Repository
public interface User_Repository extends JpaRepository<User, Long>{

}
