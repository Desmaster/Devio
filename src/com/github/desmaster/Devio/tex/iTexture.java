package com.github.desmaster.Devio.tex;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import com.github.desmaster.Devio.cons.Console;

public class iTexture {

	public static final int ID_GRASS = 0;
	public static final int ID_SAND = 1;
	public static final int ID_WATER = 2;

	public static final int ID_FLOWER_RED = 21;
	public static final int ID_FLOWER_YELLOW = 22;

	public static final int ID_MOSS_STONE = 53;
	public static final int ID_STONE = 51;
	public static final int ID_COBBLESTONE = 52;
	
	public static final int ID_BRICK_WALL = 61;

	public static Texture TEST_TEXTURE = null;
	public static Texture[] textures = new Texture[255];
	public static Texture PLAYER = null;
	public static Texture PLAYER_NINJA = null;
	public static Texture PLAYER_BILLIE = null;

	public iTexture() {
		PLAYER = getTexture("player", "png");
		PLAYER_NINJA = getTexture("ninja", "png");
		PLAYER_BILLIE = getTexture("billie", "png");

		for (int i = 0; i < textures.length; i++) {
			switch (i) {
			case ID_GRASS:
				textures[i] = getTexture("grass", "png");
				break;
			case ID_SAND:
				textures[i] = getTexture("sand", "png");
				break;
			case ID_MOSS_STONE:
				textures[i] = getTexture("mossy_cobblestone", "png");
				break;
			case ID_WATER:
				textures[i] = getTexture("water", "png");
				break;
			case ID_FLOWER_RED:
				textures[i] = getTexture("red_flower", "png");
				break;
			case ID_FLOWER_YELLOW:
				textures[i] = getTexture("yellow_flower", "png");
				break;
			case ID_STONE:
				textures[i] = getTexture("stone", "png");
				break;
			case ID_COBBLESTONE:
				textures[i] = getTexture("cobblestone", "png");
				break;
			case ID_BRICK_WALL:
				textures[i] = getTexture("brickwall", "png");
				break;
			}
		}

	}

	public static Texture getTexture(String name, String ext) {
		try {
			Texture t1 = TextureLoader.getTexture(ext.toUpperCase(), iTexture.class.getResourceAsStream("/img/" + name + "." + ext));
			Console.log("Loaded " + name + "." + ext);
			return t1;
		} catch (IOException e) {
			Console.log(e.getMessage());
		}
		return null;
	}

}
