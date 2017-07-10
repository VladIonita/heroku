package com.hubsport.dao;

import java.util.List;

import javax.sql.DataSource;

import com.hubsport.domain.Broadcasters;
import com.hubsport.domain.Timetable;

public interface TimetableDao {

	// Set the data-source that will be required to create a connection to the
	// database.
	public void setDataSource(DataSource ds);

	// Create a record in the organization table
	public boolean create(Timetable timetable);

	// Retrieve all organizations from the table.
	public List<Timetable> getAllTimetable();

	// Delete by name a specific organization from the table.
	public boolean deleteByName(Timetable timetable);

	// Update an existing organization
	public boolean update(Timetable timetable);

	public void cleanup();
}
