package com.quizapp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.quizapp.model.QuizResult;
import com.quizapp.repository.QuizResultRepository;

@Service
public class QuizResultService {

	QuizResultRepository quizResultRepository;
	
	public QuizResultService(QuizResultRepository quizResultRepository) {
		this.quizResultRepository = quizResultRepository;
	}

	public Optional<QuizResult> GetResultById(int id) {
		return quizResultRepository.findById(id);
	}
	
	
}
