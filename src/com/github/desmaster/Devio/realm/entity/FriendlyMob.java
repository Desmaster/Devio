package com.github.desmaster.Devio.realm.entity;

import com.github.desmaster.Devio.tex.iTexture;
import com.github.desmaster.Devio.util.Position;
import com.github.desmaster.Devio.util.iRandom;

public class FriendlyMob extends Mob {

	public FriendlyMob(Position spawnPosition, double lives) {
		super(spawnPosition, lives);
	}

	public void tick() {
		walkblock();

		if (!getWalkBlock()) {

			switch (iRandom.nextInt(4)) {
			case 0:
				aiUp();
				break;
			case 1:
				aiRight();
				break;
			case 2:
				aiDown();
				break;
			case 3:
				aiLeft();
				break;
			}
		}
		
		if(!(getTexture() == iTexture.textures[iTexture.ID_MOUSE_0 + face]))
		setTexture(iTexture.ID_MOUSE_0 + face);
	}

	public void aiUp() {
		walkUp();
	}

	public void aiRight() {
		walkRight();
	}

	public void aiDown() {
		walkDown();
	}

	public void aiLeft() {
		walkLeft();
	}

}
