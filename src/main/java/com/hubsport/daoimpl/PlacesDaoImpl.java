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

import com.hubsport.dao.PlacesDao;
import com.hubsport.domain.Places;
import com.hubsport.domain.Towns;


@Repository
public class PlacesDaoImpl implements PlacesDao {
	
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource ds) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}


	////  NU sunt sigur ca e bine!!!!!!!!!!!!!
	public boolean create(Places places) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(places);
		String sqlQuery = "INSERT INTO places (name, address, towns_id) VALUES (:name, :address, :towns_id)";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1; 
	}

	@Override
	public List<Places> getAllPlaces() {
		String sqlQuery = "SELECT * FROM places";
		List<Places> placesList = namedParameterJdbcTemplate.query(sqlQuery, new RowMapper<Places>() {
			public Places mapRow(ResultSet rs, int rowNum) throws SQLException {
				Places places = new Places();
				places.setName(rs.getString("name"));
				places.setAddress(rs.getString("address"));
				places.setTowns(new Towns(rs.getString("name")));
				return places;
			}
		});
		return placesList;
	}

	public boolean delete(Places places) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(places);
		String sqlQuery = "DELETE FROM places WHERE name = :name";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public boolean update(Places places) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(places);		
		String sqlQuery = "UPDATE places SET name = :name WHERE id = :id";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE places ";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	}


}