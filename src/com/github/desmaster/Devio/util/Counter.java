package com.github.desmaster.Devio.util;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;

import com.github.desmaster.Devio.main.Devio;

public class Counter {

	int fps;
	long lastFrame;
	long lastFPS;
	
	public Counter() {
		
	}

	public void start() {
		lastFPS = getTime();
		getDelta();
	}

	public void tick() {
		int delta = getDelta();
		tick(delta);
	}

	public void tick(int delta) {
		updateFPS();
	}

	public void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			//if (fps != Devio.fps)
			//Console.log("fps: " + fps);
			Display.setTitle(Devio.TITLE + " | FPS: " + fps);
			
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}

	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	public int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		return delta;
	}

}
