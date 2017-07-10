package com.hubsport.dao;

import java.util.List;

import javax.sql.DataSource;

import com.hubsport.domain.Broadcasters;
import com.hubsport.domain.Timetable;
import com.hubsport.domain.Token;
import com.hubsport.domain.Towns;

public interface TownsDao {

	// Set the data-source that will be required to create a connection to the
	// database.
	public void setDataSource(DataSource ds);

	// Create a record in the organization table
	public boolean create(Towns towns);

	// Retrieve all organizations from the table.
	public List<Towns> getAllTowns();

	// Delete by name a specific organization from the table.
	public boolean deleteByName(Towns towns);

	// Update an existing organization
	public boolean update(Towns towns);

	public void cleanup();
}
