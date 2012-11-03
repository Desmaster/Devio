package com.github.desmaster.Devio.realm;

import static com.github.desmaster.Devio.realm.Level.*;

import org.newdawn.slick.opengl.Texture;

import com.github.desmaster.Devio.texture.iTexture;

public class BlockGrid {
	
	public Block[][] blocks = new Block[BLOCKS_WIDTH][BLOCKS_HEIGHT];
	
	public BlockGrid() {
		for (int x = 0; x < BLOCKS_WIDTH; x++) {
			for (int y = 0; y < BLOCKS_HEIGHT; y++) {
				blocks[x][y] = new Block(iTexture.BETA_GRASS, x * BLOCK_SIZE, y * BLOCK_SIZE);
			}
		}
	}
	
	public void setAt(int x, int y, Texture b) {
		blocks[x][y] = new Block(b, x * BLOCK_SIZE, y * BLOCK_SIZE);
	}
	
	public Block getAt(int x, int y) {
		return blocks[x][y];
	}
	
	public void render() {
		for (int x = 0; x < BLOCKS_WIDTH; x++) {
			for (int y = 0; y < BLOCKS_HEIGHT; y++) {
				blocks[x][y].render();
			}
		}
	}
	
}
