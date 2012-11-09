package com.github.desmaster.Devio.gfx.userinterface.userinterfaces;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2i;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.Rectangle;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.gfx.Screen;
import com.github.desmaster.Devio.gfx.userinterface.UserInterface;

public class Interface_Console extends UserInterface {

	public Interface_Console() {
		super("Console");
		container = new Rectangle(0, 0, Display.getWidth(), (Display.getHeight() /4));
		//color = new Color(255, 255, 255, 255);
	}

	public void tick() {
		if (Screen.getInput().grave.clicked) {
			active = !active;
		}
	}
	
	public void render() {
		if (active) {
			renderContainer();
			renderConsole();
			Console.render();
		}
	}
	
	public void renderContainer(){
		glLoadIdentity();
		glDisable(GL_TEXTURE_2D);
		glColor4f(0.15f, 0.15f, 0.15f, 0.8f);
		glTranslatef(container.getX(), container.getY(), 0);
		glBegin(GL_QUADS);
			glVertex2i(container.getX(), container.getY());
			glVertex2i(container.getX() + container.getWidth(), container.getY());
			glVertex2i(container.getX() + container.getWidth(), container.getY() + container.getHeight());
			glVertex2i(container.getX(), container.getY() + container.getHeight());
		glEnd();
	}
	
	public void renderConsole(){
		glLoadIdentity();
		glDisable(GL_TEXTURE_2D);
		glColor4f(0.05f, 0.05f, 0.05f, 0.8f);
		glTranslatef(container.getX(), container.getY(), 0);
		glBegin(GL_QUADS);
			glVertex2i(container.getX() + 10, container.getY() + 10);
			glVertex2i(container.getX() + container.getWidth() - 10, container.getY() + 10);
			glVertex2i(container.getX() + container.getWidth() - 10, container.getY() + container.getHeight() - 40);
			glVertex2i(container.getX() + 10, container.getY() + container.getHeight() - 40);
		glEnd();
	}
	public void renderInputText(){
		glLoadIdentity();
		glDisable(GL_TEXTURE_2D);
		glColor4f(0.05f, 0.05f, 0.05f, 0.8f);
		glTranslatef(container.getX(), container.getY(), 0);
		glBegin(GL_QUADS);
			glVertex2i(container.getX() + 10, container.getY() + 10);
			glVertex2i(container.getX() + container.getWidth() - 10, container.getY() + 10);
			glVertex2i(container.getX() + container.getWidth() - 10, container.getY() + container.getHeight() - 40);
			glVertex2i(container.getX() + 10, container.getY() + container.getHeight() - 40);
		glEnd();
	}
}
