package com.github.desmaster.Devio.realm.roofobject;

import org.newdawn.slick.opengl.Texture;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.tex.iTexture;

public enum RoofObject {
	
	GRASS("Grass", false, new boolean[] {false, false, false, false}, iTexture.ID_GRASS),
	SAND("Sand", false, new boolean[] {false, false, false, false}, iTexture.ID_SAND),
	STONE("Stone", false, new boolean[] {false, false, false, false}, iTexture.ID_STONE),
	COBBLE_STONE("Cobblestone", false, new boolean[] {false, false, false, false}, iTexture.ID_COBBLESTONE),
	MOSSY_STONE("Mossy_Cobblestone", false, new boolean[] {false, false, false, false}, iTexture.ID_MOSS_STONE);

	private String name;
	private boolean breakable;
	private boolean[] solid = new boolean[4];
	private int TextureID;
	
	public int x;
	public int y;

	RoofObject(String name, boolean breakable, boolean[] test, int TextureID) {
		Console.log("Initialized RoofObject: " + name);
		this.name = name;
		this.breakable = breakable;
		this.solid = test;
		this.TextureID = TextureID;
	}

	public int getID() {
		return this.ordinal();
	}
	
	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return name.replaceAll("_", " ");
	}

	public boolean isBreakable() {
		return breakable;
	}

	public boolean checkCollision(int face) {
		return solid[face];
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
