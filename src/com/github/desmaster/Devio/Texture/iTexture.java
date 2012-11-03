package com.github.desmaster.Devio.texture;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import com.github.desmaster.Devio.cons.Console;

public class iTexture {

	public static Texture TEST_TEXTURE = null;
	public static Texture BETA_GRASS = null;
	
	public iTexture() {
		TEST_TEXTURE = getTexture("texture", "png");
		BETA_GRASS = getTexture("grass-beta", "png");
	}
	
	public Texture getTexture(String name, String ext) {
		try {
			Texture t1 = TextureLoader.getTexture(ext.toUpperCase(), iTexture.class.getResourceAsStream("/img/" + name + "." + ext));
			Console.log("Loaded " + name + "." + ext);
			return t1;
		} catch (IOException e) {
			Console.log(e.getMessage());
		}
		return null;
	}

}
 