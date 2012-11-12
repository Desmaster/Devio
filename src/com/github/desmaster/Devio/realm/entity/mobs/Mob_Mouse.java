package com.github.desmaster.Devio.realm.entity.mobs;

import com.github.desmaster.Devio.realm.entity.FriendlyMob;
import com.github.desmaster.Devio.realm.entity.FriendlyMob2;
import com.github.desmaster.Devio.tex.iTexture;
import com.github.desmaster.Devio.util.Position;

public class Mob_Mouse extends FriendlyMob2 {

	public Mob_Mouse() {
		super(new Position(5, 5), 45);
		setTexture(iTexture.ID_MOUSE_0);
		setWalkSpeed(4);
	}

}
