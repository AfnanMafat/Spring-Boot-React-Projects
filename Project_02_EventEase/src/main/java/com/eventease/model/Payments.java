package com.eventease.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int ticket_id;
	private String payment_date;
	private double amount;
	private String method;
	private String status;
	
	@Override
	public String toString() {
		return "Payments [id=" + id + ", ticket_id=" + ticket_id + ", payment_date=" + payment_date + ", amount="
				+ amount + ", method=" + method + ", status=" + status + ", ticket=" + ticket + "]";
	}

	public Payments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payments(int id, int ticket_id, String payment_date, double amount, String method, String status,
			Tickets ticket) {
		super();
		this.id = id;
		this.ticket_id = ticket_id;
		this.payment_date = payment_date;
		this.amount = amount;
		this.method = method;
		this.status = status;
		this.ticket = ticket;
	}

	@ManyToOne
    @JoinColumn(name = "ticket_id")
    private Tickets ticket;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Tickets getTicket() {
		return ticket;
	}

	public void setTicket(Tickets ticket) {
		this.ticket = ticket;
	}

}
