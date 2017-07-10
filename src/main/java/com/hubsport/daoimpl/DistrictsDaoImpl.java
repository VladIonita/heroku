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

import com.hubsport.dao.DistrictsDao;
import com.hubsport.domain.Districts;

@Repository
public class DistrictsDaoImpl implements DistrictsDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource ds) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	public boolean create(Districts districts) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(districts);
		String sqlQuery = "INSERT INTO districts (name) VALUES (:name)";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public List<Districts> getAllDistricts() {
		String sqlQuery = "SELECT * FROM districts";
		List<Districts> districtsList = namedParameterJdbcTemplate.query(sqlQuery, new RowMapper<Districts>() {
			public Districts mapRow(ResultSet rs, int rowNum) throws SQLException {
				Districts districts = new Districts();
				districts.setName(rs.getString("name"));
				return districts;
			}
		});
		return districtsList;
	}

	public boolean deleteByName(Districts districts) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(districts);
		String sqlQuery = "DELETE FROM districts WHERE name = :name";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public boolean update(Districts districts) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(districts);		
		String sqlQuery = "UPDATE districts SET name = :name WHERE id = :id";
		return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE districts ";
		namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);

	}

}