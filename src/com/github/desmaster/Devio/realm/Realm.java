package com.github.desmaster.Devio.realm;

import org.lwjgl.opengl.Display;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.realm.entity.Player;

public class Realm {

	public static final int BLOCK_SIZE = 32;
	public static final int MAP_WIDTH = Display.getWidth() / BLOCK_SIZE;
	public static final int MAP_HEIGHT = Display.getHeight() / BLOCK_SIZE;
	public static final int WORLD_WIDTH = 800;
	public static final int WORLD_HEIGHT = 600;

	public Player player;

	public Realm() {
		world = new com.github.desmaster.Devio.realm.world.World();
		Console.log("Generated World(" + WORLD_WIDTH + " * " + WORLD_HEIGHT + ")");
		sc = new Scenery();
		Console.log("Generated Sceneries");
	}

	private com.github.desmaster.Devio.realm.world.World world = null;
	private Scenery sc = null;

	public void render() {
		world.render();
		//sc.render();
	}

	public void tick() {
		
	}

	public void addPlayer(Player player) {
		this.player = player; 
	}

}