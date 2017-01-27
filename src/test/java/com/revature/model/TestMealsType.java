package com.revature.model;

import java.time.LocalTime;

public class TestMealsType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
MealsType meal=new MealsType();
meal.setId(5);
meal.setMealName("Brunch");
meal.setFromTime(LocalTime.parse("10:15:00"));
meal.setToTime(LocalTime.parse("12:00:00"));
	
	System.out.println(meal.toString());

	System.out.println(meal.getId());
	System.out.println(meal.getMealName());
	System.out.println(meal.getFromTime());
	System.out.println(meal.getToTime());
}
}
