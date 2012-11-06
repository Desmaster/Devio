package com.github.desmaster.Devio.realm.world;

import org.newdawn.slick.opengl.Texture;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.tex.iTexture;

public enum Tile {
	GRASS("Grass", false, true, iTexture.ID_GRASS), 					// 0
	SAND("Sand", false, true, iTexture.ID_SAND), 						// 1
	STONE("Stone", false, true, iTexture.ID_STONE), 					// 2
	COBBLE_STONE("Cobblestone", false, true, iTexture.ID_COBBLESTONE), 		// 3
	MOSSY_STONE("Mossy_Cobblestone", false, true, iTexture.ID_MOSS_STONE), 	// 4
	WATER("Water", false, true, iTexture.ID_WATER); 					// 5
	//LAVA("Lava", false, true, 6) 						// 6

	private String name;
	private boolean breakable;
	private boolean solid;
	private int TextureID;
	
	public int x;
	public int y;

	Tile(String name, boolean breakable, boolean solid,int TextureID) {
		Console.log("Initialized Tile: " + name);
		this.name = name;
		this.breakable = breakable;
		this.solid = solid;
		this.TextureID = TextureID;
	}

	public int getID() {
		return this.ordinal();
	}

	public String getName() {
		return name;
	}

	public boolean isBreakable() {
		return breakable;
	}

	public boolean isSolid() {
		return solid;
	}

	public Texture getTexture() {
		return iTexture.textures[TextureID];
	}
	public int getTextureID() {
		return TextureID;
	}
	public void setTextureID(int TextureID) {
		this.TextureID = TextureID;
	}

}
