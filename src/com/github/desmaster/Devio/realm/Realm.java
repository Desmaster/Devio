package com.github.desmaster.Devio.realm;

import org.lwjgl.opengl.Display;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.realm.entity.Player;
import com.github.desmaster.Devio.realm.gameobject.Scenery;
import com.github.desmaster.Devio.realm.roofobject.Roof;
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
		roof = new Roof();
		Console.log("Initialized Roof");
	}

	public static World world = null;
	public static Scenery sc = null;
	public static Roof roof = null;

	public void render() {
		world.render();
		sc.render();
		roof.render();
	}

	public void tick() {

	}

	public void addPlayer(Player player) {
		this.player = player;
	}
}
