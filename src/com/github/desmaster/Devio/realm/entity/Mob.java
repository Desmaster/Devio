package com.github.desmaster.Devio.realm.entity;

import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.util.Position;

public class Mob extends Entity {

	private int walkspeed = 1;
	double lives;
	
	public Mob(com.github.desmaster.Devio.util.Position spawnPosition, double lives) {
		super(spawnPosition);
		this.lives = lives;
	}
	
	public void tick() {
		
	}

	public double getLives() {
		return lives;
	}

	public void setLives(double lives) {
		this.lives = lives;
	}
	
	public void walkUp() {
		face = 0;
		if (!(y == 0))
			if (!Realm.checkCollision(new Position(x,y),face))
				y -= walkspeed;
	}

	public void walkDown() {
		face = 2;
		if (!(y == Realm.WORLD_HEIGHT))
			if (!Realm.checkCollision(new Position(x,y),face))
				y += walkspeed;
	}

	public void walkLeft() {
		face = 3;
		if (!(x == 0))
			if (!Realm.checkCollision(new Position(x,y),face))
				x -= walkspeed;
	}

	public void walkRight() {
		face = 1;
		if (!(x == Realm.WORLD_WIDTH))
			if (!Realm.checkCollision(new Position(x,y),face))
				x += walkspeed;
	}
}
