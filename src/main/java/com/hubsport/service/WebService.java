package com.hubsport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubsport.dao.EventsDao;
import com.hubsport.dao.PlacesDao;
import com.hubsport.dao.TimetableDao;
import com.hubsport.domain.Events;
import com.hubsport.domain.Places;
import com.hubsport.domain.Timetable;

@Service
public class WebService {

	@Autowired
	private PlacesDao placesDao;
	
	@Autowired
	private TimetableDao timetableDao;
	
	@Autowired
	private EventsDao eventsDao;
	
	
	
	
	
	
	public List<Places> getPlacesList() {
		List<Places> placesList = placesDao.getAllPlaces();
		return placesList;
	}
	
	
	public List<Timetable> getTimetableList() {
		List<Timetable> timetableList = timetableDao.getAllTimetable();
		return timetableList;
	}
	
	public List<Events> getEventsList() {
		List<Events> eventsList = eventsDao.getAllEvents();
		return eventsList;
	}
	
	
	public List<Events> getAllPaginated() {
		List<Events> eventsList = eventsDao.getAllPaginated();
		return eventsList;
	}
}
