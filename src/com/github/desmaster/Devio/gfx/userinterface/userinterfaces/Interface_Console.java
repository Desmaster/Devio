package com.github.desmaster.Devio.gfx.userinterface.userinterfaces;

import java.awt.Color;

import org.lwjgl.util.Rectangle;

import com.github.desmaster.Devio.gfx.Screen;
import com.github.desmaster.Devio.gfx.userinterface.UserInterface;
import com.github.desmaster.Devio.realm.Realm;

public class Interface_Console extends UserInterface{

	public Interface_Console() {
		super("Console");
		container = new Rectangle(20,20,Realm.MAP_WIDTH - 40,Realm.MAP_HEIGHT / 4 - 40);
		color = new Color(0,0,0,166);
	}
	
	public void tick(){
		if (Screen.getInput().grave.down) {
			Screen.getInput().releaseAll();
			active = !active;
		}
	}
	
	

}
