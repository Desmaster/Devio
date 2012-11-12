package com.github.desmaster.Devio.realm.gameobject;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.util.Random;

import com.github.desmaster.Devio.gfx.Screen;
import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.realm.entity.Player;
import com.github.desmaster.Devio.realm.world.Tile;
import com.github.desmaster.Devio.util.Position;
import com.github.desmaster.Devio.util.iRandom;

public class Scenery {

	GameObject[][] scenobjects = new GameObject[Realm.WORLD_WIDTH][Realm.WORLD_HEIGHT];

	public Scenery() {

		for (int x = 0; x < Realm.WORLD_WIDTH; x++) {
			for (int y = 0; y < Realm.WORLD_HEIGHT; y++) {
				if (Realm.world.getTile(x, y) == Tile.GRASS) {
					int seed = iRandom.nextInt(30);
					if (seed < 3) {
						if (seed == 0)
							scenobjects[x][y] = GameObject.RED_FLOWER;
						else if (seed == 1)
							scenobjects[x][y] = GameObject.YELLOW_FLOWER;
						else if (seed == 2)
							scenobjects[x][y] = GameObject.GRASS_NOISE;
					}
				}
			}
		}

		scenobjects[7][1] = GameObject.BRICK_WALL_0;
		scenobjects[7][5] = GameObject.BRICK_WALL_2;
		scenobjects[8][1] = GameObject.BRICK_WALL_0;
		scenobjects[9][1] = GameObject.BRICK_WALL_0;
		scenobjects[9][5] = GameObject.BRICK_WALL_2;
		scenobjects[10][1] = GameObject.BRICK_WALL; //corner
		scenobjects[10][2] = GameObject.BRICK_WALL_1;
		scenobjects[10][3] = GameObject.BRICK_WALL_1;
		scenobjects[10][4] = GameObject.BRICK_WALL_1;
		scenobjects[10][5] = GameObject.BRICK_WALL; //Corner
		scenobjects[6][1] = GameObject.BRICK_WALL; //corner
		scenobjects[6][2] = GameObject.BRICK_WALL_3;
		scenobjects[6][3] = GameObject.BRICK_WALL_3;
		scenobjects[6][4] = GameObject.BRICK_WALL_3;
		scenobjects[6][5] = GameObject.BRICK_WALL; //corner
	}

	public GameObject getObject(int x, int y) {
		if (x >= Realm.WORLD_WIDTH || y >= Realm.WORLD_HEIGHT || x < 0 || y < 0){
			return null;
		}
		return scenobjects[x][y];
	}

	public void setObject(int x, int y, GameObject object) {
		scenobjects[x][y] = object;
	}

	public GameObject[][] getSubArea(int x, int y, int width, int height) {
		GameObject[][] SubArea = new GameObject[width][height];
		for (int xx = 0; xx < width; xx++) {
			for (int yy = 0; yy < height; yy++) {
				SubArea[xx][yy] = scenobjects[x + xx][y + yy];
			}
		}
		return SubArea;
	}

	public GameObject[][] getVisibleMap(Player player) {

		Position offset = getVisibleMapOffsetPosition(player);

		return getSubArea(offset.getX(), offset.getY(), Realm.MAP_WIDTH, Realm.MAP_HEIGHT);
	}

	public Position getVisibleMapOffsetPosition(Player player) {

		int offsetXObject = player.x - (int) Math.ceil(Realm.MAP_WIDTH / 2);
		int offsetYObject = player.y - (int) Math.ceil(Realm.MAP_HEIGHT / 2);

		if (offsetXObject < 0)
			offsetXObject = 0;
		if (offsetYObject < 0)
			offsetYObject = 0;

		if (offsetXObject > Realm.WORLD_WIDTH - Realm.MAP_WIDTH)
			offsetXObject = Realm.WORLD_WIDTH - Realm.MAP_WIDTH;
		if (offsetYObject > Realm.WORLD_HEIGHT - Realm.MAP_HEIGHT)
			offsetYObject = Realm.WORLD_HEIGHT - Realm.MAP_HEIGHT;

		return new Position(offsetXObject, offsetYObject);
	}

	public void render() {
		GameObject[][] SubArea = getVisibleMap(Screen.getPlayer());
		for (int x = 0; x < SubArea.length; x++) {
			for (int y = 0; y < SubArea[0].length; y++) {
				if (!(SubArea[x][y] == null))
					renderObject(x, y, SubArea[x][y]);
			}
		}
	}

	public void renderObject(int x, int y, GameObject object) {
		object.getTexture().bind();
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

		//Console.log("Rendered: " + x + ", y: " + y + " At: " +
		//object.getDisplayName());
	}

}
