package com.github.desmaster.Devio.realm.gameobject;

import org.newdawn.slick.opengl.Texture;
import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.tex.iTexture;

public enum GameObject {
	
	RED_FLOWER("Red_Flower", true, false, iTexture.ID_FLOWER_RED),
	YELLOW_FLOWER("Yellow_Flower", true, false, iTexture.ID_FLOWER_YELLOW),
	BRICK_WALL("Brick_wall",false,true,iTexture.ID_BRICK_WALL);
	
	private String name;
	private boolean breakable;
	private boolean solid;
	private int TextureID;
	
	public int x;
	public int y;

	GameObject(String name, boolean breakable, boolean solid,int TextureID) {
		Console.log("Initialized GameObject: " + name);
		this.name = name;
		this.breakable = breakable;
		this.solid = solid;
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
