package com.revature.validator;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.revature.dao.MenuItemsDAO;
import com.revature.exception.ItemNotFoundException;
import com.revature.model.MenuItems;

public class ItemValidator {
	Logger logger = Logger.getLogger(MenuItemsDAO.class.getName());

	public void vaildateSave(MenuItems menu) {
		if ("".equals(menu.getItemName())) {
			try {
				throw new ItemNotFoundException("Item is null");
			} catch (ItemNotFoundException e) {
				logger.log(Level.INFO, "Null Item exception", e);
			}
		}

	}
}
