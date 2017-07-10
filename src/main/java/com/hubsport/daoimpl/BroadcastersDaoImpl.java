package com.hubsport.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hubsport.dao.BroadcastersDao;
import com.hubsport.domain.Broadcasters;


@Repository
public class BroadcastersDaoImpl implements BroadcastersDao {
	
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource ds) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	public boolean create(Broadcasters broadcaster) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(broadcaster);
		String sqlQuery = "INSERT INTO broadcasters (name) VALUES (:name)";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1; 
	}

	public Broadcasters getBroadcasters(String name) {
		SqlParameterSource params = new MapSqlParameterSource("name", name);
		String sqlQuery = "SELECT * FROM broadcasters WHERE LOWER(name) = :name";
		Broadcasters broadcasters = namedParameterJdbcTemplate.queryForObject(sqlQuery, params,new RowMapper<Broadcasters>() {
			public Broadcasters mapRow(ResultSet rs, int rowNum) throws SQLException {
				Broadcasters broadcasters = new Broadcasters();
				broadcasters.setName(rs.getString("name"));
				return broadcasters;
			}
		});
		return broadcasters;
	}

	public List<Broadcasters> getAllBroadcasters() {
		String sqlQuery = "SELECT * FROM broadcasters";
		List<Broadcasters> broadcastersList = namedParameterJdbcTemplate.query(sqlQuery, new RowMapper<Broadcasters>() {
			public Broadcasters mapRow(ResultSet rs, int rowNum) throws SQLException {
				Broadcasters broadcasters = new Broadcasters();
				broadcasters.setName(rs.getString("name"));
				return broadcasters;
			}
		});
		return broadcastersList;
	}

	public boolean deleteByName(Broadcasters broadcaster) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(broadcaster);
		String sqlQuery = "DELETE FROM broadcasters WHERE name = :name";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public boolean update(Broadcasters broadcaster) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(broadcaster);		
		String sqlQuery = "UPDATE broadcasters SET name = :name WHERE id = :id";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}



	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE broadcasters ";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	}
}