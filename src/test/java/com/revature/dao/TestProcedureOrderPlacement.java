package com.revature.dao;

public class TestProcedureOrderPlacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProcedureOrderPlacementDAO dao = new ProcedureOrderPlacementDAO();
		String status = dao.orderPlacement("south indian meals,north indian thali,chappathi","3,2,3","a");
		System.out.println(status);
	}

}
