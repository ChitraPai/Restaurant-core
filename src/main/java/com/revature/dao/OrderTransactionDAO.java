package com.revature.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.*;
import com.revature.util.*;

public class OrderTransactionDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(OrderTransaction orderTransaction) {

		String sql = "insert into order_transaction(order_id,items_id,items_qty) values(?,?,?)";
		Object[] params = { orderTransaction.getOrderId().getId(), orderTransaction.getItemId().getId(),
				orderTransaction.getItemsQty() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public List<OrderTransaction> list() {
		String sql = "select id,order_id,items_id,items_qty,order_timestamp,order_status from order_transaction";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			OrderTransaction orderTransaction = new OrderTransaction();
			orderTransaction.setId(rs.getInt("id"));

			OrderInfo order = new OrderInfo();
			order.setId(rs.getInt("order_id"));
			orderTransaction.setOrderId(order);

			MenuItems menu = new MenuItems();
			menu.setId(rs.getInt("items_id"));
			orderTransaction.setItemId(menu);

			orderTransaction.setItemsQty(rs.getInt("items_qty"));
			orderTransaction.setOrderTimestamp(rs.getTimestamp("order_timestamp").toLocalDateTime());
			orderTransaction.setOrderStatus(rs.getString("order_status"));

			return orderTransaction;
		});

	}

	public OrderTransaction listById(int id) {

		String sql = "select id,order_id,items_id,items_qty,order_timestamp,order_status from order_transaction where id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			OrderTransaction orderTransaction = new OrderTransaction();
			orderTransaction.setId(rs.getInt("id"));

			OrderInfo order = new OrderInfo();
			order.setId(rs.getInt("order_id"));
			orderTransaction.setOrderId(order);

			MenuItems menu = new MenuItems();
			menu.setId(rs.getInt("items_id"));
			orderTransaction.setItemId(menu);

			orderTransaction.setItemsQty(rs.getInt("items_qty"));
			orderTransaction.setOrderTimestamp(rs.getTimestamp("order_timestamp").toLocalDateTime());
			orderTransaction.setOrderStatus(rs.getString("order_status"));

			return orderTransaction;
		});
	}
}
