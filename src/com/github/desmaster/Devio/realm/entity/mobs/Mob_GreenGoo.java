package com.github.desmaster.Devio.realm.entity.mobs;

import com.github.desmaster.Devio.realm.entity.Mob;
import com.github.desmaster.Devio.util.Position;

public class Mob_GreenGoo extends Mob{
	
	public Mob_GreenGoo(Position spawnPosition, double lives) {
		super(new Position(10,15), 50);
	}
	
	public void tick() {
		if (getWalkBlock()){
			
		}
	}

}
