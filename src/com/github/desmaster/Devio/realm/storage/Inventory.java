package com.github.desmaster.Devio.realm.storage;

import java.util.ArrayList;
import java.util.List;

import com.github.desmaster.Devio.gfx.userinterface.UserInterface;
import com.github.desmaster.Devio.realm.item.Item;

public class Inventory extends UserInterface {

	public Inventory(String name) {
		super(name);
	}

	public List<Item> items = new ArrayList<Item>();
	
	public void add(int slot, Item item) {
		items.add(slot, item);
	} 
	
	public boolean contains(Item item) {
		return items.contains(items);
	}
	
	public boolean contains(Item item, int count) {
		List<Item> items = new ArrayList<Item>();
		for(int i = 0; i < count; i++) {
			items.add(item);
		}
		return items.containsAll(items);
	}
	
}
