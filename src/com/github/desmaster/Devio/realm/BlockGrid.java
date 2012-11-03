package com.github.desmaster.Devio.realm;

import static com.github.desmaster.Devio.realm.Level.*;

import java.util.Random;

import org.newdawn.slick.opengl.Texture;

import static com.github.desmaster.Devio.texture.iTexture.*;

public class BlockGrid {
	
	public Block[][] blocks = new Block[BLOCKS_WIDTH][BLOCKS_HEIGHT];
	Random random = new Random(64);
	
	public BlockGrid() {
		
		for (int x = 0; x < BLOCKS_WIDTH; x++) {
			for (int y = 0; y < BLOCKS_HEIGHT; y++) {
				//int seed = random.nextInt(objects.length);
				blocks[x][y] = new Block(objects[ID_GRASS], x * BLOCK_SIZE, y * BLOCK_SIZE);
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
