package com.quizapp.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.quizapp.model.QuizResult;
import com.quizapp.service.QuizResultService;

@RestController
public class QuizResultController {

	QuizResultService quizResultService;
	
	public QuizResultController(QuizResultService quizResultService){
		this.quizResultService = quizResultService;
	}
	
	@GetMapping("/GetResultById/{user_id}")
	public Optional<QuizResult> GetResultById(@PathVariable int user_id){
		return quizResultService.GetResultById(user_id);
	}
}
