package com.github.desmaster.Devio.realm.entity;

public class Mob extends Entity {
	
	double lives;
	int face = 0; // Up = 0 Right = 1 Down = 2 Left = 3
	
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
	
}
