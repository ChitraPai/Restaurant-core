package com.revature.dao;

import java.util.Iterator;
import java.util.List;

import com.revature.model.MenuItems;
import com.revature.model.OrderInfo;
import com.revature.model.OrderTransaction;

public class TestOrderTransactionDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderTransaction orderTransaction=new OrderTransaction();
		OrderTransactionDAO orderTransactionDAO=new OrderTransactionDAO();
//		OrderInfo order=new OrderInfo();
//     	order.setId(1);
//		MenuItems menu = new MenuItems();
//	    menu.setId(15);
//	    orderTransaction.setOrderId(order);
//		
//		orderTransaction.setItemId(menu);
//		orderTransactionDAO.save(orderTransaction);
//		orderTransaction.setId(1);
//		List<OrderTransaction> list=orderTransactionDAO.list();
//		 Iterator<OrderTransaction> i=list.iterator();
//			while(i.hasNext())
//			{
//				OrderTransaction orderVar=(OrderTransaction) i.next();
//				System.out.println(orderVar.getId()+"\t"+
//						orderVar.getOrderId().getId()+"\t"+
//						orderVar.getItemId().getId()+"\t"+
//						orderVar.getItemsQty()+"\t"+
//				        orderVar.getOrderTimestamp().toLocalDate()+"\t"+
//						orderVar.getOrderStatus());
//						
//						
//			}
		
				
		orderTransaction=orderTransactionDAO.listById(1);
		System.out.println(orderTransaction.getId()+"\t"+orderTransaction.getItemId().getId()+"\t"+orderTransaction.getItemsQty()+"\t"+orderTransaction.getOrderTimestamp().toLocalDate()+"\t"+
				orderTransaction.getOrderStatus());;
		
	}

	}

