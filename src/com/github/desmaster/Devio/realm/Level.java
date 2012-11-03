package com.github.desmaster.Devio.realm;

import org.lwjgl.opengl.Display;

import com.github.desmaster.Devio.realm.BlockGrid;
import com.github.desmaster.Devio.texture.iTexture;

public class Level {

	public static final int BLOCK_SIZE = 16;
	public static final int BLOCKS_WIDTH = Display.getWidth() / BLOCK_SIZE;
	public static final int BLOCKS_HEIGHT = Display.getHeight() / BLOCK_SIZE;

	public Level() {
		
	}

	public void render() {
		BlockGrid bg = new BlockGrid();
		bg.setAt(5, 7, iTexture.TEST_TEXTURE);
		bg.render();
	}

}
