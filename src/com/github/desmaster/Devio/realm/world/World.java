package com.github.desmaster.Devio.realm.world;

import org.lwjgl.opengl.Display;

import com.github.desmaster.Devio.realm.entity.Player;

public class World {

	public final int BLOCK_SIZE = 32;
	public final int MAP_WIDTH = Display.getWidth() / BLOCK_SIZE;
	public final int MAP_HEIGHT = Display.getHeight() / BLOCK_SIZE;
	public final int WORLD_WIDTH = 1024;
	public final int WORLD_HEIGHT = 1024;
	
	Tile[][] worldtiles = new Tile[WORLD_WIDTH][WORLD_HEIGHT];
	
	public World() {
		for (int x = 0; x < WORLD_WIDTH; x++) {
			for (int y = 0; y < WORLD_HEIGHT; y++) {
				worldtiles[x][y] = Tile.GRASS;
			}
		}
		
	}
	
	public Tile getTile(int x,int y)
	{
		return worldtiles[x][y];
	}
	public void setTile(int x,int y,Tile tile)
	{
		worldtiles[x][y] = tile;
	}
	
	public Tile[][] getSubArea(int x,int y,int width,int height)
	{
		Tile[][] SubArea = new Tile[width][height];
		
		for (int x2 = 0;x2 < width; x2++)
		{
			for (int y2 = 0;y2 < height; y2++)
			{
				SubArea[x2][y2] = worldtiles[x+x2][y+y2];
			}
		}
		return SubArea;
	}

	public Tile[][] getVisibleMap(Player player)
	{
		//TODO stukje map die je kunt zien
		return getSubArea()
	}
}

