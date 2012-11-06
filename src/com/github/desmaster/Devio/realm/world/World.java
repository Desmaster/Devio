package com.github.desmaster.Devio.realm.world;

import static org.lwjgl.opengl.GL11.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.lwjgl.opengl.Display;

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
		worldtiles[1][1] = Tile.SAND;
		worldtiles[1][2] = Tile.STONE;
	}

	public Tile getTile(int x, int y) {
		return worldtiles[x][y];
	}

	public void setTile(int x, int y, Tile tile) {
		worldtiles[x][y] = tile;
	}

	public Tile[][] getSubArea(int x, int y, int width, int height) {
		Tile[][] SubArea = new Tile[width][height];

		for (int x2 = 0; x2 < width; x2++) {
			for (int y2 = 0; y2 < height; y2++) {
				SubArea[x2][y2] = worldtiles[x + x2][y + y2];
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
	
	public void saveWorld(String filename, Tile[][] output_veld) {
	     try {
	        FileOutputStream fos = new FileOutputStream(filename);
	        GZIPOutputStream gzos = new GZIPOutputStream(fos);
	        ObjectOutputStream out = new ObjectOutputStream(gzos);
	        out.writeObject(output_veld);
	        out.flush();
	        out.close();
	     }
	     catch (IOException e) {
	    	 e.printStackTrace();
	     }
	  }

	public Tile[][] loadWorld(String filename) {
	      try {
	        FileInputStream fis = new FileInputStream(filename);
	        GZIPInputStream gzis = new GZIPInputStream(fis);
	        ObjectInputStream in = new ObjectInputStream(gzis);
	        Tile[][] gelezen_veld = (Tile[][])in.readObject();
	        in.close();
	        return gelezen_veld;
	      }
	      catch (Exception e) {
	    	  e.printStackTrace();
	      }
	      return null;
	  }

}
