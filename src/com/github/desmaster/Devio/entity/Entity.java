package com.github.desmaster.Devio.entity;

import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.opengl.Texture;

import com.github.desmaster.Devio.realm.Level;

public class Entity {

	public float x = 0;
	public float y = 0;
	protected int entitySize;

	public Texture texture = null;

	public Entity(float x, float y) {
		this.x = x * Level.BLOCK_SIZE;;
		this.y = y * Level.BLOCK_SIZE;;
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

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
