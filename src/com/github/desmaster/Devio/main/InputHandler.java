package com.github.desmaster.Devio.main;

import org.lwjgl.input.Keyboard;

public class InputHandler {
	
	private Devio game;
	
	public InputHandler(Devio game) {
		this.game = game;
	}

	public void tick() {
		pollInput();
	}

	public void pollInput() {
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) game.stop();
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				
				if (Keyboard.getEventKey() == Keyboard.KEY_A) {

				}
				if (Keyboard.getEventKey() == Keyboard.KEY_S) {

				}
				if (Keyboard.getEventKey() == Keyboard.KEY_W) {

				}
				if (Keyboard.getEventKey() == Keyboard.KEY_D) {

				}
				
			} else {
				
				if (Keyboard.getEventKey() == Keyboard.KEY_A) {

				}
				if (Keyboard.getEventKey() == Keyboard.KEY_S) {

				}
				if (Keyboard.getEventKey() == Keyboard.KEY_W) {

				}
				if (Keyboard.getEventKey() == Keyboard.KEY_D) {

				}
			}
		}
	}

}
