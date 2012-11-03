package com.github.desmaster.Devio.gfx;

import com.github.desmaster.Devio.InputHandler;
import com.github.desmaster.Devio.entity.Player;
import com.github.desmaster.Devio.realm.Level;
import com.github.desmaster.Devio.texture.iTexture;

public class Screen {

	private iTexture texture;
	private Level level;
	private Player player;
	private InputHandler input;

	public Screen(InputHandler input) {
		texture = new iTexture();
		level = new Level();
		player = new Player(iTexture.PLAYER_NINJA, 9, 6.7f, 100, input);
		this.setInput(input);
		input.x = player.x;
		input.y = player.y;
	}

	public void render() {
		level.render();
		player.render();
	}

	public void tick() {
		//player.tick();
		
	}

	public iTexture getTexture() {
		return texture;
	}

	public void setTexture(iTexture texture) {
		this.texture = texture;
	}

	public InputHandler getInput() {
		return input;
	}

	public void setInput(InputHandler input) {
		this.input = input;
	}
}
