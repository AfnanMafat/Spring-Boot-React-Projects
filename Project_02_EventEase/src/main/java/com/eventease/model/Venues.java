package com.eventease.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "venues")
public class Venues {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private int capacity;
	
	@OneToMany(mappedBy = "venue", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Events> events;

	@Override
	public String toString() {
		return "Venues [id=" + id + ", name=" + name + ", address=" + address + ", capacity=" + capacity + ", events="
				+ events + "]";
	}

	public Venues() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venues(int id, String name, String address, int capacity, List<Events> events) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.capacity = capacity;
		this.events = events;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Events> getEvents() {
		return events;
	}

	public void setEvents(List<Events> events) {
		this.events = events;
	}
}
