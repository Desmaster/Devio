package com.github.desmaster.Devio.realm.entity.mobs;

import com.github.desmaster.Devio.realm.entity.EvilMob;
import com.github.desmaster.Devio.tex.iTexture;
import com.github.desmaster.Devio.util.Position;

public class Mob_RedGoo extends EvilMob {

	public Mob_RedGoo() {
		super(new Position(15, 15), 50);
		setTexture(iTexture.ID_GOO_RED);
	}

}
