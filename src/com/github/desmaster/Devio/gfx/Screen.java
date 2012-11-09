package com.github.desmaster.Devio.gfx;

import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glColor4f;

import com.github.desmaster.Devio.InputHandler;
import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.gfx.userinterface.UserInterfaceHandler;
import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.realm.entity.Player;
import com.github.desmaster.Devio.tex.iTexture;
import com.github.desmaster.Devio.Devio;

public class Screen {

	enum State {
		GAME, MAIN_MENU, OPTIONS;
	}

	public State getState() {
		if (shouldRenderGame) {
			return State.GAME;
		}
		return null;
	}

	private boolean shouldRenderGame = true;
	private iTexture texture;
	private Realm realm;
	public static Player player;
	private static InputHandler input;
	private UserInterfaceHandler interfacehandler = new UserInterfaceHandler();

	public Screen(InputHandler input) {
		texture = new iTexture();
		player = new Player(iTexture.PLAYER_NINJA, Devio.spawnPosition, 100, input);
		realm = new Realm();
		realm.player = player;
		this.setInput(input);

	}

	public void render() {
		switch (getState()) {
		case GAME:
			glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
			glColor4f(1, 1, 1, 1);
			realm.render();
			player.render();
			interfacehandler.render();
			break;
		case MAIN_MENU:
			break;
		}
	}

	public void setConsole(String s, boolean shouldRender) {
		Console.setMessage(s);
	}

	public static Player getPlayer() {
		return player;
	}

	public void tick() {
		interfacehandler.tick();
		realm.tick();
	}

	public iTexture getTexture() {
		return texture;
	}

	public void setTexture(iTexture texture) {
		this.texture = texture;
	}

	public static InputHandler getInput() {
		return input;
	}

	public void setInput(InputHandler input) {
		this.input = input;
	}
}
