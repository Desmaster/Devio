package com.github.desmaster.Devio.realm;

import org.lwjgl.opengl.Display;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.entity.Player;

public class Level {

	public static final int BLOCK_SIZE = 32;
	public static final int MAP_WIDTH = 0;
	public static final int MAP_HEIGHT = 0;
	public static final int WORLD_WIDTH = Display.getWidth() / BLOCK_SIZE;
	public static final int WORLD_HEIGHT = Display.getHeight() / BLOCK_SIZE;

	public Player player;
	
	public Level() {
		
	}
	
	int pX = 0;
	int pY;

	public void render() {
		World bg = new World();
		Scenery sc = new Scenery();
		bg.render(); 
		sc.render();
	}
	
	public void tick() {
		pX = player.getX();
		Console.log("pX initialized! " + pX);
		pY = player.y;
	}
	
	public void addPlayer(Player player) {
		this.player = player;
	}

}
