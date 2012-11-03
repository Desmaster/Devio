package com.github.desmaster.Devio.entity;

import org.newdawn.slick.opengl.Texture;

import com.github.desmaster.Devio.InputHandler;
import com.github.desmaster.Devio.realm.Level;
import com.github.desmaster.Devio.texture.iTexture;

public class Player extends Mob implements Runnable {

	private float walkspeed = 32.0f;

	public InputHandler input;
	private boolean running = false;
	Thread thread;
	long delay = 225;

	public Player(Texture texture, float x, float y, double lives,
			InputHandler input) {
		super(x, y, lives);
		this.input = input;
		entitySize = Level.BLOCK_SIZE;
		setTexture(iTexture.PLAYER_NINJA);

		start();
	}

	private void start() {
		running = true;
		thread = new Thread(this, "Input");
		thread.start();
	}

	public void tick() {
		x = input.x;
		y = input.y;

		if (input.left)
			input.x -= walkspeed;
		if (input.right)
			input.x += walkspeed;
		if (input.up)
			input.y -= walkspeed;
		if (input.down)
			input.y += walkspeed;
	}

	public void run() {
		while (running) {
			tick();
			try {
				if(input.x == x && input.y == y)
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
