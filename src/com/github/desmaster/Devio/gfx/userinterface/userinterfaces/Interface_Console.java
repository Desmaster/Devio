package com.github.desmaster.Devio.gfx.userinterface.userinterfaces;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.Rectangle;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.gfx.Screen;
import com.github.desmaster.Devio.gfx.userinterface.UserInterface;

public class Interface_Console extends UserInterface {

	boolean shouldRenderLine = true;
	int line;
	int lineDelay = 35;
	int lineX = 12;
	
	public Interface_Console() {
		super("Console");
		container = new Rectangle(0, 0, Display.getWidth(), (Display.getHeight() / 4));
		// color = new Color(255, 255, 255, 255);
	}

	public void tick() {
		if (Screen.getInput().grave.clicked) {
			active = !active;
		}
		
		if (shouldRenderLine) {
			if (line < lineDelay)
				line ++;
		} else {
			line--;
		}
		
		if (line == lineDelay)
			shouldRenderLine = false;
		
		if (line == 00)
			shouldRenderLine = true;
		
	}

	public void render() {
		if (active) {
			renderContainer();
			renderConsole();
			Console.render();
		}
	}

	public void renderContainer() {
		glLoadIdentity();
		glDisable(GL_TEXTURE_2D);
		glColor4f(0.15f, 0.15f, 0.15f, 0.8f);
		glTranslatef(container.getX(), container.getY(), 0);
		glBegin(GL_QUADS);
			glVertex2f(container.getX(), container.getY());
			glVertex2f(container.getX() + container.getWidth(), container.getY());
			glVertex2f(container.getX() + container.getWidth(), container.getY() + container.getHeight());
			glVertex2f(container.getX(), container.getY() + container.getHeight());
		glEnd();
		glColor4f(1, 1, 1, 1);
		if (shouldRenderLine) {
		glBegin(GL_LINES);
			glVertex2f(lineX, 135);
			glVertex2f(lineX, 150);
		glEnd();
		}
	}

	public void renderConsole() {
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

	public void renderInputText() {
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
