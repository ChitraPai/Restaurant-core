package com.revature.model;
import java.time.LocalDateTime;

import lombok.Data;
@Data
public class OrderTransaction {
	private int id;
	private OrderInfo orderId;
	private MenuItems itemId;
	private int itemsQty;
	private LocalDateTime orderTimestamp;
	private String orderStatus;
	
}
