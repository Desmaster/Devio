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
	public Key backspace = new Key();

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
		case Keyboard.KEY_BACK:
			backspace.toggle(pressed);
			break;
		}
	}

	public void pollInput() {
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				toggle(Keyboard.getEventKey(), true);
				if (Console.isActive()) {
					String s = Keyboard.getKeyName(Keyboard.getEventKey());
					Console.log(s);
					if (!(s == Keyboard.getKeyName(Keyboard.KEY_SPACE) || s == Keyboard.getKeyName(Keyboard.KEY_BACK) || s == Keyboard.getKeyName(Keyboard.KEY_RETURN) || s == Keyboard.getKeyName(Keyboard.KEY_LCONTROL))) {
						Console.log("DERPPP");
						s = s.toLowerCase();
						char letter = s.charAt(0);
						switch (letter) {
						case 'a':
							Console.type(letter);
							break;
						case 'b':
							Console.type(letter);
							break;
						case 'c':
							Console.type(letter);
							break;
						case 'd':
							Console.type(letter);
							break;
						case 'e':
							Console.type(letter);
							break;
						case 'f':
							Console.type(letter);
							break;
						case 'g':
							Console.type(letter);
							break;
						case 'h':
							Console.type(letter);
							break;
						case 'i':
							Console.type(letter);
							break;
						case 'j':
							Console.type(letter);
							break;
						case 'k':
							Console.type(letter);
							break;
						case 'l':
							Console.type(letter);
							break;
						case 'm':
							Console.type(letter);
							break;
						case 'n':
							Console.type(letter);
							break;
						case 'o':
							Console.type(letter);
							break;
						case 'p':
							Console.type(letter);
							break;
						case 'q':
							Console.type(letter);
							break;
						case 'r':
							Console.type(letter);
							break;
						case 's':
							Console.type(letter);
							break;
						case 't':
							Console.type(letter);
							break;
						case 'u':
							Console.type(letter);
							break;
						case 'v':
							Console.type(letter);
							break;
						case 'w':
							Console.type(letter);
							break;
						case 'x':
							Console.type(letter);
							break;
						case 'y':
							Console.type(letter);
							break;
						case 'z':
							Console.type(letter);
							break;
						}
					}
				}
			} else {
				toggle(Keyboard.getEventKey(), false);
			}
		}
	}
}
