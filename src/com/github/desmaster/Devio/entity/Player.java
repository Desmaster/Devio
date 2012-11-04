package com.github.desmaster.Devio.entity;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import com.github.desmaster.Devio.InputHandler;
import com.github.desmaster.Devio.realm.Level;
import com.github.desmaster.Devio.texture.iTexture;

public class Player extends Mob implements Runnable {

	private int walkspeed = Level.BLOCK_SIZE;
	boolean running = false;
	Thread thread;

	int fps;
	long lastFrame;
	long lastFPS;

	public InputHandler input;

	public Player(Texture texture, int x, int y, double lives,
			InputHandler input) {
		super(x, y, lives);
		this.input = input;
		entitySize = Level.BLOCK_SIZE;
		setTexture(iTexture.PLAYER_BILLIE);
		start();
	}

	public void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void tick(int delta) {
		x = 15;
		//if (x < 0) {
		//	x = 0;
		//	input.x = 0;
		//}

		//if (y < 0) {
		//	y = 0;
		//	input.y = 0;
		//}

		if (x + walkspeed > Display.getWidth()) {
			//x = Display.getWidth() - walkspeed;
		}

		if (y + walkspeed > Display.getHeight()) {
			y = Display.getHeight() - walkspeed;
		}

		if (input.up.clicked) {
			input.releaseAll();
			walkUp();
		}

		if (input.left.clicked) {
			input.releaseAll();
			//walkLeft();
		}

		if (input.down.clicked) {
			input.releaseAll();
			walkDown();
		}

		if (input.right.clicked) {
			input.releaseAll();
			walkRight();
		}

	}

	public void walkUp() {
		y -= walkspeed;
	}

	public void walkDown() {
		y += walkspeed;
	}

	public void walkLeft() {
		x -= walkspeed;
	}

	public void walkRight() {
		x += walkspeed;
	}

	@Override
	public void run() {
		while (running) {
			// tick(getDelta());
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
	
	

}
