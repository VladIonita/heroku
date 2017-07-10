package com.hubsport.dao;

import java.util.List;

import javax.sql.DataSource;

import com.hubsport.domain.Events;
import com.hubsport.domain.Places;

public interface PlacesDao {

	// Set the data-source that will be required to create a connection to the
	// database.
	public void setDataSource(DataSource ds);

	// Create a record in the organization table
	public boolean create(Places places);

	// Retrieve all organizations from the table.
	public List<Places> getAllPlaces();

	// Delete a specific organization from the table.
	public boolean delete(Places places);

	// Update an existing organization
	public boolean update(Places places);

	public void cleanup();

}
