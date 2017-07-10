package com.hubsport.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hubsport.dao.EventsDao;
import com.hubsport.domain.Broadcasters;
import com.hubsport.domain.Categories;
import com.hubsport.domain.Districts;
import com.hubsport.domain.Events;
import com.hubsport.domain.Places;
import com.hubsport.domain.Timetable;
import com.hubsport.domain.Towns;
import com.hubsport.domain.Users;


@Repository
public class EventsDaoImpl implements EventsDao {
	
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource ds) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	public boolean create(Events events) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(events);
		String sqlQuery = "INSERT INTO events (status, name, places_id, users_id, categories_id, broadcasters_id) VALUES (:status, :name, :places_id, :users_id, :categories_id, :broadcasters_id)";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1; 
	}

	public List<Events> getAllEvents() {
		String sqlQuery = "SELECT * FROM events";
		List<Events> eventsList = namedParameterJdbcTemplate.query(sqlQuery, new RowMapper<Events>() {
			public Events mapRow(ResultSet rs, int rowNum) throws SQLException {
				Events events = new Events();
				events.setStatus(rs.getInt("status"));
				events.setName(rs.getString("name"));
				events.setPlaces(new Places(rs.getString("name"), rs.getString("address")));
				events.setUsers(new Users(rs.getInt("status"), rs.getString("email"), rs.getString("password"), rs.getString("fistName"), rs.getString("lastName")));
				events.setCategories(new Categories(rs.getString("name")));
				events.setBroadcasters(new Broadcasters(rs.getString("name")));
				return events;
			}
		});
		return eventsList;
	}

	@Override
	public boolean delete(Events events) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(events);
		String sqlQuery = "DELETE FROM events WHERE name = :name";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	@Override
	public boolean update(Events events) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(events);		
		String sqlQuery = "UPDATE events SET name = :name WHERE id = :id";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	@Override
	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE events";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	}

	@Override
	public List<Events> getAllPaginated() {
		
		String sqlQuery = " SELECT"
				+ " timetable.time AS date,"
				+ " events.id,"
				+ " events.name,"
				+ " places.id as place_id,"
				+ " places.name AS place,"
				+ " towns.name AS town,"
				+ " districts.name AS district,"
				+ " categories.id AS category_id,"
				+ " categories.name AS category,"
				+ " broadcasters.name AS broadcaster,"
				+ " timetable.time AS datetime,"
				+ " timetable.fullday AS fullday"
				+ " FROM events,places,towns,districts,categories,broadcasters,timetable"
				+ " where"
				+ " events.places_id = places.id and places.towns_id = towns.id and towns.districts_id = districts.id and"
				+ " events.categories_id = categories.id and events.broadcasters_id = broadcasters.id and events.id = timetable.events_id order by date";
		List<Events> eventsList = namedParameterJdbcTemplate.query(sqlQuery, new RowMapper<Events>() {
			public Events mapRow(ResultSet rs, int rowNum) throws SQLException {
				Events events = new Events();
				events.setTimetable(new Timetable(rs.getDate("date"),rs.getTime("date"),rs.getInt("fullday")));
				events.setId(rs.getInt("events.id"));
				events.setName(rs.getString("events.name"));
				events.setPlaces(new Places(rs.getInt("place_id"), rs.getString("place")));
				events.setTowns(new Towns(rs.getString("town")));
				events.setDistricts(new Districts(rs.getString("district")));
				events.setCategories(new Categories(rs.getInt("category_id"),rs.getString("category")));
				events.setBroadcasters(new Broadcasters(rs.getString("broadcaster")));
				
					return events;
			}
		});
		return eventsList;
	}

}
