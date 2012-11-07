package com.github.desmaster.Devio.gfx.userinterface;

import java.awt.Color;

import org.lwjgl.util.Rectangle;

public class UserInterface {

	//State
	private boolean active = false;
	
	//Info
	private String name = "Undefined";
	
	//Look & Feel
	private boolean Enabled_Titlebar = true;
	private boolean Enabled_Title = true;
	private boolean Enabled_CloseButton = true;
	private Rectangle container = new Rectangle(0,0,0,0);
	private Color color = Color.white;
	
	public UserInterface(String name) {
		this.name = name;
	}
	
}
