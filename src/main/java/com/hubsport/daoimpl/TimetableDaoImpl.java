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
import com.hubsport.domain.Events;
import com.hubsport.domain.Timetable;


@Repository
public class TimetableDaoImpl implements TimetableDao {
	
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource ds) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	public boolean create(Timetable timetable) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(timetable);
		String sqlQuery = "INSERT INTO timetable (date, fullday, events_id) VALUES (:date, :fullday, :events_id)";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1; 
	}

	public List<Timetable> getAllTimetable() {
		String sqlQuery = "SELECT * FROM timetable";
		List<Timetable> timetableList = namedParameterJdbcTemplate.query(sqlQuery, new RowMapper<Timetable>() {
			public Timetable mapRow(ResultSet rs, int rowNum) throws SQLException {
				Timetable timetable = new Timetable();
				timetable.setDate(rs.getDate("time"));
				timetable.setFullday(rs.getInt("fullday"));
				timetable.setEvents(new Events());
				return timetable;
			}
		});
		return timetableList;
	}

	public boolean deleteByName(Timetable timetable) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(timetable);
		String sqlQuery = "DELETE FROM timetable WHERE name = :name";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public boolean update(Timetable timetable) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(timetable);		
		String sqlQuery = "UPDATE timetable SET name = :name WHERE id = :id";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE timetable ";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	}


}