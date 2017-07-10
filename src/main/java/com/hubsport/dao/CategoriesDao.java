package com.hubsport.dao;

import java.util.List;

import javax.sql.DataSource;

import com.hubsport.domain.Categories;

public interface CategoriesDao {
	// Set the data-source that will be required to create a connection to the database.
	public void setDataSource(DataSource ds);
	
	// Create a record in the organization table
	public boolean create(Categories category);
	
	// Retrieve all organizations from the table.
	public List<Categories> getAllCategories();

	// Delete a specific organization from the table.
	public boolean delete(Categories category);
	
	// Update an existing organization
	public boolean update(Categories category);
	
	public void cleanup();
}
