package com.github.desmaster.Devio;

import org.lwjgl.input.Keyboard;

public class InputHandler {
	
	public float x = 0;
	public float y = 0;
	
	//private Devio game;
	public boolean up = false;
	public boolean left = false;
	public boolean down = false;
	public boolean right = false;
	public boolean exit = false;
	Thread thread;
	
	public InputHandler(Devio game) {
		//this.game = game;
	}

	public void tick() {
		up = false;
		left = false;
		down = false;
		right = false;
		exit = false;
		pollInput();
	}
	
	public void pollInput() {
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) exit = true;
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) left = true;
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) right = true;
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) up = true;
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) down = true;
	}

}
