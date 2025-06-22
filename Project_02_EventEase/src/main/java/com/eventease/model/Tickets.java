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
@Table(name = "tickets")
public class Tickets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int event_id;
	private int user_id;
	private String booking_date;
	private String ticket_type;
	private double price;
	private int quntity;
	private String status;

	public Tickets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tickets(int id, int event_id, int user_id, String booking_date, String ticket_type, double price,
			int quntity, String status, Events event, Users user, List<Payments> payments) {
		super();
		this.id = id;
		this.event_id = event_id;
		this.user_id = user_id;
		this.booking_date = booking_date;
		this.ticket_type = ticket_type;
		this.price = price;
		this.quntity = quntity;
		this.status = status;
		this.event = event;
		this.user = user;
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "Tickets [id=" + id + ", event_id=" + event_id + ", user_id=" + user_id + ", booking_date="
				+ booking_date + ", ticket_type=" + ticket_type + ", price=" + price + ", quntity=" + quntity
				+ ", status=" + status + ", event=" + event + ", user=" + user + "]";
	}

	public Tickets(int id, int event_id, int user_id, String booking_date, String ticket_type, double price,
			int quntity, String status, Events event, Users user) {
		super();
		this.id = id;
		this.event_id = event_id;
		this.user_id = user_id;
		this.booking_date = booking_date;
		this.ticket_type = ticket_type;
		this.price = price;
		this.quntity = quntity;
		this.status = status;
		this.event = event;
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "event_id")
	private Events event;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;
	
	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Payments> payments;

	public List<Payments> getPayments() {
		return payments;
	}

	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}

	public String getTicket_type() {
		return ticket_type;
	}

	public void setTicket_type(String ticket_type) {
		this.ticket_type = ticket_type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuntity() {
		return quntity;
	}

	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
