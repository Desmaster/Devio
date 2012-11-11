package com.github.desmaster.Devio.gfx.effect.effects;

import com.github.desmaster.Devio.gfx.effect.Effect;

public class FX_Damage extends Effect{
	
	public int amount = 0;
	
	public FX_Damage(int amount){
		this.amount = amount;
	}
	
	public void tick(){
		if (amount <= 0){
			active = false;
		} else {
			amount--;
		}
	}
	
	public void render(){
		
	}	
}
