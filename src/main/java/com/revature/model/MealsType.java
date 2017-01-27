package com.revature.model;
import java.time.LocalTime;

import lombok.Data;
@Data
public class MealsType {
	private int id;
	private String mealName;
	private LocalTime fromTime;
	private LocalTime toTime;
	
}
