package com.hubsport.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hubsport.domain.Events;
import com.hubsport.service.WebService;

@Controller
public class EventsController {

	@Autowired
	private WebService placesService;

	@RequestMapping
	public String listEvents(Model model) {

		List<Events> events = placesService.getAllPaginated();
		Calendar cl = Calendar.getInstance();
		Date currentTime = cl.getTime();
		String weekDay = null;
		List<Events> newEvents = new ArrayList<>();
		for (Events event : events) {
			if (event.getTimetable().getDate().compareTo(currentTime) >= 0) {
				newEvents.add(event);
			}

			// ar trebuii sa fac verificare in alta parte ca imi ia doar prima
			// citire
			cl.setTime(event.getTimetable().getDate());
			int daw = cl.get(Calendar.DAY_OF_WEEK);
			switch (daw) {
			case 1:
				weekDay = "Duminica";
				break;
			case 2:
				weekDay = "Luni";
				break;
			case 3:
				weekDay = "Marti";
				break;
			case 4:
				weekDay = "Miercuri";
				break;
			case 5:
				weekDay = "Joi";
				break;
			case 6:
				weekDay = "Vineri";
				break;
			case 7:
				weekDay = "Sambata";
				break;
			}
			model.addAttribute("weekday", weekDay);
		}

		model.addAttribute("eventsList", newEvents);
		return "home";
	}

	// @RequestMapping("/service")
	// public String listTimetable(Model model) {
	// List<Timetable> timetables = placesService.getTimetableList();
	// List<Events> events = placesService.getEventsList();
	// model.addAttribute("timetableList", timetables);
	// model.addAttribute("eventsList", events);
	// return "listEvents2";
	// }

	// @RequestMapping("/service")
	// public String listObjects(Model model) {
	// List<Object> obj = placesService.getAllPaginatedObjects();
	// model.addAttribute("eventsList", obj);
	// return "listEvents2";
	// }
}
