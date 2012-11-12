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
			case 1:
				aiRight();
			case 2:
				aiDown();
			case 3:
				aiLeft();
			}
		}

		switch (face) {
		case 0:
			if (getTexture() != iTexture.textures[iTexture.ID_MOUSE_0])
				setTexture(iTexture.ID_MOUSE_0);
			break;
		case 1:
			if (getTexture() != iTexture.textures[iTexture.ID_MOUSE_1])
				setTexture(iTexture.ID_MOUSE_1);
			break;
		case 2:
			if (getTexture() != iTexture.textures[iTexture.ID_MOUSE_2])
				setTexture(iTexture.ID_MOUSE_2);
			break;
		case 3:
			if (getTexture() != iTexture.textures[iTexture.ID_MOUSE_3])
				setTexture(iTexture.ID_MOUSE_3);
			break;
		}

	}

	public void aiUp() {
		walkUp();
		setWalkBlock(120);
	}

	public void aiRight() {
		walkRight();
		setWalkBlock(120);
	}

	public void aiDown() {
		walkDown();
		setWalkBlock(120);
	}

	public void aiLeft() {
		walkLeft();
		setWalkBlock(120);
	}

}
