package com.revature.dao;

import java.util.List;

import com.revature.model.SeatInfo;

public class TestSeatInfoDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeatInfoDAO seatDAO = new SeatInfoDAO();
	      SeatInfo seat=new SeatInfo();
//	   
//	      seat.setId(11);
//seat.setSeatName("k");
//	   seat.setSeatStatus("Available");
//	    
//	    seatDAO.save(seat);
//	      
//	      seat.setId(11);
//	      seat.setSeatName("M");	      
//	      seat.setSeatStatus("Unavailable");
//	     	      
//	      seatDAO.update(seat);
	      
//	      seatDAO.delete(seat);
	      
//	      List<SeatInfo> list = seatDAO.list();
//	    for(SeatInfo s: list){
//	    	System.out.println(s);
	      
//	      List<String> listSeatNames = seatDAO.lisSeattNames();
//	    for(String s: listSeatNames) {
//	    	System.out.println(s);
//	    }
	      System.out.println(seatDAO.listById(2));
	      
	      
	      
	    }
	      
	}


