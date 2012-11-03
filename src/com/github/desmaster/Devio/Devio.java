package com.github.desmaster.Devio;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.gfx.Screen;
import com.github.desmaster.Devio.util.Counter;
import com.github.desmaster.Devio.util.iFile;

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
	private InputHandler input = new InputHandler(this);
	private iFile file;
	//private Player player;
	

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
		screen = new Screen(input);
		counter = new Counter();
		counter.start();
	}

	private void initGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D); // Enable 2D Texture Rendering
		glEnable(GL_BLEND); // Enable GL Blending
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA); // You need to enable blending to allow transparent bits on an image when using OpenGL.
	}

	public void run() {
		while (running) {
			Display.update();
			if (Display.isCloseRequested()) {
				stop();
				
			} else {
				tick();
				scanInput();
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
		Console.log("Destroyed the screen");
		System.exit(0);
	}

	public void tick() {
		input.tick();
		screen.tick();
		counter.tick();
	}
	
	public void scanInput() {
		if (input.exit) stop();
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
