package com.github.desmaster.Devio.gfx.screens;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.gfx.Screen;
import com.github.desmaster.Devio.gfx.Screen.State;
import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.tex.iTexture;

public class Screen_Death {
	
	public static void tick(){
		if (Screen.getInput().enter.clicked) {
			Realm.player.setLives(100);
			Realm.player.setX(2);
			Realm.player.setY(2);
			Console.reset();
			Realm.reset();
			Screen.state = State.GAME;
		}
	}
	
	public static void render(){
		tick();
		iTexture.textures[iTexture.ID_SCREEN_DEATH].bind();
		glLoadIdentity();
		glTranslatef(0, 0, 0);
		glBegin(GL_QUADS);
		
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		
		glTexCoord2f(1, 0);
		glVertex2f(Display.getWidth(), 0);
		
		glTexCoord2f(1, 1);
		glVertex2f(Display.getWidth(), Display.getHeight());
		
		glTexCoord2f(0, 1);
		glVertex2f(0, Display.getHeight());
		
		glEnd();
		glLoadIdentity();
	}
}
