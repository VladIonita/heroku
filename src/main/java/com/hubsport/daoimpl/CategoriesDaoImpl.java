package com.hubsport.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hubsport.dao.CategoriesDao;
import com.hubsport.domain.Categories;

@Repository
public class CategoriesDaoImpl implements CategoriesDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource ds) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	public boolean create(Categories category) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(category);
		String sqlQuery = "INSERT INTO categories (name) VALUES (:name)";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public List<Categories> getAllCategories() {
		
		String sqlQuery = "SELECT * FROM categories";
		List<Categories> categoriesList = namedParameterJdbcTemplate.query(sqlQuery, new RowMapper<Categories>() {
			public Categories mapRow(ResultSet rs, int rowNum) throws SQLException {
				Categories categories = new Categories();
				categories.setName(rs.getString("name"));
				return categories;
			}
		});
		return categoriesList;
	}

	public boolean delete(Categories category) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(category);
		String sqlQuery = "DELETE FROM categories WHERE name = :name";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public boolean update(Categories category) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(category);		
		String sqlQuery = "UPDATE categories SET name = :name WHERE id = :id";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE categories ";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	}

}