package com.hubsport.dao;

import java.util.List;

import javax.sql.DataSource;

import com.hubsport.domain.Events;

public interface EventsDao {

	// Set the data-source that will be required to create a connection to the
	// database.
	public void setDataSource(DataSource ds);

	// Create a record in the organization table
	public boolean create(Events events);

	// Retrieve all organizations from the table.
	public List<Events> getAllEvents();

	// Delete a specific organization from the table.
	public boolean delete(Events events);

	// Update an existing organization
	public boolean update(Events events);

	public void cleanup();

	public List<Events> getAllPaginated();
}
