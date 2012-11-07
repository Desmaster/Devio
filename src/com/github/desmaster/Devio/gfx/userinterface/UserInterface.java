package com.github.desmaster.Devio.gfx.userinterface;

import static org.lwjgl.opengl.GL11.*;
import java.awt.Color;

import org.lwjgl.util.Rectangle;

import com.github.desmaster.Devio.realm.Realm;

public class UserInterface {

	//State
	protected boolean active = false;
	
	//Info
	protected String name = "Undefined";
	
	//Look & Feel
	protected Rectangle container = new Rectangle(0,0,0,0);
	protected Color color = Color.white;
	
	public UserInterface(String name) {
		this.name = name;
	}
	
	public void tick(){
		
	}
	
	public void render(){
		if (this.active == true){
			glLoadIdentity();
			glTranslatef(container.getX(), container.getY(), 0);
			glColor4f(color.getRed()/255,color.getGreen()/255,color.getBlue()/255,color.getAlpha()/255);
			glBegin(GL_QUADS);
				glTexCoord2f(0, 0);
				glVertex2f(container.getX(), container.getY());
				glTexCoord2f(1, 0);
				glVertex2f(container.getX() + container.getWidth(), container.getY());
				glTexCoord2f(1, 1);
				glVertex2f(container.getX() + container.getWidth(), container.getY() + container.getHeight());
				glTexCoord2f(0, 1);
				glVertex2f(container.getX(), container.getY() + container.getHeight());
			glEnd();
			glLoadIdentity();			
		}
	}
	
	public void open(){
		this.active = true;
	}
	public void close(){
		this.active = false;
	}
}
