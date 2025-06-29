package com.quizapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.quizapp.model.QuizQuestions;
import com.quizapp.service.QuizQuestionsService;

@RestController
public class QuizQuestionsController {

	QuizQuestionsService quizQuestionsService;

	public QuizQuestionsController(QuizQuestionsService quizQuestionsService) {
		this.quizQuestionsService = quizQuestionsService;
	}

	@GetMapping("/GetAllQuestions")
	public List<QuizQuestions> GetAllQuestions() {
		return quizQuestionsService.GetAllQuestions();
	}

	@GetMapping("/GetQuestionById/{id}")
	public Optional<QuizQuestions> GetQuestionById(@PathVariable int id) {
		return quizQuestionsService.GetQuestionById(id);
	}
}
