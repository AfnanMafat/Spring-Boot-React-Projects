package com.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizapp.model.QuizResult;

@Repository
public interface QuizResultRepository extends JpaRepository<QuizResult, Integer> {

}
