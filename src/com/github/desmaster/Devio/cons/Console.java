package com.github.desmaster.Devio.cons;

import java.awt.Font;
import java.io.InputStream;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

public class Console {

	public Console() {
		init();
	}
	
	@SuppressWarnings("deprecation")
	static
	TrueTypeFont font;
	@SuppressWarnings("deprecation")
	static
	TrueTypeFont font2;
	 
	@SuppressWarnings("deprecation")
	public void init() {
		// load a default java font
		Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, false);
	 
		// load font from a .ttf file
		try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("myfont.ttf");
	 
			Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont2 = awtFont2.deriveFont(24f); // set font size
			font2 = new TrueTypeFont(awtFont2, false);
	 
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void log(String msg) {
		System.out.println("Console: " + msg);
	}
	
	public static void logC(String msg) {
		log(msg);
		Color.white.bind();
		drawString(msg, 50, 50);
	}
	
	@SuppressWarnings("deprecation")
	public static void drawString(String s, int x, int y){
		font.drawString(x, y, s);
	}

}
