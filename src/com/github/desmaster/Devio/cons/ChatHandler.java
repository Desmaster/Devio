package com.github.desmaster.Devio.cons;

import java.util.LinkedList;
import java.util.List;

public class ChatHandler {

	static List<String> chatList = new LinkedList<String>();
	
	public static void log(String msg) {
		chatList.add(msg);
	}
	
	public static void renderConsoleText() {
		if (chatList.size() > 0) {
			for ( int i=0; i<chatList.size(); i++ ) {
				Console.drawString(chatList.get(i), 15, 30 + (i * 15));
			}
		}
	}
	
}
