package com.github.desmaster.Devio.gfx;

import com.github.desmaster.Devio.realm.Level;
import com.github.desmaster.Devio.texture.iTexture;

public class Screen {

	private iTexture texture;
	private Level level;

	public Screen() {
		setTexture(new iTexture());
		level = new Level();
	}

	public void render() {
		level.render();
	}

	public void tick() {
		
	}

	public iTexture getTexture() {
		return texture;
	}

	public void setTexture(iTexture texture) {
		this.texture = texture;
	}
}
