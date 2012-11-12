package com.github.desmaster.Devio.gfx.effect.effects;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;

import com.github.desmaster.Devio.gfx.Screen;
import com.github.desmaster.Devio.gfx.effect.Effect;

public class FX_Damage extends Effect {

	public int amount = 0;

	public FX_Damage(int amount) {
		this.amount = amount;
		active = true;
	}

	public void tick() {
		if (amount <= 0) {
			active = false;
			Screen.getEffectsHandler().remove(this);
			amount = 0;
		} else {
			amount--;
		}
		
		
	}

	public void render() {
		if (active) {
			glLoadIdentity();
			glColor4f(1, 0.5f, 0.5f, 1);
			glTranslatef(0, 0, 0);
			glBegin(GL_QUADS);
			glVertex2f(0, 0);
			glVertex2f(Display.getWidth(), 0);
			glVertex2f(Display.getWidth(), Display.getHeight());
			glVertex2f(0, Display.getHeight());
			glEnd();
		}
	}

	public void activate() {
		active = true;
	}
}
