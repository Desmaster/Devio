package com.github.desmaster.Devio.realm.item;

public class Item {

	protected String name;
	
	public Item() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public boolean matches(Item item) {
		return item.getClass() == getClass();
	}

}
