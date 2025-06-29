package com.quizapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.quizapp.model.QuizQuestions;
import com.quizapp.repository.QuizQuestionsRepository;

@Service
public class QuizQuestionsService {

	QuizQuestionsRepository quizQuestionsRepository;

	public QuizQuestionsService(QuizQuestionsRepository quizQuestionsRepository) {
		this.quizQuestionsRepository = quizQuestionsRepository;
	}

	public List<QuizQuestions> GetAllQuestions() {

		return quizQuestionsRepository.findAll();

	}

	public Optional<QuizQuestions> GetQuestionById(int id) {
		return quizQuestionsRepository.findById(id);
	}
}
