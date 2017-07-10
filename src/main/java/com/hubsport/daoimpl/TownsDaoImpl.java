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

import com.hubsport.dao.TimetableDao;
import com.hubsport.dao.TownsDao;
import com.hubsport.domain.Districts;
import com.hubsport.domain.Events;
import com.hubsport.domain.Timetable;
import com.hubsport.domain.Towns;


@Repository
public class TownsDaoImpl implements TownsDao {
	
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource ds) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	@Override
	public boolean create(Towns towns) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(towns);
		String sqlQuery = "INSERT INTO towns (name, districts_id) VALUES (:name, :districts_id)";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1; 
	}

	@Override
	public List<Towns> getAllTowns() {
		String sqlQuery = "SELECT * FROM towns";
		List<Towns> townsList = namedParameterJdbcTemplate.query(sqlQuery, new RowMapper<Towns>() {
			public Towns mapRow(ResultSet rs, int rowNum) throws SQLException {
				Towns towns = new Towns();
				towns.setName(rs.getString("name"));
				towns.setDistricts(new Districts(rs.getString("name")));
				return towns;
			}
		});
		return townsList;
	}

	@Override
	public boolean deleteByName(Towns towns) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(towns);
		String sqlQuery = "DELETE FROM towns WHERE name = :name";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	@Override
	public boolean update(Towns towns) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(towns);		
		String sqlQuery = "UPDATE towns SET name = :name WHERE id = :id";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	@Override
	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE towns";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	}


}