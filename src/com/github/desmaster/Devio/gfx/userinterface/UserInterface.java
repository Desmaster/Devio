package com.github.desmaster.Devio.gfx.userinterface;

import org.lwjgl.util.Rectangle;

public class UserInterface {

	// State
	protected static boolean active = false;

	// Info
	protected String name = "Undefined";

	// Look & Feel
	protected Rectangle container;

	public UserInterface(String name) {
		this.name = name;
	}

	public void tick() {
	}

	public void render() {

	}

	public void open() {
		active = true;
	}

	public static void close() {
		active = false;
	}
	
	public static boolean isActive() {
		return active;
	}
}
