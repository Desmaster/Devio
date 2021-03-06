package com.github.desmaster.Devio.realm.entity;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.newdawn.slick.opengl.Texture;

import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.tex.iTexture;

public class Entity {

	public int x = 0;
	public int y = 0;
	protected int entitySize = 32;
	int face = 0; // Up = 0 Right = 1 Down = 2 Left = 3
	
	public int texture = 1;

	public Entity(com.github.desmaster.Devio.util.Position spawnPosition) {
		x = spawnPosition.getX();
		y = spawnPosition.getY();
	}

	public void render() {
		getTexture().bind();
		glLoadIdentity();
		glTranslatef(getXonScreen(), getYonScreen(), 0);
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(0, 0);
			glTexCoord2f(1, 0);
			glVertex2f(entitySize, 0);
			glTexCoord2f(1, 1);
			glVertex2f(entitySize, entitySize);
			glTexCoord2f(0, 1);
			glVertex2f(0, entitySize);
		glEnd();
		glLoadIdentity();
	}

	public void tick() {
		
	}

	public Texture getTexture() {
		return iTexture.textures[texture];
	}

	public void setTexture(int id) {
		this.texture = id;
	}
		
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getXonScreen(){
		return (x - Realm.world.getVisibleMapOffsetPosition(Realm.player).getX()) * 32;
	}
	public int getYonScreen(){
		return (y - Realm.world.getVisibleMapOffsetPosition(Realm.player).getY()) * 32;
	}
}
