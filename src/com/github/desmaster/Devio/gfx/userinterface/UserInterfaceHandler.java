package com.github.desmaster.Devio.gfx.userinterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.desmaster.Devio.InputHandler;
import com.github.desmaster.Devio.gfx.userinterface.userinterfaces.Interface_Console;

public class UserInterfaceHandler {
	
	public static List<UserInterface> InterfaceList = new ArrayList<UserInterface>();
	
	
	public UserInterfaceHandler(){
		InterfaceList.add(new Interface_Console());
	}
	
	public void tick(){
		Iterator<UserInterface> iterator = InterfaceList.iterator();
		while (iterator.hasNext()) {
			iterator.next().tick();
		}
	}
	
	public void render(){
		Iterator<UserInterface> iterator = InterfaceList.iterator();
		while (iterator.hasNext()) {
			iterator.next().render();
		}
	}
}
