package com.quizapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class QuizResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private int score;

	@Column(nullable = false)
	private int total;

	@Override
	public String toString() {
		return "QuizResult [id=" + id + ", score=" + score + ", total=" + total + ", users=" + users + "]";
	}

	public QuizResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuizResult(int id, int score, int total, Users users) {
		super();
		this.id = id;
		this.score = score;
		this.total = total;
		this.users = users;
	}

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Users users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
