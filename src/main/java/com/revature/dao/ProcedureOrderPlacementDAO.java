package com.revature.dao;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.revature.util.ConnectionUtil;
public class ProcedureOrderPlacementDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public String orderPlacement(String food, String qty, String seat) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("pr_order_placement1")
				.declareParameters(new SqlParameter("food_itm", Types.VARCHAR),
						new SqlParameter("food_qty", Types.VARCHAR), new SqlParameter("in_seat_name", Types.CHAR),
						new SqlOutParameter("result", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue("food_itm", food).addValue("food_qty", qty)
				.addValue("in_seat_name", seat);

		Map<String, Object> execute = call.execute(in);
		String status = (String) execute.get("result");
		return status;

	}
}
