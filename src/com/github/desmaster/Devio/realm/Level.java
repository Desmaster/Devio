package com.github.desmaster.Devio.realm;

import org.lwjgl.opengl.Display;

public class Level {

	public static final int BLOCK_SIZE = 32;
	public static final int BLOCKS_WIDTH = Display.getWidth() / BLOCK_SIZE;
	public static final int BLOCKS_HEIGHT = Display.getHeight() / BLOCK_SIZE;

	public Level() {
		
	}

	public void render() {
		BlockGrid bg = new BlockGrid();
		Scenery sc = new Scenery();
		bg.render(); 
		sc.render();
	}

}
