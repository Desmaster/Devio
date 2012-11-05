package com.github.desmaster.Devio.realm.entity;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.newdawn.slick.opengl.Texture;

import com.github.desmaster.Devio.realm.Level;

public class Entity {

	public int x = 0;
	public int y = 0;
	protected int entitySize;

	public Texture texture = null;

	public Entity(com.github.desmaster.Devio.util.Position spawnPosition) {
		x = spawnPosition.getX() * Level.BLOCK_SIZE;
		y = spawnPosition.getY() * Level.BLOCK_SIZE;
	}

	public void render() {
		texture.bind();
		glLoadIdentity();
		glTranslatef(x, y, 0);
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
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
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

}
