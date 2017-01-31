package com.revature.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.*;
import com.revature.util.*;

public class ItemScheduleDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(ItemSchedule itemsch) {

		String sql = "insert into item_schedule(id,meal_id,item_id,quantity) values(?,?,?,?)";
		Object[] params = { itemsch.getId(), itemsch.getMealId().getId(), itemsch.getItemId().getId(),
				itemsch.getQuantity() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void update(ItemSchedule itemsch) {

		String sql = "update item_schedule set item_id=?,meal_id=? where id=?";
		Object[] params = { itemsch.getItemId().getId(), itemsch.getMealId().getId(), itemsch.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(ItemSchedule itemsch) {
		String sql = "delete from item_schedule where id=?";
		Object[] params = { itemsch.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted:" + rows);

	}

	public List<ItemSchedule> list() {
		String sql = "select id,meal_id,item_id,quantity from item_schedule";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			ItemSchedule itemsch = new ItemSchedule();
			itemsch.setId(rs.getInt("id"));
			MealsType meal = new MealsType();
			meal.setId(rs.getInt("meal_id"));
			itemsch.setMealId(meal);
			MenuItems menu = new MenuItems();
			menu.setId(rs.getInt("item_id"));
			itemsch.setItemId(menu);

			itemsch.setQuantity(rs.getInt("quantity"));
			return itemsch;
		});

	}

	public ItemSchedule listById(int id) {
		String sql = "select id,meal_id,item_id,quantity from item_schedule where id=? ";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			ItemSchedule itemsch = new ItemSchedule();
			itemsch.setId(rs.getInt("id"));
			MealsType meal = new MealsType();
			meal.setId(rs.getInt("meal_id"));
			itemsch.setMealId(meal);
			MenuItems menu = new MenuItems();
			menu.setId(rs.getInt("item_id"));
			itemsch.setItemId(menu);

			itemsch.setQuantity(rs.getInt("quantity"));
			return itemsch;
		});

	}
}
