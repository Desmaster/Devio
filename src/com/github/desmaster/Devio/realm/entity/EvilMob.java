package com.github.desmaster.Devio.realm.entity;

import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.util.Position;
import com.github.desmaster.Devio.util.gamemath.Collision;
import com.github.desmaster.Devio.util.gamemath.Distance;

public class EvilMob extends Mob {

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
					walkUp();
				case 1:
					walkRight();
				case 2:
					walkDown();
				case 3:
					walkLeft();
				}
			} else if (!(Collision.check(new Position(x, y), direction[1]))) {
				switch (direction[1]) {
				case 0:
					walkUp();
				case 1:
					walkRight();
				case 2:
					walkDown();
				case 3:
					walkLeft();
				}
			} else {
				setWalkBlock(120);
			}
		}
	}
	
}
