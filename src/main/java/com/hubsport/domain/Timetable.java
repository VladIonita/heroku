package com.hubsport.domain;

import java.sql.Date;
import java.sql.Time;

public class Timetable {

	private int id;
	private Date date;
	private int fullday;
	private Events events;
	private Time time;

	
	public Timetable() {
	}

	public Timetable(Date date, Time time, int fullday) {
		this.date = date;
		this.time = time;
		this.fullday = fullday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getFullday() {
		return fullday;
	}

	public void setFullday(int fullday) {
		this.fullday = fullday;
	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Timetable [id=" + id + ", date=" + date + ", fullday=" + fullday + ", events=" + events + ", time="
				+ time + "]";
	}

}
