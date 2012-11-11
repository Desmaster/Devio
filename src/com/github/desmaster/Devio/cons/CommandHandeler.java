package com.github.desmaster.Devio.cons;

import com.github.desmaster.Devio.Devio;
import com.github.desmaster.Devio.realm.Realm;

public class CommandHandeler {
	
	public static void RunCommand(String string){
		String[] a = null;
		if (string.contains("=")){
			a = string.split("=");
			advancedCommand(a[0],a[1]);
			return;
		} else {
			simpleCommand(string);
			return;
		}
		
	}
	
	public static void simpleCommand(String string){
		switch(string){
		case "ping":		
			Console.log("PONG!");
			return;
		case "stop":		
			Devio.stop();
			return;
		case "toggledebug":		
			Devio.debugmode = !Devio.debugmode;
			return;
		}
	}
	
	public static void advancedCommand(String command,String arags){
		String[] arg = new String[10];
		if (arags.contains(",")){
			arg = arags.split(",");
		}
		switch(command){
		case "walkspeed":		
			Realm.player.setWalkSpeed(Integer.parseInt(arags));
			return;
		}
	}
}
