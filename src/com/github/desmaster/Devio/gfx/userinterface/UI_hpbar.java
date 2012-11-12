package com.github.desmaster.Devio.gfx.userinterface;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.opengl.Display;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.tex.iTexture;

public class UI_hpbar extends UserInterface {

	public int x1 = (Display.getWidth() - 512)/2;
	public int y1 = Display.getHeight() - 32;
	public int x2 = (Display.getWidth() - 512)/2+512;
	public int y2 = Display.getHeight();
	
	public UI_hpbar() {
		super("HP_Bar");
	}
	
	public void tick() {
		
	}
	
	public void render() {
		renderEmpty();
	}
	
	
	
	public void renderEmpty() {
		Console.log(x1+" "+y1+" "+x2+" "+y2);
		iTexture.textures[iTexture.ID_HP_EMPTY].bind();
		glLoadIdentity();
		glTranslatef(x1, y1, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(x1, y1);
		glTexCoord2f(1, 0);
		glVertex2f(x2, y1);
		glTexCoord2f(1, 1);
		glVertex2f(x2, y2);
		glTexCoord2f(0, 1);
		glVertex2f(x1, y2);
		glEnd();
		glLoadIdentity();
		Console.log("RENDER!");
	}
}
