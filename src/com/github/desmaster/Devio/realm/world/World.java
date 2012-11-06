package com.github.desmaster.Devio.realm.world;

import static org.lwjgl.opengl.GL11.*;

import com.github.desmaster.Devio.gfx.Screen;
import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.realm.entity.Player;
import com.github.desmaster.Devio.util.Position;

public class World {

	Tile[][] worldtiles = new Tile[Realm.WORLD_WIDTH][Realm.WORLD_HEIGHT];

	public World() {
		for (int x = 0; x < Realm.WORLD_WIDTH; x++) {
			for (int y = 0; y < Realm.WORLD_HEIGHT; y++) {
				worldtiles[x][y] = Tile.GRASS;
			}
		}
		worldtiles[1][1] = Tile.STONE;
		worldtiles[1][2] = Tile.STONE;
		worldtiles[1][3] = Tile.STONE;
		
		worldtiles[2][1] = Tile.STONE;
		worldtiles[2][2] = Tile.MOSSY_STONE;
		worldtiles[2][3] = Tile.STONE;
		
		worldtiles[3][1] = Tile.STONE;
		worldtiles[3][2] = Tile.STONE;
		worldtiles[3][3] = Tile.STONE;
	}

	public Tile getTile(int x, int y) {
		return worldtiles[x][y];
	}

	public void setTile(int x, int y, Tile tile) {
		worldtiles[x][y] = tile;
	}

	public Tile[][] getSubArea(int x, int y, int width, int height) {
		Tile[][] SubArea = new Tile[width][height];

		for (int xx = 0; xx < width; xx++) {
			for (int yy = 0; yy < height; yy++) {
				SubArea[xx][yy] = worldtiles[x + xx][y + yy];
			}
		}
		
		return SubArea;
	}

	public Tile[][] getVisibleMap(Player player) {
		
		Position offset = getVisibleMapOffsetPosition(player);
		
		return getSubArea(offset.getX(),offset.getY(),Realm.MAP_WIDTH,Realm.MAP_HEIGHT);
	}
	
	public Position getVisibleMapOffsetPosition(Player player) {
		
		int offsetXTile = player.x  - (int) Math.ceil(Realm.MAP_WIDTH/2);
		int offsetYTile = player.y  - (int) Math.ceil(Realm.MAP_HEIGHT/2);
		
		if (offsetXTile < 0) offsetXTile = 0;
		if (offsetYTile < 0) offsetYTile = 0;
		
		if (offsetXTile > Realm.WORLD_WIDTH - Realm.MAP_WIDTH) offsetXTile = Realm.WORLD_WIDTH - Realm.MAP_WIDTH;
		if (offsetYTile > Realm.WORLD_HEIGHT - Realm.MAP_HEIGHT) offsetYTile = Realm.WORLD_HEIGHT - Realm.MAP_HEIGHT;
		
		return new Position(offsetXTile,offsetYTile);
	}

	public void render() {
		Tile[][] SubArea = getVisibleMap(Screen.getPlayer());
		for(int x = 0; x < SubArea.length; x++) {
			for (int y = 0; y < SubArea[0].length; y++) {
				renderTile(x, y, SubArea[x][y]);
			}
		}
	}
	
	public void renderTile(int x, int y, Tile tile) {
		tile.getTexture().bind();
		x *= Realm.BLOCK_SIZE / 2;
		y *= Realm.BLOCK_SIZE / 2;
		int width = Realm.BLOCK_SIZE;
		int height = Realm.BLOCK_SIZE;
		glLoadIdentity();
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(x, y);
			glTexCoord2f(1, 0);
			glVertex2f(x + width, y);
			glTexCoord2f(1, 1);
			glVertex2f(x + width, y + height);
			glTexCoord2f(0, 1);
			glVertex2f(x, y + height);
		glEnd();
		glLoadIdentity();
	}
	
	public Tile[][] saveWorld() {
	     return worldtiles;
	}

	public void loadWorld(Tile[][] tiles) {
	      worldtiles = tiles;
	  }

}
