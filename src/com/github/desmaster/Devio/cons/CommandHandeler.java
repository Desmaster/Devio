package com.github.desmaster.Devio.cons;

import com.github.desmaster.Devio.Devio;

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
		}
	}
	
	public static void advancedCommand(String comand,String arags){
		
	}
}
