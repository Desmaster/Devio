package com.github.desmaster.Devio.realm;

import org.lwjgl.opengl.Display;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.realm.entity.Player;
import com.github.desmaster.Devio.realm.gameobject.Scenery;
import com.github.desmaster.Devio.realm.world.World;
import com.github.desmaster.Devio.util.Position;

public class Realm {
	public static final int BLOCK_SIZE = 32;
	public static final int MAP_WIDTH = Display.getWidth() / BLOCK_SIZE;
	public static final int MAP_HEIGHT = Display.getHeight() / BLOCK_SIZE;
	public static final int WORLD_WIDTH = 1024;
	public static final int WORLD_HEIGHT = 1024;

	public Player player;

	public Realm() {
		world = new World();
		Console.log("Generated World(" + WORLD_WIDTH + " * " + WORLD_HEIGHT + ")");
		sc = new Scenery();
		Console.log("Generated Sceneries");
	}

	public static World world = null;
	public static Scenery sc = null;

	public void render() {
		world.render();
		sc.render();
	}

	public void tick() {

	}

	public void addPlayer(Player player) {
		this.player = player;
	}

	public static boolean checkCollision(Position p, int face) {
		boolean solid = false;

		if (face == 0) { // UP
			if (world.getTile(p.getX(), p.getY()).checkCollision(0))
				solid = true;
			if (world.getTile(p.getX(), p.getY() - 1).checkCollision(2))
				solid = true;
			if (!(sc.getObject(p.getX(), p.getY()) == null)) {
				if (sc.getObject(p.getX(), p.getY()).checkCollision(0))
					solid = true;
			}
			if (!(sc.getObject(p.getX(), p.getY() - 1) == null)) {
				if (sc.getObject(p.getX(), p.getY() - 1).checkCollision(2))
					solid = true;
			}
		}

		if (face == 1) { // Right
			if (world.getTile(p.getX(), p.getY()).checkCollision(1))
				solid = true;
			if (world.getTile(p.getX() + 1, p.getY()).checkCollision(3))
				solid = true;
			if (!(sc.getObject(p.getX(), p.getY()) == null)) {
				if (sc.getObject(p.getX(), p.getY()).checkCollision(1))
					solid = true;
			}
			if (!(sc.getObject(p.getX() + 1, p.getY()) == null)) {
				if (sc.getObject(p.getX() + 1, p.getY()).checkCollision(3))
					solid = true;
			}

		}

		if (face == 2) { // Down
			if (world.getTile(p.getX(), p.getY()).checkCollision(2))
				solid = true;
			if (world.getTile(p.getX(), p.getY() + 1).checkCollision(0))
				solid = true;
			if (!(sc.getObject(p.getX(), p.getY()) == null)) {
				if (sc.getObject(p.getX(), p.getY()).checkCollision(2))
					solid = true;
			}
			if (!(sc.getObject(p.getX(), p.getY() + 1) == null)) {
				if (sc.getObject(p.getX(), p.getY() + 1).checkCollision(0))
					solid = true;
			}
		}

		if (face == 3) { // Right
			if (world.getTile(p.getX(), p.getY()).checkCollision(3))
				solid = true;
			if (world.getTile(p.getX() - 1, p.getY()).checkCollision(1))
				solid = true;
			if (!(sc.getObject(p.getX(), p.getY()) == null)) {
				if (sc.getObject(p.getX(), p.getY()).checkCollision(3))
					solid = true;
			}
			if (!(sc.getObject(p.getX() - 1, p.getY()) == null)) {
				if (sc.getObject(p.getX() - 1, p.getY()).checkCollision(1))
					solid = true;
			}
		}
		return solid;
	}
}
