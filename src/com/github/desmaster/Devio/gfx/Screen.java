package com.github.desmaster.Devio.gfx;


import com.github.desmaster.Devio.InputHandler;
import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.realm.entity.Player;
import com.github.desmaster.Devio.tex.iTexture;
import com.github.desmaster.Devio.Devio;

public class Screen {

	private iTexture texture;
	private Realm realm;
	public static Player player;
	private InputHandler input;

	public Screen(InputHandler input) {
		texture = new iTexture();
		player = new Player(iTexture.PLAYER_NINJA, Devio.spawnPosition, 100, input);
		realm = new Realm();
		realm.player = player;
		this.setInput(input);
	}

	public void render() {
		//Console.logC("derp");
		realm.render();
		player.render();
	}

	public static Player getPlayer() {
		return player;
	}

	public void tick() {
		realm.tick();
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
