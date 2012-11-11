package com.github.desmaster.Devio.gfx.userinterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.realm.storage.Inventory;

public class UserInterfaceHandler {

	public static List<UserInterface> InterfaceList = new ArrayList<UserInterface>();

	public UserInterfaceHandler() {
		InterfaceList.add(new Inventory());
		InterfaceList.add(new Console());
	}

	public void tick() {
		Iterator<UserInterface> iterator = InterfaceList.iterator();
		while (iterator.hasNext()) {
			
			iterator.next().tick();
		}
	}

	public void render() {
		Iterator<UserInterface> iterator = InterfaceList.iterator();
		while (iterator.hasNext()) {
			iterator.next().render();
		}
	}
}
