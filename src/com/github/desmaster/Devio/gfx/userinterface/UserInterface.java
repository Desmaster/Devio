package com.github.desmaster.Devio.gfx.userinterface;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.Color;
import org.lwjgl.util.Rectangle;

public class UserInterface {

	// State
	protected boolean active = false;

	// Info
	protected String name = "Undefined";

	// Look & Feel
	protected Rectangle container;
	protected Color color = (Color) Color.WHITE;

	public UserInterface(String name) {
		this.name = name;
	}

	public void tick() {
		//glColor4f(0.4f, 0.4f, 0.4f, 1);
	}

	public void render() {
		if (active) {
			glLoadIdentity();
			glTranslatef(container.getX(), container.getY(), 0);
			glBegin(GL_QUADS);
				glVertex2i(container.getX(), container.getY());
				glVertex2i(container.getX() + container.getWidth(), container.getY());
				glVertex2i(container.getX() + container.getWidth(), container.getY() + container.getHeight());
				glVertex2i(container.getX(), container.getY() + container.getHeight());
			glEnd();
			glLoadIdentity();
			
		}
	}

	public void open() {
		active = true;
	}

	public void close() {
		active = false;
	}
}
