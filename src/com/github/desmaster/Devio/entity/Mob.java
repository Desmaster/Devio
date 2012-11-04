package com.github.desmaster.Devio.entity;

public class Mob extends Entity {
	
	double lives;
	
	public Mob(int x, int y, double lives) {
		super(x, y);
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
