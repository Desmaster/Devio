package com.github.desmaster.Devio.realm.entity.mobs;

import com.github.desmaster.Devio.realm.entity.EvilMob;
import com.github.desmaster.Devio.tex.iTexture;
import com.github.desmaster.Devio.util.Position;
import com.github.desmaster.Devio.util.iRandom;

public class Mob_GreenGoo extends EvilMob {

	public Mob_GreenGoo() {
		super(new Position(iRandom.nextInt(0, 15), iRandom.nextInt(0, 15)), 50);
		setTexture(iTexture.ID_GOO_GREEN);
	}

	

}
