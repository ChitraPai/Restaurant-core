package com.revature.dao;

public class TestProcedureCancellationDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProcedureCancellationDAO dao = new ProcedureCancellationDAO();
		String status = dao.orderCancellation("a");
		System.out.println(status);
	}

}
