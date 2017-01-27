package com.revature.model;

import lombok.Data;
@Data
public class ItemSchedule {
	private int id;
	private MealsType mealId;
	private MenuItems itemId;
	private int quantity;
	
}
