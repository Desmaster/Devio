package com.github.desmaster.Devio.gfx.effect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.desmaster.Devio.gfx.effect.effects.FX_Damage;

public class EffectsHandler {

	public List<Effect> efxs = new ArrayList<Effect>();

	public EffectsHandler() {

	}

	public void tick() {
		Iterator<Effect> iterator = efxs.iterator();
		while (iterator.hasNext()) {
			Effect e = iterator.next();
			e.tick();
			if (!e.active)
				efxs.remove(e);
		}
	}

	public void render() {
		Iterator<Effect> iterator = efxs.iterator();
		while (iterator.hasNext()) {
			iterator.next().render();
		}
	}

	public Effect getEffect() {
		return null;
	}

	public void addEffect(Effect effx) {
		efxs.add(effx);
	}

	public void remove(Effect e) {
		efxs.remove(e);
	}

	public boolean hasEffect() {
		if (efxs.size() > 0)
			return true;
		return false;
	}
}
