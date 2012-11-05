package com.github.desmaster.Devio.realm;

import static com.github.desmaster.Devio.realm.Level.BLOCK_SIZE;
import static com.github.desmaster.Devio.realm.Level.MAP_HEIGHT;
import static com.github.desmaster.Devio.realm.Level.MAP_WIDTH;
import static com.github.desmaster.Devio.realm.Level.WORLD_HEIGHT;
import static com.github.desmaster.Devio.realm.Level.WORLD_WIDTH;
import static com.github.desmaster.Devio.texture.iTexture.ID_GRASS;
import static com.github.desmaster.Devio.texture.iTexture.ID_SAND;
import static com.github.desmaster.Devio.texture.iTexture.objects;

import java.util.Random;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

public class World {

	Block[][] blocks = new Block[WORLD_WIDTH][WORLD_HEIGHT];
	Random random = new Random();

	public World() {
		for (int x = 0; x < WORLD_WIDTH; x++) {
			for (int y = 0; y < WORLD_HEIGHT; y++) {
				if (x >= 0 && x < 10 || x >= 11 && x < Display.getWidth() - 1) {
					blocks[x][y] = new Block(objects[random.nextInt(3)], x * BLOCK_SIZE,
							y * BLOCK_SIZE);
				} else {
					blocks[x][y] = new Block(objects[ID_SAND], x * BLOCK_SIZE,
							y * BLOCK_SIZE);
				}
			}
		}
		
	}

	public Block[][] generateWorld(int width, int height) {
		Block[][] blocks = new Block[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				blocks[x][y] = new Block(objects[ID_GRASS], x * BLOCK_SIZE, y
						* BLOCK_SIZE);
			}
		}
		return blocks;
	}

	public int random(int a, int b) {
		int dif = Math.abs(a - b);
		return Math.min(a, b) + (dif <= 0 ? 0 : new Random().nextInt(dif));

	}

	public void setAt(int x, int y, Texture b) {
		blocks[x][y] = new Block(b, x * BLOCK_SIZE, y * BLOCK_SIZE);
	}

	public Block getAt(int x, int y) {
		return blocks[x][y];
	}

	public void render() {
		for (int x = 0; x < MAP_WIDTH; x++) {
			for (int y = 0; y < MAP_HEIGHT; y++) {
				blocks[x][y].render();
			}
		}
	}

}
