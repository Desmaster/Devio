package com.github.desmaster.Devio.gfx.userinterface;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.Rectangle;

public class UserInterface {

	// State
	protected boolean active = false;

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

	public void close() {
		active = false;
	}
}
