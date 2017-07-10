package com.hubsport.dao;

import java.util.List;

import javax.sql.DataSource;

import com.hubsport.domain.Broadcasters;
import com.hubsport.domain.Timetable;
import com.hubsport.domain.Token;

public interface TokenDao {

	// Set the data-source that will be required to create a connection to the
	// database.
	public void setDataSource(DataSource ds);

	// Create a record in the organization table
	public boolean create(Token token);

	// Retrieve all organizations from the table.
	public List<Token> getAllToken();

	// Delete by name a specific organization from the table.
	public boolean deleteByName(Token token);

	// Update an existing organization
	public boolean update(Token token);

	public void cleanup();
}
