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

	public static Texture TEST_TEXTURE = null;
	public static Texture[] objects = new Texture[55];
	public static Texture PLAYER = null;
	public static Texture PLAYER_NINJA = null;
	public static Texture PLAYER_BILLIE = null;

	public iTexture() {
		PLAYER = getTexture("player", "png");
		PLAYER_NINJA = getTexture("ninja", "png");
		PLAYER_BILLIE = getTexture("billie", "png");

		for (int i = 0; i < objects.length; i++) {
			switch (i) {
			case ID_GRASS:
				objects[i] = getTexture("grass", "png");
				break;
			case ID_SAND:
				objects[i] = getTexture("sand", "png");
				break;
			case ID_MOSS_STONE:
				objects[i] = getTexture("moss_stone", "png");
				break;
			case ID_WATER:
				objects[i] = getTexture("water", "png");
				break;
			case ID_FLOWER_RED:
				objects[i] = getTexture("flower_red", "png");
				break;
			case ID_FLOWER_YELLOW:
				objects[i] = getTexture("flower_yellow", "png");
				break;
			case ID_STONE:
				objects[i] = getTexture("stone", "png");
				break;
			case ID_COBBLESTONE:
				objects[i] = getTexture("cobblestone", "png");
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
