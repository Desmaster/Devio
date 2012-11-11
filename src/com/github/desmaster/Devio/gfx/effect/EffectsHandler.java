package com.github.desmaster.Devio.gfx.effect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EffectsHandler {
	
	public List<Effect> efxs = new ArrayList<Effect>();
	
	public EffectsHandler(){
		
	}
	
	public void tick(){
		Iterator<Effect> iterator = efxs.iterator();
		while (iterator.hasNext()) {
			Effect fx = iterator.next();
			if (fx.active) {
				fx.tick();
			}
		}
	}
	
	public void render(){
		Iterator<Effect> iterator = efxs.iterator();
		while (iterator.hasNext()) {
			Effect fx = iterator.next();
			if (fx.active) {
				fx.render();
			}
		}
	}
	
	public void addEffect(Effect effx){
		efxs.add(effx);
	}
}
