package com.github.desmaster.Devio.main;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.file.iFile;
import com.github.desmaster.Devio.gfx.Screen;
import com.github.desmaster.Devio.util.Counter;

public class Devio {

	private DisplayMode dm;

	public static int WIDTH;
	public static int HEIGHT;
	public static final String TITLE = "Devio";
	public final static int fps = 60;
	private boolean fullscreen = false;

	private boolean running = false;

	private Screen screen;
	private Counter counter;
	private InputHandler input;
	private iFile file;

	public Devio() {
		file = new iFile();
		file.loadConfig();
		dm = new DisplayMode(WIDTH, HEIGHT);
	}

	private void init() {
		initScreen();
		launch();
		initObjects();
		initGL();
	}

	private void initScreen() {
		try {
			Display.setTitle(TITLE);
			Display.setDisplayMode(dm);
			Display.setFullscreen(fullscreen);
			Display.setVSyncEnabled(true);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

	private void launch() {

	}

	private void initObjects() {
		screen = new Screen();
		input = new InputHandler(this);
		counter = new Counter();
		counter.start();
	}

	private void initGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	public void run() {
		while (running) {
			Display.update();
			if (Display.isCloseRequested()) {
				stop();
			} else {
				tick();
				render();
			}
		}
	}

	public void start() {
		init();
		running = true;
		run();
	}

	public void stop() {
		running = false;
		Console.log("Stopped the game loop");
		file.saveConfig();
		if (Display.isActive())
			Display.destroy();
		Console.log("Destroyed the screen");
	}

	public void tick() {
		input.tick();
		screen.tick();
		counter.tick();
	}

	public void render() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		screen.render();
		Display.sync(fps);
	}

	public static void main(String[] args) {
		Devio game = new Devio();
		game.start();
	}

}
