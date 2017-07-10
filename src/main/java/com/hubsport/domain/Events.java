package com.hubsport.domain;

public class Events {

	private int id;
	private int status;
	private String name;
	private Places places;
	private Users users;
	private Categories categories;
	private Broadcasters broadcasters;
	private Timetable timetable;
	private Towns towns;
	private Districts districts;
	
	
	public Events() {
	}
	public Events(int id) {
		this.id = id;
	}

	public Events(int status, String name) {
		this.status = status;
		this.name = name;
	}
	public Events(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Places getPlaces() {
		return places;
	}

	public void setPlaces(Places places) {
		this.places = places;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public Broadcasters getBroadcasters() {
		return broadcasters;
	}

	public void setBroadcasters(Broadcasters broadcasters) {
		this.broadcasters = broadcasters;
	}
	public Timetable getTimetable() {
		return timetable;
	}
	public void setTimetable(Timetable timetable) {
		this.timetable = timetable;
	}
	public Towns getTowns() {
		return towns;
	}
	public void setTowns(Towns towns) {
		this.towns = towns;
	}
	public Districts getDistricts() {
		return districts;
	}
	public void setDistricts(Districts districts) {
		this.districts = districts;
	}
	@Override
	public String toString() {
		return "Events [id=" + id + ", status=" + status + ", name=" + name + ", places=" + places + ", users=" + users
				+ ", categories=" + categories + ", broadcasters=" + broadcasters + ", timetable=" + timetable
				+ ", towns=" + towns + ", districts=" + districts + "]";
	}



}
