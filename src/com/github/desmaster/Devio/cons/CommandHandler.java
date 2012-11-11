package com.github.desmaster.Devio.cons;

import com.github.desmaster.Devio.Devio;
import com.github.desmaster.Devio.realm.Realm;

public class CommandHandler {

	public static void RunCommand(String string) {
		String[] a = null;
		if (string.contains("=")) {
			a = string.split("=");
			advancedCommand(a[0], a[1]);
			return;
		} else {
			simpleCommand(string);
			return;
		}
	}

	public static void simpleCommand(String string) {
		switch (string) {
		case "help":
			ChatHandler.log("You can use commands: " + "/ping, " + "/stop, " + "/toggledebug and " + "/walkspeed=value");
			break;
		case "ping":
			ChatHandler.log("pong");
			break;
		case "stop":
			Devio.stop();
			break;
		case "toggledebug":
			Devio.debugmode = !Devio.debugmode;
			ChatHandler.log("Toggled debug mode");
			break;
		}
	}

	public static void advancedCommand(String command, String args) {
		String[] arg = new String[10];
		if (args.contains(",")) {
			arg = args.split(",");
		}
		switch (command) {
		case "walkspeed":
			Realm.player.setWalkSpeed(Integer.parseInt(args));
			return;
		}
	}
}
