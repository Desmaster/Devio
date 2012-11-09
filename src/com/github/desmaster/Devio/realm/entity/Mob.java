package com.github.desmaster.Devio.realm.entity;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.util.Position;

public class Mob extends Entity {

	private int walkspeed = 1;
	private int walkblocktick = 60;
	double lives;
	
	
	private int walkblocktimeout = 0;
	private boolean walkblockactive = false;
	
	public Mob(com.github.desmaster.Devio.util.Position spawnPosition, double lives) {
		super(spawnPosition);
		this.lives = lives;
	}
	
	public void tick() {
		walkblock();
	}

	public void walkblock(){
		if (walkblocktimeout <= 0){
			walkblockactive = false;
		} else {
			walkblocktimeout -= 1;
		}
	}
	public double getLives() {
		return lives;
	}

	public void setLives(double lives) {
		this.lives = lives;
	}
	
	public void walkUp() {
		face = 0;
		if (!(y == 0) && !walkblockactive)
			if (!Realm.checkCollision(new Position(x,y),face)){
				y -= walkspeed;
				walkblockactive = true;
				walkblocktimeout = walkblocktick;
			}
	}

	public void walkDown() {
		face = 2;
		Console.log(walkblockactive + "");
		if (!(y == Realm.WORLD_HEIGHT) && !walkblockactive)
			if (!Realm.checkCollision(new Position(x,y),face)){
				y += walkspeed;
				walkblockactive = true;
				walkblocktimeout = walkblocktick;
			}
	}

	public void walkLeft() {
		face = 3;
		if (!(x == 0) && !walkblockactive)
			if (!Realm.checkCollision(new Position(x,y),face)){
				x -= walkspeed;
				walkblockactive = true;
				walkblocktimeout = walkblocktick;
			}
	}

	public void walkRight() {
		face = 1;
		if (!(x == Realm.WORLD_WIDTH) && !walkblockactive)
			if (!Realm.checkCollision(new Position(x,y),face)){
				x += walkspeed;
				walkblockactive = true;
				walkblocktimeout = walkblocktick;
			}
	}
}
