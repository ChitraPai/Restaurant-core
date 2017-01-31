package com.revature.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.*;
import com.revature.util.*;

public class OrderInfoDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(OrderInfo order) {

		String sql = "insert into order_info(seat_name) values(?)";
		Object[] params = { order.getSeatName() };
		jdbcTemplate.update(sql, params);

	}

	public void update(OrderInfo order) {

		String sql = "update order_info set order_status=? where id=?";
		Object[] params = { order.getOrderStatus(), order.getId() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(OrderInfo order) {
		String sql = "delete from order_info where id=?";
		Object[] params = { order.getId() };
		jdbcTemplate.update(sql, params);

	}

	public List<OrderInfo> list() {
		String sql = "select id,seat_name,order_status from order_info";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			OrderInfo order = new OrderInfo();
			order.setId(rs.getInt("id"));
			order.setSeatName(rs.getString("seat_name"));
			order.setOrderStatus(rs.getString("order_status"));

			return order;
		});
	}

	public List<String> listSeatNames() {
		String sql = "select seat_name from order_info";
		return jdbcTemplate.queryForList(sql, String.class);
	}

	public OrderInfo listById(int id) {
		String sql = "select id,seat_name,order_status from order_info where id=? ";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			OrderInfo order = new OrderInfo();
			order.setId(rs.getInt("id"));
			order.setSeatName(rs.getString("seat_name"));
			order.setOrderStatus(rs.getString("order_status"));

			return order;
		});
	}
}
