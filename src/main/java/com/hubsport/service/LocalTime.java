package com.hubsport.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LocalTime {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public final Date showLocalTime() {
		Calendar cl = Calendar.getInstance();
		Date currentTime = cl.getTime();
		return currentTime;
	}
}
