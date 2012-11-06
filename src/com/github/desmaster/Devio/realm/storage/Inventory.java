package com.github.desmaster.Devio.realm.storage;

import java.util.ArrayList;
import java.util.List;

import com.github.desmaster.Devio.realm.item.Item;

public class Inventory {

	public List<Item> items = new ArrayList<Item>();
	
	public void add(int slot, Item item) {
		items.add(slot, item);
	} 
	
	
	
}
