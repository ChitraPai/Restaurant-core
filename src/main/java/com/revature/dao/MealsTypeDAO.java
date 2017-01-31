package com.revature.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.*;
import com.revature.util.*;

public class MealsTypeDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(MealsType meal) {

		String sql = "insert into meals_type(id,meal_name,from_time,to_time) values(?,?,?,?)";
		Object[] params = { meal.getId(), meal.getMealName(), meal.getFromTime(), meal.getToTime() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void update(MealsType meal) {

		String sql = "update meals_type set meal_name=? where id=?";
		Object[] params = { meal.getMealName(), meal.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(MealsType meal) {
		String sql = "delete from meals_type where id=?";
		Object[] params = { meal.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows delated:" + rows);

	}

	public List<MealsType> list() {
		String sql = "select * from meals_type";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			MealsType meal = new MealsType();
			meal.setId(rs.getInt("id"));
			meal.setMealName(rs.getString("meal_name"));
			meal.setFromTime(rs.getTime("from_time").toLocalTime());
			meal.setToTime(rs.getTime("to_time").toLocalTime());

			return meal;
		});
	}

	public List<String> listMealNames() {
		String sql = "select meal_name from meals_type";
		return jdbcTemplate.queryForList(sql, String.class);

	}

	public MealsType listById(int id) {
		String sql = "select id,meal_name,from_time,to_time from meals_type where id=? ";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			MealsType meal = new MealsType();
			meal.setId(rs.getInt("id"));
			meal.setMealName(rs.getString("meal_name"));
			meal.setFromTime(rs.getTime("from_time").toLocalTime());
			meal.setToTime(rs.getTime("to_time").toLocalTime());

			return meal;
		});

	}

}
