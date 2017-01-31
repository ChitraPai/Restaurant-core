package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.*;
import com.revature.util.*;

public class SeatInfoDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(SeatInfo seat) {

		String sql = "insert into seat_info(id,seat_name,seat_status) values(?,?,?)";
		Object[] params = { seat.getId(), seat.getSeatName(), seat.getSeatStatus() };
		jdbcTemplate.update(sql, params);

	}

	public void update(SeatInfo seat) {

		String sql = "update seat_info set seat_status=?,seat_name=? where id=?";
		Object[] params = { seat.getSeatStatus(), seat.getSeatName(), seat.getId() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(SeatInfo seat) {
		String sql = "delete from seat_info where id=?";
		Object[] params = { seat.getId() };
		jdbcTemplate.update(sql, params);

	}

	public List<SeatInfo> list() {
		String sql = "select id,seat_name,seat_status from seat_info";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));
	}

	private SeatInfo convert(ResultSet rs) throws SQLException {
		SeatInfo seat = new SeatInfo();
		seat.setId(rs.getInt("id"));
		seat.setSeatName(rs.getString("seat_name"));
		seat.setSeatStatus(rs.getString("seat_status"));
		return seat;
	}

	public List<String> listSeatNames() {
		String sql = "select seat_name from seat_info";
		return jdbcTemplate.queryForList(sql, String.class);

	}

	public SeatInfo listById(int id) {
		String sql = "select id,seat_name,seat_status from seat_info where id=? ";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> convert(rs));
			
	}
}
