package com.revature.dao;

import java.time.LocalTime;
import java.util.List;

import com.revature.model.MealsType;

public class TestMealsTypeDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MealsTypeDAO mealDAO = new MealsTypeDAO();
      MealsType meal=new MealsType();
//    meal.setId(5);
//  meal.setMealName("BrunchTime");
//   meal.setFromTime(LocalTime.parse("10:15:00"));
//      meal.setToTime(LocalTime.parse("12:00:00"));
//      
      
//      mealDAO.save(meal);
//      
      
//      mealDAO.update(meal);
//    mealDAO.delete(meal);
   
//    System.out.println(mealDAO.list());
   List<MealsType> list = mealDAO.list();
 for(MealsType m: list){
    	System.out.println(m);
    }
    
    
//    List<String> listMealNames = mealDAO.list1();
//    for(String m: listMealNames){
//    	System.out.println(m);
//    }
    
//   System.out.println(mealDAO.listMealNames());
//   System.out.println(mealDAO.listById(1));
	}

}
