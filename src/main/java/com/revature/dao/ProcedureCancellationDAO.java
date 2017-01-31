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

public class ProcedureCancellationDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public String orderCancellation(String seat) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("pr_order_cancellation")
				.declareParameters(new SqlParameter("input_seat_name", Types.CHAR),
						new SqlOutParameter("message", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue("input_seat_name", seat);
		Map<String, Object> execute = call.execute(in);
		return (String) execute.get("message");

	}
}
