package com.github.desmaster.Devio;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.github.desmaster.Devio.cons.Console;

public class InputHandler {

	Thread thread;

	public class Key {

		public int presses, absorbs;
		public boolean down, clicked;

		public void tick() {
			if (absorbs < presses) {
				absorbs++;
				clicked = true;
			} else {
				clicked = false;
			}
		}

		public void toggle(boolean pressed) {
			if (pressed != down) {
				down = pressed;
			}

			if (pressed) {
				presses++;
			}
		}

		public Key() {
			keys.add(this);
		}
	}

	public List<Key> keys = new ArrayList<Key>();

	public Key left = new Key();
	public Key right = new Key();
	public Key up = new Key();
	public Key down = new Key();
	public Key exit = new Key();
	public Key grave = new Key();

	public InputHandler(Devio game) {
		// this.game = game;
	}

	public void tick() {
		pollInput();
		for (int i = 0; i < keys.size(); i++) {
			keys.get(i).tick();
		}
	}

	public void releaseAll() {
		for (int i = 0; i < keys.size(); i++) {
			keys.get(i).down = false;
		}
	}

	public void toggle(int e, boolean pressed) {
		switch (e) {
		case Keyboard.KEY_A:
			left.toggle(pressed);
			break;
		case Keyboard.KEY_LEFT:
			left.toggle(pressed);
			break;
		case Keyboard.KEY_D:
			right.toggle(pressed);
			break;
		case Keyboard.KEY_RIGHT:
			right.toggle(pressed);
			break;
		case Keyboard.KEY_W:
			up.toggle(pressed);
			break;
		case Keyboard.KEY_UP:
			up.toggle(pressed);
			break;
		case Keyboard.KEY_S:
			down.toggle(pressed);
			break;
		case Keyboard.KEY_DOWN:
			down.toggle(pressed);
			break;
		case Keyboard.KEY_ESCAPE:
			exit.toggle(pressed);
			break;
		case Keyboard.KEY_GRAVE:
			grave.toggle(pressed);
			break;
		case Keyboard.KEY_F1:
			grave.toggle(pressed);
			break; // Beter dan de grave toch?
		}
	}

	public void pollInput() {
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				toggle(Keyboard.getEventKey(), true);
				char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
				String s = Keyboard.getKeyName(Keyboard.getEventKey());
				char letter = s.charAt(0);
				
				Console.log("" +letter);
			} else {
				toggle(Keyboard.getEventKey(), false);
			}
		}
	}
}
