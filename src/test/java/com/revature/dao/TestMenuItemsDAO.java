package com.revature.dao;

import java.util.List;

import com.revature.model.MealsType;
import com.revature.model.MenuItems;

public class TestMenuItemsDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuItemsDAO menuDAO = new MenuItemsDAO();
	      MenuItems menu=new MenuItems();
	    menu.setId(15);
  menu.setItemName("Naan");
	    menu.setPrice(40);
	    
	    menuDAO.save(menu);
//	    menuDAO.update(menu);
//	    menuDAO.delete(menu);
//	    List<MenuItems> list = menuDAO.list();
//	    for(MenuItems m: list){
//	    	System.out.println(m);
//	    	    }
	
//	    List<String> listNames = menuDAO.list1();
//	    for(String m: list1){
//	    	System.out.println(m);
//	    }
	    
//	    System.out.println(menuDAO.listById(1));
	
	}

}
