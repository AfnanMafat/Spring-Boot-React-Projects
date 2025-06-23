package com.eventease.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "events")
public class Events {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private String date;
//	private int venue_id;
//	private int category_id;
//	private int organizer_id;
	private String status;
	
	@ManyToOne
    @JoinColumn(name = "venue_id")
    private Venues venue;
	
	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Feedback> feedbacks;
	
	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Tickets> tickets;


    public Events(int id, String title, String description, String date, int venue_id, int category_id,
			int organizer_id, String status, Venues venue, List<Feedback> feedbacks, List<Tickets> tickets,
			Event_Categories category, Users organizer) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
//		this.venue_id = venue_id;
//		this.category_id = category_id;
//		this.organizer_id = organizer_id;
		this.status = status;
		this.venue = venue;
		this.feedbacks = feedbacks;
		this.tickets = tickets;
		this.category = category;
		this.organizer = organizer;
	}

	public List<Tickets> getTickets() {
		return tickets;
	}

	public void setTickets(List<Tickets> tickets) {
		this.tickets = tickets;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Events(int id, String title, String description, String date, int venue_id, int category_id,
			int organizer_id, String status, Venues venue, List<Feedback> feedbacks, Event_Categories category,
			Users organizer) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
//		this.venue_id = venue_id;
//		this.category_id = category_id;
//		this.organizer_id = organizer_id;
		this.status = status;
		this.venue = venue;
		this.feedbacks = feedbacks;
		this.category = category;
		this.organizer = organizer;
	}

	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Events(int id, String title, String description, String date, int venue_id, int category_id,
			int organizer_id, String status, Venues venue, Event_Categories category, Users organizer) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
//		this.venue_id = venue_id;
//		this.category_id = category_id;
//		this.organizer_id = organizer_id;
		this.status = status;
		this.venue = venue;
		this.category = category;
		this.organizer = organizer;
	}

//	@Override
//	public String toString() {
//		return "Events [id=" + id + ", title=" + title + ", description=" + description + ", date=" + date
//				+ ", venue_id=" + venue_id + ", category_id=" + category_id + ", organizer_id=" + organizer_id
//				+ ", status=" + status + ", venue=" + venue + ", category=" + category + ", organizer=" + organizer
//				+ "]";
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

//	public int getVenue_id() {
//		return venue_id;
//	}
//
//	public void setVenue_id(int venue_id) {
//		this.venue_id = venue_id;
//	}
//
//	public int getCategory_id() {
//		return category_id;
//	}
//
//	public void setCategory_id(int category_id) {
//		this.category_id = category_id;
//	}
//
//	public int getOrganizer_id() {
//		return organizer_id;
//	}

//	public void setOrganizer_id(int organizer_id) {
//		this.organizer_id = organizer_id;
//	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Venues getVenue() {
		return venue;
	}

	public void setVenue(Venues venue) {
		this.venue = venue;
	}

	public Event_Categories getCategory() {
		return category;
	}

	public void setCategory(Event_Categories category) {
		this.category = category;
	}

	public Users getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Users organizer) {
		this.organizer = organizer;
	}

	@ManyToOne
    @JoinColumn(name = "category_id")
    private Event_Categories category;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Users organizer;

}
