package com.github.desmaster.Devio.gfx.userinterface;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.opengl.Display;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.tex.iTexture;

public class UI_hpbar extends UserInterface {

	public int x1 = (Display.getWidth() - 512)/2;
	public int y1 = Display.getHeight() - 16;
	public int x2 = (Display.getWidth() - 512)/2+512;
	public int y2 = Display.getHeight();
	
	public UI_hpbar() {
		super("HP_Bar");
	}
	
	public void tick() {
		
	}
	
	public void render() {
		renderEmpty();
		renderFull((int)Realm.player.getLives());
	}
	
	
	
	public void renderEmpty() {
		iTexture.textures[iTexture.ID_HP_EMPTY].bind();
		glLoadIdentity();
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
	}
	
	public void renderFull(int amount) {
		double i = 512;
		i /= 100;
		i *= amount;
		int amound = 512 - (int)i;
		iTexture.textures[iTexture.ID_HP_FULL].bind();
		glLoadIdentity();
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(x1, y1);
		glTexCoord2f(1, 0);
		glVertex2f(x2 - amound, y1);
		glTexCoord2f(1, 1);
		glVertex2f(x2 - amound, y2);
		glTexCoord2f(0, 1);
		glVertex2f(x1, y2);
		glEnd();
		glLoadIdentity();
	}
}
