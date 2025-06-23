package com.eventease.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	private int event_id;
//	private int user_id;
	private int rating;
	private String comment;
	private String feedback_date;
	
	@ManyToOne
    @JoinColumn(name = "event_id")
    private Events event;

    public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(int id, int event_id, int user_id, int rating, String comment, String feedback_date, Events event,
			Users user) {
		super();
		this.id = id;
//		this.event_id = event_id;
//		this.user_id = user_id;
		this.rating = rating;
		this.comment = comment;
		this.feedback_date = feedback_date;
		this.event = event;
		this.user = user;
	}

//	@Override
//	public String toString() {
//		return "Feedback [id=" + id + ", event_id=" + event_id + ", user_id=" + user_id + ", rating=" + rating
//				+ ", comment=" + comment + ", feedback_date=" + feedback_date + ", event=" + event + ", user=" + user
//				+ "]";
//	}

	@ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public int getEvent_id() {
//		return event_id;
//	}
//
//	public void setEvent_id(int event_id) {
//		this.event_id = event_id;
//	}
//
//	public int getUser_id() {
//		return user_id;
//	}
//
//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getFeedback_date() {
		return feedback_date;
	}

	public void setFeedback_date(String feedback_date) {
		this.feedback_date = feedback_date;
	}

	public Events getEvent() {
		return event;
	}

	public void setEvent(Events event) {
		this.event = event;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
}
