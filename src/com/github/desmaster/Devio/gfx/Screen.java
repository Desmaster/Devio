package com.github.desmaster.Devio.gfx;

import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glColor4f;

import com.github.desmaster.Devio.Devio;
import com.github.desmaster.Devio.InputHandler;
import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.gfx.effect.EffectsHandler;
import com.github.desmaster.Devio.gfx.effect.effects.FX_Damage;
import com.github.desmaster.Devio.gfx.screens.Screen_Death;
import com.github.desmaster.Devio.gfx.userinterface.UserInterface;
import com.github.desmaster.Devio.gfx.userinterface.UserInterfaceHandler;
import com.github.desmaster.Devio.realm.Realm;
import com.github.desmaster.Devio.realm.entity.Player;
import com.github.desmaster.Devio.realm.storage.Inventory;
import com.github.desmaster.Devio.tex.iTexture;

public class Screen {

	public static enum State {
		INTRO, MAIN_MENU, GAME, DEAD, OPTIONS;
	}
	
	public static State state = State.GAME;
	
	public static State getState() {
		return state;
	}

	private boolean shouldRenderGame = true;
	private iTexture texture;
	private Realm realm;
	public static Player player;
	private static InputHandler input;
	private UserInterfaceHandler interfacehandler = new UserInterfaceHandler();
	private static EffectsHandler effectsHandler = new EffectsHandler();

	@SuppressWarnings("static-access")
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
			effectsHandler.render();
			interfacehandler.render();
			break;
		case MAIN_MENU:
			break;
		case OPTIONS:
			break;
		case DEAD:
			glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
			glColor4f(1, 1, 1, 1);
			Screen_Death.render();
			break;
		case INTRO:
			break;
		}
	}

	public static boolean canOpenScreen(UserInterface ui) {
		if (ui instanceof Inventory) {
			if (Console.isActive()) {
				return false;
			} else {
				return true;
			}
		} else if (ui instanceof Console) {
			return true;
		}
		return false;
	}

	public void setConsole(String s, boolean shouldRender) {
		Console.setMessage(s);
	}
	
	public void setState(State s) {
		state = s;
	}
	
	public static Player getPlayer() {
		return player;
	}

	public void tick() {
		effectsHandler.tick();
		interfacehandler.tick();
		realm.tick();
	}

	public iTexture getTexture() {
		return texture;
	}
	
	public static EffectsHandler getEffectsHandler() {
		return effectsHandler;
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
