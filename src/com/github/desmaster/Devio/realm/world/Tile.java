package com.github.desmaster.Devio.realm.world;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import com.github.desmaster.Devio.cons.Console;

public enum Tile {
	GRASS("Grass",false,true), 						// 0
	SAND("Sand",false,true),						// 1
	STONE("Stone",false,true),						// 2
	COBBLE_STONE("Cobblestone",false,true),			// 3
	MOSSY_STONE("Mossy_cobblestone",false,true),	// 4
	WATER("Water",false,true),						// 5
	LAVA("Lava",false,true),						// 6
	FLOWER_RED("Red_flower",false,true),			// 7
	FLOWER_YELLOW("Yellow_flower",false,true),		// 8
	FLOWER_BLUE("Blue_flower",false,true);			// 9
	
	private String name;
	private boolean breakable;
	private boolean solid;
	private Texture texture;
	
	Tile(String name,boolean breakable,boolean solid) {
		this.name = name;
        this.breakable = breakable;
        this.solid = solid;
        this.texture = loadTexture(name,".png");
    }	
	private Texture loadTexture(String name, String ext) {
		try {
			Texture t1 = TextureLoader.getTexture(
					ext.toUpperCase(),
					getClass().getResourceAsStream("/img/" + name + "."
							+ ext));
			Console.log("Loaded " + name + "." + ext);
			return t1;
		} catch (IOException e) {
			Console.log(e.getMessage());
		}
		return null;
	}
	
	public int getID()
	{
		return this.ordinal();		
	}
	
	public String getName()
	{
		return name;		
	}
	
	public boolean isBreakable()
	{
		return breakable;		
	}
	
	public boolean isSolid()
	{
		return solid;		
	}	
	
	public Texture getTexture()
	{
		return texture;		
	}
}
