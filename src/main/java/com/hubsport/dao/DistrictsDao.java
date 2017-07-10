package com.hubsport.dao;

import java.util.List;

import javax.sql.DataSource;

import com.hubsport.domain.Districts;

public interface DistrictsDao {

	// Set the data-source that will be required to create a connection to the
	// database.
	public void setDataSource(DataSource ds);

	// Create a record in the organization table
	public boolean create(Districts districts);

	// Retrieve all organizations from the table.
	public List<Districts> getAllDistricts();

	// Delete by name a specific organization from the table.
	public boolean deleteByName(Districts districts);

	// Update an existing organization
	public boolean update(Districts districts);

	public void cleanup();
}
