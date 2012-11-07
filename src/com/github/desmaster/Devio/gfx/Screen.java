package com.github.desmaster.Devio.gfx;


import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;

import com.github.desmaster.Devio.InputHandler;
import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.realm.entity.Player;
import com.github.desmaster.Devio.tex.iTexture;
import com.github.desmaster.Devio.Devio;

public class Screen {

	private iTexture texture;
	private Realm realm;
	public static Player player;
	private InputHandler input;
	private boolean shouldRenderConsole = false;
	private String consoleString;

	public Screen(InputHandler input) {
		texture = new iTexture();
		player = new Player(iTexture.PLAYER_NINJA, Devio.spawnPosition, 100, input);
		realm = new Realm();
		realm.player = player;
		this.setInput(input);
	}

	public void render() {
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		realm.render();
		player.render();
		if(shouldRenderConsole)
		Console.render();
		shouldRenderConsole = false;
	}
	
	public void setConsole(String s, boolean shouldRender) {
		Console.setMessage(s);
		shouldRenderConsole = shouldRender;
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
