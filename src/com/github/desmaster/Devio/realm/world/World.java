package com.github.desmaster.Devio.realm.world;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.util.List;

import com.github.desmaster.Devio.gfx.Screen;
import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.realm.entity.Player;
import com.github.desmaster.Devio.util.Position;

public class World {

	Tile[][] worldTiles = new Tile[Realm.WORLD_WIDTH][Realm.WORLD_HEIGHT];
	private List data;

	public World() {
		for (int x = 0; x < Realm.WORLD_WIDTH; x++) {
			for (int y = 0; y < Realm.WORLD_HEIGHT; y++) {
				worldTiles[x][y] = Tile.GRASS;
			}
		}
		worldTiles[1][1] = Tile.STONE;
		worldTiles[1][2] = Tile.STONE;
		worldTiles[1][3] = Tile.STONE;

		worldTiles[2][1] = Tile.STONE;
		worldTiles[2][2] = Tile.MOSSY_STONE;
		worldTiles[2][3] = Tile.STONE;

		worldTiles[3][1] = Tile.STONE;
		worldTiles[3][2] = Tile.STONE;
		worldTiles[3][3] = Tile.STONE;
		
		worldTiles[6][1] = Tile.SAND;
		worldTiles[6][2] = Tile.SAND;
		worldTiles[6][3] = Tile.SAND;
		worldTiles[6][4] = Tile.SAND;
		worldTiles[6][5] = Tile.SAND;
		worldTiles[7][1] = Tile.SAND;
		worldTiles[7][2] = Tile.SAND;
		worldTiles[7][3] = Tile.SAND;
		worldTiles[7][4] = Tile.SAND;
		worldTiles[7][5] = Tile.SAND;
		worldTiles[8][1] = Tile.SAND;
		worldTiles[8][2] = Tile.SAND;
		worldTiles[8][3] = Tile.SAND;
		worldTiles[8][4] = Tile.SAND;
		worldTiles[8][5] = Tile.SAND;
		worldTiles[9][1] = Tile.SAND;
		worldTiles[9][2] = Tile.SAND;
		worldTiles[9][3] = Tile.SAND;
		worldTiles[9][4] = Tile.SAND;
		worldTiles[9][5] = Tile.SAND;
		worldTiles[10][1] = Tile.SAND;
		worldTiles[10][2] = Tile.SAND;
		worldTiles[10][3] = Tile.SAND;
		worldTiles[10][4] = Tile.SAND;
		worldTiles[10][5] = Tile.SAND;
	}

	public Tile getTile(int x, int y) {
		return worldTiles[x][y];
	}

	public void setTile(int x, int y, Tile tile) {
		worldTiles[x][y] = tile;
	}

	public Tile[][] getSubArea(int x, int y, int width, int height) {
		Tile[][] SubArea = new Tile[width][height];

		for (int xx = 0; xx < width; xx++) {
			for (int yy = 0; yy < height; yy++) {
				SubArea[xx][yy] = worldTiles[x + xx][y + yy];
			}
		}

		return SubArea;
	}

	public Tile[][] getVisibleMap(Player player) {

		Position offset = getVisibleMapOffsetPosition(player);
		
		return getSubArea(offset.getX(), offset.getY(), Realm.MAP_WIDTH, Realm.MAP_HEIGHT);
	}

	public Position getVisibleMapOffsetPosition(Player player) {

		int offsetXTile = player.x - (int) Math.ceil(Realm.MAP_WIDTH / 2);
		int offsetYTile = player.y - (int) Math.ceil(Realm.MAP_HEIGHT / 2);

		if (offsetXTile < 0)
			offsetXTile = 0;
		if (offsetYTile < 0)
			offsetYTile = 0;

		if (offsetXTile > Realm.WORLD_WIDTH - Realm.MAP_WIDTH)
			offsetXTile = Realm.WORLD_WIDTH - Realm.MAP_WIDTH;
		if (offsetYTile > Realm.WORLD_HEIGHT - Realm.MAP_HEIGHT)
			offsetYTile = Realm.WORLD_HEIGHT - Realm.MAP_HEIGHT;

		return new Position(offsetXTile, offsetYTile);
	}

	public void render() {
		Tile[][] SubArea = getVisibleMap(Screen.getPlayer());
		for (int x = 0; x < SubArea.length; x++) {
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
	
	public Tile[][] getMap() {
		return worldTiles;
	}
	
	public void setMap(Tile[][] tiles) {
		worldTiles = tiles;
	}

	public Tile[][] saveWorld() {
		return worldTiles;
	}

	public void loadWorld(Tile[][] tiles) {
		worldTiles = tiles;
	}
	
	public List getData() {
		return this.data;
	}

	public void setData(List data) {
		this.data = data;
	}

}
