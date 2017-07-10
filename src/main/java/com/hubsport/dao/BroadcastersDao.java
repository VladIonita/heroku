package com.hubsport.dao;

import java.util.List;

import javax.sql.DataSource;

import com.hubsport.domain.Broadcasters;

public interface BroadcastersDao {

	// Set the data-source that will be required to create a connection to the database.
	public void setDataSource(DataSource ds);
	
	// Create a record in the organization table
	public boolean create(Broadcasters broadcaster);
	
	// Retrieve a single organization by name
	public Broadcasters getBroadcasters(String name);
	
	// Retrieve all organizations from the table.
	public List<Broadcasters> getAllBroadcasters();

	// Delete by name a specific organization from the table.
	public boolean deleteByName(Broadcasters broadcaster);
	
	// Update an existing organization
	public boolean update(Broadcasters broadcaster);
	
	
	
	public void cleanup();
}
