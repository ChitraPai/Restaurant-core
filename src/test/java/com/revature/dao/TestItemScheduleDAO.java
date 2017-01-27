package com.revature.dao;

import java.util.Iterator;
import java.util.List;

import com.revature.model.ItemSchedule;

public class TestItemScheduleDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemSchedule itemsch = new ItemSchedule();
		ItemScheduleDAO itemschDAO = new ItemScheduleDAO();
		 itemsch.setId(17);
		
//		MealsType meal = new MealsType();
//		meal.setId(4);
//		MenuItems menu = new MenuItems();
//		menu.setId(15);
//		itemsch.setMealId(meal);
//		itemsch.setItemId(menu);
//		itemsch.setQuantity(300);

//		itemschDAO.save(itemsch);
//		itemschDAO.update(itemsch);
//		itemschDAO.delete(itemsch);
//		List<ItemSchedule> list=itemschDAO.list();
//		 Iterator<ItemSchedule> i=list.iterator();
//			while(i.hasNext())
//			{
//				ItemSchedule itemVar=(ItemSchedule) i.next();
//				System.out.println(itemVar.getId()+"\t"+
//						itemVar.getMealId().getId()+"\t"+
//						itemVar.getItemId().getId()+"\t"+
//						itemVar.getQuantity());
//			}
		 itemsch=itemschDAO.listById(10);
			System.out.println(itemsch.getId()+"\t"+itemsch.getMealId().getId()+"\t"+itemsch.getItemId().getId()+"\t"+itemsch.getQuantity());
			
			
			
			
			
	}

}
