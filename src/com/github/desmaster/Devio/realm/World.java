package com.github.desmaster.Devio.realm;

import static com.github.desmaster.Devio.realm.Level.*;
import static com.github.desmaster.Devio.gfx.Screen.*;

import java.util.Random;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import com.github.desmaster.Devio.cons.Console;

import static com.github.desmaster.Devio.texture.iTexture.*;

public class World extends Level {

	Block[][] blocks;
	Random random = new Random(64);

	public World() {
		super();
		blocks = generateWorld(WORLD_WIDTH, WORLD_HEIGHT);
		for (int x = 0; x < WORLD_WIDTH; x++) {
			for (int y = 0; y < WORLD_HEIGHT; y++) {
				blocks[x][y] = new Block(objects[ID_GRASS], x * BLOCK_SIZE, y * BLOCK_SIZE);
			}
		}

	}

	public Block[][] generateWorld(int width, int height) {
		Block[][] blocks = new Block[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				blocks[x][y] = new Block(objects[ID_GRASS], x * BLOCK_SIZE, y * BLOCK_SIZE);
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
		int width = pX + 10;
		Console.log("pX: " + pX);
		for (int x = (pX - 8); x < width; x++) {
			for (int y = 0; y < WORLD_HEIGHT; y++) {
				blocks[x][y].render();
			}
		}
	}

}
