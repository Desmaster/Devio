package com.github.desmaster.Devio.realm;

import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;

import static com.github.desmaster.Devio.realm.Level.*;

public class Block {

	public Texture texture = null;
	private float x;
	private float y;

	public Block(Texture texture, float x, float y) {
		this.texture = texture;
		this.x = x;
		this.y = y;
	}

	public void render() {
		texture.bind();
		glLoadIdentity();
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(0, 0);
			glTexCoord2f(1, 0);
			glVertex2f(BLOCK_SIZE, 0);
			glTexCoord2f(1, 1);
			glVertex2f(BLOCK_SIZE, BLOCK_SIZE);
			glTexCoord2f(0, 1);
			glVertex2f(0, BLOCK_SIZE);
		glEnd();
		glLoadIdentity();
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
