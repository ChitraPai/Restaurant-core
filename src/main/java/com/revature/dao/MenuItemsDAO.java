package com.revature.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.*;
import com.revature.util.*;

public class MenuItemsDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(MenuItems menu) {

		String sql = "insert into menu_items(id,item_name,price) values(?,?,?)";
		Object[] params = { menu.getId(), menu.getItemName(), menu.getPrice() };
		jdbcTemplate.update(sql, params);

	}

	public void update(MenuItems menu) {

		String sql = "update menu_items set item_name=? where id=?";
		Object[] params = { menu.getItemName(), menu.getId() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(MenuItems menu) {
		String sql = "delete from menu_items where id=?";
		Object[] params = { menu.getId() };
		jdbcTemplate.update(sql, params);

	}

	public List<MenuItems> list() {
		String sql = "select id,item_name,price from menu_items";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			MenuItems menu = new MenuItems();
			menu.setId(rs.getInt("id"));
			menu.setItemName(rs.getString("item_name"));
			menu.setPrice(rs.getInt("price"));

			return menu;
		});
	}

	public List<String> listItemNames() {
		String sql = "select item_name from menu_items";
		return jdbcTemplate.queryForList(sql, String.class);

	}

	public MenuItems listById(int id) {
		String sql = "select id,item_name,price from menu_items where id=? ";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			MenuItems menu = new MenuItems();
			menu.setId(rs.getInt("id"));
			menu.setItemName(rs.getString("item_name"));
			menu.setPrice(rs.getInt("price"));

			return menu;
		});

	}
}
