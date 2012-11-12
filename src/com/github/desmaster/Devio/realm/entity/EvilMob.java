package com.github.desmaster.Devio.realm.entity;

import com.github.desmaster.Devio.gfx.Screen;
import com.github.desmaster.Devio.gfx.effect.effects.FX_Damage;
import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.util.Position;
import com.github.desmaster.Devio.util.iRandom;
import com.github.desmaster.Devio.util.gamemath.Collision;
import com.github.desmaster.Devio.util.gamemath.Distance;

public class EvilMob extends Mob {

	// Settings
	public int damage_min_hit = 0;
	public int damage_max_hit = 10;
	public int damage_critical_hit = 25;
	public int damage_critical_chance = 20; // % of chance to hit Critical
	public int damage_timeout = 40; // in ticks.

	// Variables
	public int timeoutuntildamage = 0;

	public EvilMob(Position spawnPosition, double lives) {
		super(spawnPosition, lives);
	}

	public void tick() {
		walkblock();
		if (timeoutuntildamage > 0) {
			timeoutuntildamage -= 1;
		}
		if (!getWalkBlock()) {
			int[] direction = Distance.getDirection(x, y, Realm.player.x,
					Realm.player.y);

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

	public void attack() {
		if (timeoutuntildamage <= 0) {
			setWalkBlock(120);
			int dmg = calculateDamage();
			hurt(dmg, Realm.player);
			timeoutuntildamage = damage_timeout;
			if(!Screen.getEffectsHandler().hasEffect())
			Screen.getEffectsHandler().addEffect(new FX_Damage(90));
		}
	}

	public int calculateDamage() {
		if (iRandom.nextInt(100) <= damage_critical_chance) {
			return damage_critical_hit;
		} else {
			return iRandom.nextInt(damage_min_hit,damage_max_hit);
		}
	}

	public void aiUp() {
		if (Realm.player.x == x && Realm.player.y == (y - 1)) {
			attack();
		} else {
			walkUp();
		}
	}

	public void aiRight() {
		if (Realm.player.x == (x + 1) && Realm.player.y == y) {
			attack();
		} else {
			walkRight();
		}
	}

	public void aiDown() {
		if (Realm.player.x == x && Realm.player.y == (y + 1)) {
			attack();
		} else {
			walkDown();
		}
	}

	public void aiLeft() {
		if (Realm.player.x == (x - 1) && Realm.player.y == y) {
			attack();
		} else {
			walkLeft();
		}
	}

}
