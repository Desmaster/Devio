package com.github.desmaster.Devio.realm.gameobject;

import org.newdawn.slick.opengl.Texture;
import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.tex.iTexture;

public enum GameObject {
	
	RED_FLOWER("Red_Flower", true, false, false, false, false, iTexture.ID_FLOWER_RED),
	YELLOW_FLOWER("Yellow_Flower", true, false, false, false, false, iTexture.ID_FLOWER_YELLOW),
	BRICK_WALL("Brick_wall",false, true, true, true, true,iTexture.ID_BRICK_WALL);
	
	private String name;
	private boolean breakable;
	private boolean[] solid = new boolean[4];
	private int TextureID;
	
	public int x;
	public int y;

	GameObject(String name, boolean breakable, boolean north_solid, boolean east_solid, boolean south_solid, boolean west_solid,int TextureID) {
		Console.log("Initialized GameObject: " + name);
		this.name = name;
		this.breakable = breakable;
		this.solid = new boolean[]{north_solid, east_solid, south_solid, west_solid};
		this.TextureID = TextureID;
	}

	public int getID() {
		return this.ordinal();
	}

	public String getName() {
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
