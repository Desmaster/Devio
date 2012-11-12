package com.github.desmaster.Devio.realm.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.realm.entity.mobs.Mob_GreenGoo;
import com.github.desmaster.Devio.realm.entity.mobs.Mob_Mouse;
import com.github.desmaster.Devio.realm.entity.mobs.Mob_RedGoo;

public class MobHandler {

	private List<Mob> mobs = new ArrayList<Mob>();

	public MobHandler() {
		for(int i = 0; i < 10; i++)
		mobs.add(new Mob_GreenGoo());
		for(int i = 0; i < 10; i++)
		mobs.add(new Mob_RedGoo());
		for (int i = 0; i < 200; i++) {
			mobs.add(new Mob_Mouse());
		}
		
		Console.log("Initialized GreenGoo");
	}

	public void tick() {
		Iterator<Mob> iterator = mobs.iterator();
		while (iterator.hasNext()) {
			Mob mob = iterator.next();
			if (mob.isNearPlayer()) {
				mob.tick();
			}
		}
	}
	
	public void destroyMob(Entity e) {
		if (e instanceof Mob)
		mobs.remove(e);
	}

	public void render() {
		Iterator<Mob> iterator = mobs.iterator();
		while (iterator.hasNext()) {
			Mob mob = iterator.next();
			if (mob.isNearPlayer()) {
				mob.render();
			}
		}
	}
}
