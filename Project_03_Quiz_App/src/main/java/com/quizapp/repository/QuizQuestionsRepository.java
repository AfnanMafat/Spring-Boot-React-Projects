package com.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizapp.model.QuizQuestions;

@Repository
public interface QuizQuestionsRepository extends JpaRepository<QuizQuestions, Integer>{

}
