package com.github.desmaster.Devio.realm.entity;

public class Mob extends Entity {
	
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
	
}
