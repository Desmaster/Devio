package com.github.desmaster.Devio.realm.entity;

import org.lwjgl.Sys;
import org.newdawn.slick.opengl.Texture;

import com.github.desmaster.Devio.InputHandler;
import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.tex.iTexture;
import com.github.desmaster.Devio.util.Position;

public class Player extends Mob {

	boolean running = false;
	Thread thread;

	private static boolean shouldTick = true;
	int fps;
	long lastFrame;
	long lastFPS;

	public InputHandler input;

	public Player(Texture texture, Position spawnPosition, double lives, InputHandler input) {
		super(spawnPosition, lives);
		this.input = input;
		entitySize = Realm.BLOCK_SIZE;
		setTexture(iTexture.PLAYER_BILLIE);
	}

	public void start() {

	}

	public void tick(int delta) {
		if (shouldTick) {
			if (input.up.down) {
				input.releaseAll();
				walkUp();
			}

			if (input.left.down) {
				input.releaseAll();
				walkLeft();
			}

			if (input.down.down) {
				input.releaseAll();
				walkDown();
			}

			if (input.right.down) {
				input.releaseAll();
				walkRight();
			}
		}

	}

	public int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		return delta;
	}

	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	public int getXonScreen() {
		return (x - Realm.world.getVisibleMapOffsetPosition(this).getX()) * 32;
	}

	public int getYonScreen() {
		return (y - Realm.world.getVisibleMapOffsetPosition(this).getY()) * 32;
	}

	public void disableInput() {
		shouldTick = false;
	}

	public void enableInput() {
		shouldTick = true;
	}

}
