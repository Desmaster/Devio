package com.github.desmaster.Devio.realm.entity;

import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.util.Position;
import com.github.desmaster.Devio.util.gamemath.Collision;
import com.github.desmaster.Devio.util.gamemath.Distance;

public class EvilMob extends Mob {
	
	public int damage_Hit = 5;
	public int damage_Critical = 10;
	public int damage_timeout = 40;
	
	public EvilMob(Position spawnPosition, double lives) {
		super(spawnPosition, lives);
	}

	public void tick() {
		walkblock();
		if (!getWalkBlock()) {
			int[] direction = Distance.getDirection(x, y, Realm.player.x, Realm.player.y);

			// Console.log(x+" "+y+" "+Realm.player.x+" "+Realm.player.y);
			// Console.log(direction[0]+" "+direction[1]);

			if (!(Collision.check(new Position(x, y), direction[0]))) {
				switch (direction[0]) {
				case 0:
					aiUp();
				case 1:
					aiRight();
				case 2:
					aiDown();
				case 3:
					aiLeft();
				}
			} else if (!(Collision.check(new Position(x, y), direction[1]))) {
				switch (direction[1]) {
				case 0:
					aiUp();
				case 1:
					aiRight();
				case 2:
					aiDown();
				case 3:
					aiLeft();
				}
			} else {
				setWalkBlock(120);
			}
		}
	}
	
	public void aiUp(){
		if (Realm.player.x == x && Realm.player.y == (y-1)){
			hurt(damage_Hit,Realm.player);
		} else {
			walkUp();
		}
	}
	
	public void aiRight(){
		if (Realm.player.x == (x+1) && Realm.player.y == y){
			hurt(damage_Hit,Realm.player);
		} else {
			walkRight();
		}
	}
		
	public void aiDown(){
		if (Realm.player.x == x && Realm.player.y == (y+1)){
			hurt(damage_Hit,Realm.player);
		} else {
			walkDown();
		}
	}

	public void aiLeft(){
		if (Realm.player.x == (x - 1) && Realm.player.y == y){
			hurt(damage_Hit,Realm.player);
		} else {
			walkLeft();
		}
	}

}
