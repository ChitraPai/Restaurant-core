package com.revature.dao;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.*;
import com.revature.util.*;
public class SeatInfoDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(SeatInfo seat) {

		String sql = "insert into seat_info(id,seat_name,seat_status) values(?,?,?)";
		Object[] params = { seat.getId(), seat.getSeatName(),seat.getSeatStatus() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}
	public void update(SeatInfo seat) {

		String sql = "update seat_info set seat_status=?,seat_name=? where id=?";
		Object[] params = { seat.getSeatStatus(),seat.getSeatName(), seat.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}
	public void delete(SeatInfo seat)
	{
		String sql="delete from seat_info where id=?";
		Object[] params={seat.getId()};
		int rows= jdbcTemplate.update(sql, params);
		System.out.println("No of rows delated:"+ rows);
		
	}
	public List<SeatInfo> list() {
		String sql = "select id,seat_name,seat_status from seat_info";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			SeatInfo seat=new SeatInfo();
			seat.setId(rs.getInt("id"));
			seat.setSeatName(rs.getString("seat_name"));
			seat.setSeatStatus(rs.getString("seat_status"));
				
			return seat;
		});
		}
	
	public List<String> listSeatNames() {
		String sql= "select seat_name from seat_info";
		return jdbcTemplate.queryForList(sql, String.class);
		
			}
	public SeatInfo listById(int id){
		String sql="select id,seat_name,seat_status from seat_info where id=? ";
		Object[] params={id};
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			SeatInfo seat=new SeatInfo();
			seat.setId(rs.getInt("id"));
		   seat.setSeatName(rs.getString("seat_name"));
		seat.setSeatStatus(rs.getString("seat_status"));
			
			return seat;
		});
		
	}
}
