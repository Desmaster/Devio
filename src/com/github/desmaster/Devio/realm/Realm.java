package com.github.desmaster.Devio.realm;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.realm.entity.MobHandler;
import com.github.desmaster.Devio.realm.entity.Player;
import com.github.desmaster.Devio.realm.gameobject.Scenery;
import com.github.desmaster.Devio.realm.roofobject.Roof;
import com.github.desmaster.Devio.realm.world.World;

public class Realm {

	public static final int BLOCK_SIZE = 32;
	public static final int MAP_WIDTH = Display.getWidth() / BLOCK_SIZE; // 25
	public static final int MAP_HEIGHT = Display.getHeight() / BLOCK_SIZE; // 20
	public static final int WORLD_WIDTH = 1024;
	public static final int WORLD_HEIGHT = 1024;

	public static Player player;
	public static World world = null;
	public static Scenery sc = null;
	public static MobHandler mobhandler = null;
	public static Roof roof = null;

	public Realm() {
		world = new World();
		Console.log("Generated World(" + WORLD_WIDTH + " * " + WORLD_HEIGHT+ ")");
		sc = new Scenery();
		Console.log("Generated Sceneries");
		mobhandler = new MobHandler();
		Console.log("Initialized Mob Handeler");
		roof = new Roof();
		Console.log("Initialized Roof");
	}

	public void render() {
		world.render();
		sc.render();
		mobhandler.render();
		roof.render();
	}

	public void tick() {
		mobhandler.tick();
	}

	public void addPlayer(Player player) {
		this.player = player;
	}
}
