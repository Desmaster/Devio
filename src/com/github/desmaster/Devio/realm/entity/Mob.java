package com.github.desmaster.Devio.realm.entity;

import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.util.Position;
import com.github.desmaster.Devio.util.gamemath.Collision;

public class Mob extends Entity {

	private int walkspeed = 1;
	private int walkblocktick = 24;
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
			if (!Collision.check(new Position(x,y),face)){
				y -= walkspeed;
				SetWalkBlock(walkblocktick);
			}
	}

	public void walkDown() {
		face = 2;
		if (!(y == Realm.WORLD_HEIGHT - 1) && !walkblockactive)
			if (!Collision.check(new Position(x,y),face)){
				y += walkspeed;
				SetWalkBlock(walkblocktick);
			}
	}

	public void walkLeft() {
		face = 3;
		if (!(x == 0) && !walkblockactive)
			if (!Collision.check(new Position(x,y),face)){
				x -= walkspeed;
				SetWalkBlock(walkblocktick);
			}
	}

	public void walkRight() {
		face = 1;
		if (!(x == Realm.WORLD_WIDTH - 1) && !walkblockactive)
			if (!Collision.check(new Position(x,y),face)){
				x += walkspeed;
				SetWalkBlock(walkblocktick);
			}
	}
	public void SetWalkBlock(int timeout) {
		walkblockactive = true;
		walkblocktimeout = timeout;
	}
	public boolean isNearPlayer() {
		// TODO Auto-generated method stub
		return false;
	}
}
