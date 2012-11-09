package com.github.desmaster.Devio.realm.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MobHandeler {
	
	private List<Mob> mobsters = new ArrayList<Mob>();
	
	public MobHandeler(){
		
	}
	
	public void tick(){
		Iterator<Mob> iterator = mobsters.iterator();
		while (iterator.hasNext()) {
			Mob mob = iterator.next();
			
			if (mob.isNearPlayer())
			{
				mob.tick();
			}
		}
	}
	
	public void render(){
		Iterator<Mob> iterator = mobsters.iterator();
		while (iterator.hasNext()) {
			Mob mob = iterator.next();
			
			if (mob.isNearPlayer())
			{
				mob.render();
			}
		}
	}
}
