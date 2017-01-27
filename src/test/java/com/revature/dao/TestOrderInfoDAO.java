package com.revature.dao;

import java.util.List;

import com.revature.model.OrderInfo;

public class TestOrderInfoDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
OrderInfo order=new OrderInfo();
OrderInfoDAO orderDAO=new OrderInfoDAO();

//order.setSeatName("C");
//orderDAO.save(order);

//order.setId(2);
//order.setOrderStatus("Served");
//orderDAO.update(order);

//order.setId(3);
//orderDAO.delete(order);

//List<OrderInfo> list=orderDAO.list();
//for(OrderInfo o:list)
//{
//System.out.println(o);
//	}

//List<String> listSeatNames=orderDAO.listSeatNames();
//for(String s:listSeatNames){
//	System.out.println(s);
//}

System.out.println(orderDAO.listById(1));

	}
}
