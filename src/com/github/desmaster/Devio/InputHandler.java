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
	public Key enter = new Key();

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
		case Keyboard.KEY_F1:
			grave.toggle(pressed);
			break; // Beter dan de grave toch?
		case Keyboard.KEY_BACK:
			backspace.toggle(pressed);
			break;
		case Keyboard.KEY_RETURN:
			enter.toggle(pressed);
			break;
		}
	}

	public void pollInput() {
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				toggle(Keyboard.getEventKey(), true);
				if (Console.isActive()) {
					pollTyping(Keyboard.getEventKey());
				}
			} else {
				toggle(Keyboard.getEventKey(), false);
			}
		}
	}

	public void pollTyping(int e) {
		switch (e) {
		
		case Keyboard.KEY_A:
			Console.type('a');
			break;
		case Keyboard.KEY_B:
			Console.type('b');
			break;
		case Keyboard.KEY_C:
			Console.type('c');
			break;
		case Keyboard.KEY_D:
			Console.type('d');
			break;
		case Keyboard.KEY_E:
			Console.type('e');
			break;
		case Keyboard.KEY_F:
			Console.type('f');
			break;
		case Keyboard.KEY_G:
			Console.type('g');
			break;
		case Keyboard.KEY_H:
			Console.type('h');
			break;
		case Keyboard.KEY_I:
			Console.type('i');
			break;
		case Keyboard.KEY_J:
			Console.type('j');
			break;
		case Keyboard.KEY_K:
			Console.type('k');
			break;
		case Keyboard.KEY_L:
			Console.type('l');
			break;
		case Keyboard.KEY_M:
			Console.type('m');
			break;
		case Keyboard.KEY_N:
			Console.type('n');
			break;
		case Keyboard.KEY_O:
			Console.type('O');
			break;
		case Keyboard.KEY_P:
			Console.type('p');
			break;
		case Keyboard.KEY_Q:
			Console.type('q');
			break;
		case Keyboard.KEY_R:
			Console.type('r');
			break;
		case Keyboard.KEY_S:
			Console.type('s');
			break;
		case Keyboard.KEY_T:
			Console.type('t');
			break;
		case Keyboard.KEY_U:
			Console.type('u');
			break;
		case Keyboard.KEY_V:
			Console.type('v');
			break;
		case Keyboard.KEY_W:
			Console.type('w');
			break;
		case Keyboard.KEY_X:
			Console.type('x');
			break;
		case Keyboard.KEY_Y:
			Console.type('y');
			break;
		case Keyboard.KEY_Z:
			Console.type('z');
			break;
		case Keyboard.KEY_SPACE:
			Console.type(' ');
			break;
		case Keyboard.KEY_SLASH:
			Console.type("/");
			break;
		}
	}
}
