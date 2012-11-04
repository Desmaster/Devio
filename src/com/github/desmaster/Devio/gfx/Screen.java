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
		player = new Player(iTexture.PLAYER_NINJA, 9, (int) 6.7, 100, input);
		level = new Level();
		level.player = player;
		this.setInput(input);
	}

	public void render() {
		level.render();
		//player.render();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void tick() {
		level.tick();
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
