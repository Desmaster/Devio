package com.github.desmaster.Devio.realm.gameobject;

import java.util.Random;

import static org.lwjgl.opengl.GL11.*;

import com.github.desmaster.Devio.gfx.Screen;
import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.realm.World_Old;
import com.github.desmaster.Devio.realm.entity.Player;
import com.github.desmaster.Devio.util.Position;

public class Scenery extends World_Old {

	GameObject[][] scenobjects = new GameObject[Realm.WORLD_WIDTH][Realm.WORLD_HEIGHT];

	public Scenery() {
		Random random = new Random();
		for (int x = 0; x < Realm.WORLD_WIDTH; x++) {
			for (int y = 0; y < Realm.WORLD_HEIGHT; y++) {
				int seed = random.nextInt(2);
				if (seed == 0) {
					scenobjects[x][y] = GameObject.RED_FLOWER;
				} else {
					scenobjects[x][y] = GameObject.YELLOW_FLOWER;
				}
			}
		}
	}
	
	public GameObject getObject(int x, int y) {
		return scenobjects[x][y];
	}

	public void setObject(int x, int y, GameObject object) {
		scenobjects[x][y] = object;
	}

	public GameObject[][] getSubArea(int x, int y, int width, int height) {
		GameObject[][] SubArea = new GameObject[width][height];

		for (int x2 = 0; x2 < width; x2++) {
			for (int y2 = 0; y2 < height; y2++) {
				SubArea[x2][y2] = scenobjects[x + x2][y + y2];
			}
		}
		
		return SubArea;
	}

	public GameObject[][] getVisibleMap(Player player) {
		
		Position offset = getVisibleMapOffsetPosition(player);
		
		return getSubArea(offset.getX(),offset.getY(),Realm.MAP_WIDTH,Realm.MAP_HEIGHT);
	}
	
	public Position getVisibleMapOffsetPosition(Player player) {
		
		int offsetXObject = player.x  - (int) Math.ceil(Realm.MAP_WIDTH/2);
		int offsetYObject = player.y  - (int) Math.ceil(Realm.MAP_HEIGHT/2);
		
		if (offsetXObject < 0) offsetXObject = 0;
		if (offsetYObject < 0) offsetYObject = 0;
		
		if (offsetXObject > Realm.WORLD_WIDTH - Realm.MAP_WIDTH) offsetXObject = Realm.WORLD_WIDTH - Realm.MAP_WIDTH;
		if (offsetYObject > Realm.WORLD_HEIGHT - Realm.MAP_HEIGHT) offsetYObject = Realm.WORLD_HEIGHT - Realm.MAP_HEIGHT;
		
		return new Position(offsetXObject,offsetYObject);
	}
	
	public void render() {
		GameObject[][] SubArea = getVisibleMap(Screen.getPlayer());
		for (int x = 0; x < SubArea.length; x++) {
			for (int y = 0; y < SubArea[0].length; x++) {
				renderObject(x, y, SubArea[x][y]);
			}
		}
	}
	
	public void renderObject(int x, int y, GameObject object) {
		object.getTexture().bind();
		x *= Realm.BLOCK_SIZE;
		y *= Realm.BLOCK_SIZE;
		int width = Realm.BLOCK_SIZE / 2;
		int height = Realm.BLOCK_SIZE / 2;
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
	
}
