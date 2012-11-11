package com.github.desmaster.Devio.realm.storage;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;

import static org.lwjgl.opengl.GL11.*;

import com.github.desmaster.Devio.cons.Console;
import com.github.desmaster.Devio.gfx.Screen;
import com.github.desmaster.Devio.gfx.userinterface.UserInterface;
import com.github.desmaster.Devio.realm.entity.Player;
import com.github.desmaster.Devio.realm.item.Item;

public class Inventory extends UserInterface {

	public List<Item> items = new ArrayList<Item>();

	public static boolean active;

	public Inventory() {
		super("Inventory");
		container = new Rectangle(50, 50, Display.getWidth() - 125, Display.getHeight() - 125);
	}

	public void add(int slot, Item item) {
		items.add(slot, item);
	}

	public boolean contains(Item item) {
		return items.contains(items);
	}

	public void tick() {
		if (Screen.getInput().inventory.clicked) {
			if (Screen.canOpenScreen(this))
				active = !active;
		}

		if (active) {
			Screen.getPlayer().disableInput();
		} else {
			if (!Console.isActive())
				if (!Screen.getPlayer().isTicking())
					Screen.getPlayer().enableInput();
		}
	}

	public void render() {
		if (active) {
			shadeBackground();
			renderInventoryContainer();
			renderInventory();
		}
	}

	public void shadeBackground() {
		glLoadIdentity();
		glDisable(GL_TEXTURE_2D);
		glColor4f(0.025f, 0.025f, 0.025f, 0.8f);
		glTranslatef(0, 0, 0);
		glBegin(GL_QUADS);
		glVertex2f(0, 0);
		glVertex2f(0 + Display.getWidth(), 0);
		glVertex2f(0 + Display.getWidth(), 0 + Display.getHeight());
		glVertex2f(0, 0 + Display.getHeight());
		glEnd();
	}

	public void renderInventoryContainer() {
		int x = container.getX();
		int y = container.getY();
		glLoadIdentity();
		glDisable(GL_TEXTURE_2D);
		glColor4f(.4f,.2f, .08f, 1);
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		glVertex2f(x, y);
		glVertex2f(x + container.getWidth() - 50, y);
		glVertex2f(x + container.getWidth() - 50, y + container.getHeight() - 50);
		glVertex2f(x, y + container.getHeight() - 50);
		glEnd();
		glLoadIdentity();
	}

	public void renderInventory() {
		drawString(name, container.getX() + 55, container.getY() + 65, 1, 1, 1, 1);
		glColor4f(1, 1, 1, 1);
		glBegin(GL_LINES);
		glVertex2f(container.getX() + 50, container.getY() + 70);
		glVertex2f(container.getX() + container.getWidth(), container.getY() + 70);
		glEnd();
	}

	public boolean contains(Item item, int count) {
		List<Item> items = new ArrayList<Item>();
		for (int i = 0; i < count; i++) {
			items.add(item);
		}
		return items.containsAll(items);
	}

	public static boolean isActive() {
		return active;
	}

	public static void setActive(boolean bool) {
		active = bool;
	}

	public static void drawString(String s, int x, int y, float r, float g, float b, float a) {
		int startX = x;
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glBegin(GL11.GL_POINTS);
		GL11.glColor4f(r, g, b, a);
		GL11.glLoadIdentity();
		for (char c : s.toLowerCase().toCharArray()) {
			if (c == 'a') {
				for (int i = 0; i < 8; i++) {
					GL11.glVertex2f(x + 1, y - i);
					GL11.glVertex2f(x + 7, y - i);
				}
				for (int i = 2; i <= 6; i++) {
					GL11.glVertex2f(x + i, y - 8);
					GL11.glVertex2f(x + i, y - 4);
				}
				x += 8;
			} else if (c == 'b') {
				for (int i = 0; i < 8; i++) {
					GL11.glVertex2f(x + 1, y - i);
				}
				for (int i = 1; i <= 6; i++) {
					GL11.glVertex2f(x + i, y);
					GL11.glVertex2f(x + i, y - 4);
					GL11.glVertex2f(x + i, y - 8);
				}
				GL11.glVertex2f(x + 7, y - 5);
				GL11.glVertex2f(x + 7, y - 7);
				GL11.glVertex2f(x + 7, y - 6);

				GL11.glVertex2f(x + 7, y - 1);
				GL11.glVertex2f(x + 7, y - 2);
				GL11.glVertex2f(x + 7, y - 3);
				x += 8;
			} else if (c == 'c') {
				for (int i = 1; i <= 7; i++) {
					GL11.glVertex2f(x + 1, y - i);
				}
				for (int i = 2; i <= 5; i++) {
					GL11.glVertex2f(x + i, y);
					GL11.glVertex2f(x + i, y - 8);
				}
				GL11.glVertex2f(x + 6, y - 1);
				GL11.glVertex2f(x + 6, y - 2);

				GL11.glVertex2f(x + 6, y - 6);
				GL11.glVertex2f(x + 6, y - 7);

				x += 8;
			} else if (c == 'd') {
				for (int i = 0; i <= 8; i++) {
					GL11.glVertex2f(x + 1, y - i);
				}
				for (int i = 2; i <= 5; i++) {
					GL11.glVertex2f(x + i, y);
					GL11.glVertex2f(x + i, y - 8);
				}
				GL11.glVertex2f(x + 6, y - 1);
				GL11.glVertex2f(x + 6, y - 2);
				GL11.glVertex2f(x + 6, y - 3);
				GL11.glVertex2f(x + 6, y - 4);
				GL11.glVertex2f(x + 6, y - 5);
				GL11.glVertex2f(x + 6, y - 6);
				GL11.glVertex2f(x + 6, y - 7);

				x += 8;
			} else if (c == 'e') {
				for (int i = 0; i <= 8; i++) {
					GL11.glVertex2f(x + 1, y - i);
				}
				for (int i = 1; i <= 6; i++) {
					GL11.glVertex2f(x + i, y - 0);
					GL11.glVertex2f(x + i, y - 8);
				}
				for (int i = 2; i <= 5; i++) {
					GL11.glVertex2f(x + i, y - 4);
				}
				x += 8;
			} else if (c == 'f') {
				for (int i = 0; i <= 8; i++) {
					GL11.glVertex2f(x + 1, y - i);
				}
				for (int i = 1; i <= 6; i++) {
					GL11.glVertex2f(x + i, y - 8);
				}
				for (int i = 2; i <= 5; i++) {
					GL11.glVertex2f(x + i, y - 4);
				}
				x += 8;
			} else if (c == 'g') {
				for (int i = 1; i <= 7; i++) {
					GL11.glVertex2f(x + 1, y - i);
				}
				for (int i = 2; i <= 5; i++) {
					GL11.glVertex2f(x + i, y);
					GL11.glVertex2f(x + i, y - 8);
				}
				GL11.glVertex2f(x + 6, y - 1);
				GL11.glVertex2f(x + 6, y - 2);
				GL11.glVertex2f(x + 6, y - 3);
				GL11.glVertex2f(x + 5, y - 3);
				GL11.glVertex2f(x + 7, y - 3);

				GL11.glVertex2f(x + 6, y - 6);
				GL11.glVertex2f(x + 6, y - 7);

				x += 8;
			} else if (c == 'h') {
				for (int i = 0; i <= 8; i++) {
					GL11.glVertex2f(x + 1, y - i);
					GL11.glVertex2f(x + 7, y - i);
				}
				for (int i = 2; i <= 6; i++) {
					GL11.glVertex2f(x + i, y - 4);
				}
				x += 8;
			} else if (c == 'i') {
				for (int i = 0; i <= 8; i++) {
					GL11.glVertex2f(x + 3, y - i);
				}
				for (int i = 1; i <= 5; i++) {
					GL11.glVertex2f(x + i, y - 0);
					GL11.glVertex2f(x + i, y - 8);
				}
				x += 7;
			} else if (c == 'j') {
				for (int i = 1; i <= 8; i++) {
					GL11.glVertex2f(x + 6, y - i);
				}
				for (int i = 2; i <= 5; i++) {
					GL11.glVertex2f(x + i, y - 0);
				}
				GL11.glVertex2f(x + 1, y - 3);
				GL11.glVertex2f(x + 1, y - 2);
				GL11.glVertex2f(x + 1, y - 1);
				x += 8;
			} else if (c == 'k') {
				for (int i = 0; i <= 8; i++) {
					GL11.glVertex2f(x + 1, y - i);
				}
				GL11.glVertex2f(x + 6, y - 8);
				GL11.glVertex2f(x + 5, y - 7);
				GL11.glVertex2f(x + 4, y - 6);
				GL11.glVertex2f(x + 3, y - 5);
				GL11.glVertex2f(x + 2, y - 4);
				GL11.glVertex2f(x + 2, y - 3);
				GL11.glVertex2f(x + 3, y - 4);
				GL11.glVertex2f(x + 4, y - 3);
				GL11.glVertex2f(x + 5, y - 2);
				GL11.glVertex2f(x + 6, y - 1);
				GL11.glVertex2f(x + 7, y);
				x += 8;
			} else if (c == 'l') {
				for (int i = 0; i <= 8; i++) {
					GL11.glVertex2f(x + 1, y - i);
				}
				for (int i = 1; i <= 6; i++) {
					GL11.glVertex2f(x + i, y);
				}
				x += 7;
			} else if (c == 'm') {
				for (int i = 0; i <= 8; i++) {
					GL11.glVertex2f(x + 1, y - i);
					GL11.glVertex2f(x + 7, y - i);
				}
				GL11.glVertex2f(x + 3, y - 6);
				GL11.glVertex2f(x + 2, y - 7);
				GL11.glVertex2f(x + 4, y - 5);

				GL11.glVertex2f(x + 5, y - 6);
				GL11.glVertex2f(x + 6, y - 7);
				GL11.glVertex2f(x + 4, y - 5);
				x += 8;
			} else if (c == 'n') {
				for (int i = 0; i <= 8; i++) {
					GL11.glVertex2f(x + 1, y - i);
					GL11.glVertex2f(x + 7, y - i);
				}
				GL11.glVertex2f(x + 2, y - 7);
				GL11.glVertex2f(x + 2, y - 6);
				GL11.glVertex2f(x + 3, y - 5);
				GL11.glVertex2f(x + 4, y - 4);
				GL11.glVertex2f(x + 5, y - 3);
				GL11.glVertex2f(x + 6, y - 2);
				GL11.glVertex2f(x + 6, y - 1);
				x += 8;
			} else if (c == 'o' || c == '0') {
				for (int i = 1; i <= 7; i++) {
					GL11.glVertex2f(x + 1, y - i);
					GL11.glVertex2f(x + 7, y - i);
				}
				for (int i = 2; i <= 6; i++) {
					GL11.glVertex2f(x + i, y - 8);
					GL11.glVertex2f(x + i, y - 0);
				}
				x += 8;
			} else if (c == 'p') {
				for (int i = 0; i <= 8; i++) {
					GL11.glVertex2f(x + 1, y - i);
				}
				for (int i = 2; i <= 5; i++) {
					GL11.glVertex2f(x + i, y - 8);
					GL11.glVertex2f(x + i, y - 4);
				}
				GL11.glVertex2f(x + 6, y - 7);
				GL11.glVertex2f(x + 6, y - 5);
				GL11.glVertex2f(x + 6, y - 6);
				x += 8;
			} else if (c == 'q') {
				for (int i = 1; i <= 7; i++) {
					GL11.glVertex2f(x + 1, y - i);
					if (i != 1)
						GL11.glVertex2f(x + 7, y - i);
				}
				for (int i = 2; i <= 6; i++) {
					GL11.glVertex2f(x + i, y - 8);
					if (i != 6)
						GL11.glVertex2f(x + i, y - 0);
				}
				GL11.glVertex2f(x + 4, y - 3);
				GL11.glVertex2f(x + 5, y - 2);
				GL11.glVertex2f(x + 6, y - 1);
				GL11.glVertex2f(x + 7, y);
				x += 8;
			} else if (c == 'r') {
				for (int i = 0; i <= 8; i++) {
					GL11.glVertex2f(x + 1, y - i);
				}
				for (int i = 2; i <= 5; i++) {
					GL11.glVertex2f(x + i, y - 8);
					GL11.glVertex2f(x + i, y - 4);
				}
				GL11.glVertex2f(x + 6, y - 7);
				GL11.glVertex2f(x + 6, y - 5);
				GL11.glVertex2f(x + 6, y - 6);

				GL11.glVertex2f(x + 4, y - 3);
				GL11.glVertex2f(x + 5, y - 2);
				GL11.glVertex2f(x + 6, y - 1);
				GL11.glVertex2f(x + 7, y);
				x += 8;
			} else if (c == 's') {
				for (int i = 2; i <= 7; i++) {
					GL11.glVertex2f(x + i, y - 8);
				}
				GL11.glVertex2f(x + 1, y - 7);
				GL11.glVertex2f(x + 1, y - 6);
				GL11.glVertex2f(x + 1, y - 5);
				for (int i = 2; i <= 6; i++) {
					GL11.glVertex2f(x + i, y - 4);
					GL11.glVertex2f(x + i, y);
				}
				GL11.glVertex2f(x + 7, y - 3);
				GL11.glVertex2f(x + 7, y - 2);
				GL11.glVertex2f(x + 7, y - 1);
				GL11.glVertex2f(x + 1, y - 1);
				GL11.glVertex2f(x + 1, y - 2);
				x += 8;
			} else if (c == 't') {
				for (int i = 0; i <= 8; i++) {
					GL11.glVertex2f(x + 4, y - i);
				}
				for (int i = 1; i <= 7; i++) {
					GL11.glVertex2f(x + i, y - 8);
				}
				x += 7;
			} else if (c == 'u') {
				for (int i = 1; i <= 8; i++) {
					GL11.glVertex2f(x + 1, y - i);
					GL11.glVertex2f(x + 7, y - i);
				}
				for (int i = 2; i <= 6; i++) {
					GL11.glVertex2f(x + i, y - 0);
				}
				x += 8;
			} else if (c == 'v') {
				for (int i = 2; i <= 8; i++) {
					GL11.glVertex2f(x + 1, y - i);
					GL11.glVertex2f(x + 6, y - i);
				}
				GL11.glVertex2f(x + 2, y - 1);
				GL11.glVertex2f(x + 5, y - 1);
				GL11.glVertex2f(x + 3, y);
				GL11.glVertex2f(x + 4, y);
				x += 7;
			} else if (c == 'w') {
				for (int i = 1; i <= 8; i++) {
					GL11.glVertex2f(x + 1, y - i);
					GL11.glVertex2f(x + 7, y - i);
				}
				GL11.glVertex2f(x + 2, y);
				GL11.glVertex2f(x + 3, y);
				GL11.glVertex2f(x + 5, y);
				GL11.glVertex2f(x + 6, y);
				for (int i = 1; i <= 6; i++) {
					GL11.glVertex2f(x + 4, y - i);
				}
				x += 8;
			} else if (c == 'x') {
				int yy = y - 8;
				for (int i = 1; i <= 7; i++)
					GL11.glVertex2f(x + i, yy + i);
				for (int i = 7; i >= 1; i--)
					GL11.glVertex2f(x + i, y - i);
				x += 8;
			} else if (c == 'y') {
				GL11.glVertex2f(x + 4, y);
				GL11.glVertex2f(x + 4, y - 1);
				GL11.glVertex2f(x + 4, y - 2);
				GL11.glVertex2f(x + 4, y - 3);
				GL11.glVertex2f(x + 4, y - 4);

				GL11.glVertex2f(x + 3, y - 5);
				GL11.glVertex2f(x + 2, y - 6);
				GL11.glVertex2f(x + 1, y - 7);
				GL11.glVertex2f(x + 1, y - 8);

				GL11.glVertex2f(x + 5, y - 5);
				GL11.glVertex2f(x + 6, y - 6);
				GL11.glVertex2f(x + 7, y - 7);
				GL11.glVertex2f(x + 7, y - 8);
				x += 8;
			} else if (c == 'z') {
				for (int i = 1; i <= 6; i++) {
					GL11.glVertex2f(x + i, y);
					GL11.glVertex2f(x + i, y - 8);
					GL11.glVertex2f(x + i, y - i);
				}
				GL11.glVertex2f(x + 6, y - 7);
				x += 8;
			} else if (c == '1') {
				for (int i = 2; i <= 6; i++) {
					GL11.glVertex2f(x + i, y);
				}
				for (int i = 1; i <= 8; i++) {
					GL11.glVertex2f(x + 4, y - i);
				}
				GL11.glVertex2f(x + 3, y - 7);
				x += 8;
			} else if (c == '2') {
				for (int i = 1; i <= 6; i++) {
					GL11.glVertex2f(x + i, y);
				}
				for (int i = 2; i <= 5; i++) {
					GL11.glVertex2f(x + i, y - 8);
				}
				GL11.glVertex2f(x + 1, y - 7);
				GL11.glVertex2f(x + 1, y - 6);

				GL11.glVertex2f(x + 6, y - 7);
				GL11.glVertex2f(x + 6, y - 6);
				GL11.glVertex2f(x + 6, y - 5);
				GL11.glVertex2f(x + 5, y - 4);
				GL11.glVertex2f(x + 4, y - 3);
				GL11.glVertex2f(x + 3, y - 2);
				GL11.glVertex2f(x + 2, y - 1);
				x += 8;
			} else if (c == '3') {
				for (int i = 1; i <= 5; i++) {
					GL11.glVertex2f(x + i, y - 8);
					GL11.glVertex2f(x + i, y);
				}
				for (int i = 1; i <= 7; i++) {
					GL11.glVertex2f(x + 6, y - i);
				}
				for (int i = 2; i <= 5; i++) {
					GL11.glVertex2f(x + i, y - 4);
				}
				x += 8;
			} else if (c == '4') {
				for (int i = 2; i <= 8; i++) {
					GL11.glVertex2f(x + 1, y - i);
				}
				for (int i = 2; i <= 7; i++) {
					GL11.glVertex2f(x + i, y - 1);
				}
				for (int i = 0; i <= 4; i++) {
					GL11.glVertex2f(x + 4, y - i);
				}
				x += 8;
			} else if (c == '5') {
				for (int i = 1; i <= 7; i++) {
					GL11.glVertex2f(x + i, y - 8);
				}
				for (int i = 4; i <= 7; i++) {
					GL11.glVertex2f(x + 1, y - i);
				}
				GL11.glVertex2f(x + 1, y - 1);
				GL11.glVertex2f(x + 2, y);
				GL11.glVertex2f(x + 3, y);
				GL11.glVertex2f(x + 4, y);
				GL11.glVertex2f(x + 5, y);
				GL11.glVertex2f(x + 6, y);

				GL11.glVertex2f(x + 7, y - 1);
				GL11.glVertex2f(x + 7, y - 2);
				GL11.glVertex2f(x + 7, y - 3);

				GL11.glVertex2f(x + 6, y - 4);
				GL11.glVertex2f(x + 5, y - 4);
				GL11.glVertex2f(x + 4, y - 4);
				GL11.glVertex2f(x + 3, y - 4);
				GL11.glVertex2f(x + 2, y - 4);
				x += 8;
			} else if (c == '6') {
				for (int i = 1; i <= 7; i++) {
					GL11.glVertex2f(x + 1, y - i);
				}
				for (int i = 2; i <= 6; i++) {
					GL11.glVertex2f(x + i, y);
				}
				for (int i = 2; i <= 5; i++) {
					GL11.glVertex2f(x + i, y - 4);
					GL11.glVertex2f(x + i, y - 8);
				}
				GL11.glVertex2f(x + 7, y - 1);
				GL11.glVertex2f(x + 7, y - 2);
				GL11.glVertex2f(x + 7, y - 3);
				GL11.glVertex2f(x + 6, y - 4);
				x += 8;
			} else if (c == '7') {
				for (int i = 0; i <= 7; i++)
					GL11.glVertex2f(x + i, y - 8);
				GL11.glVertex2f(x + 7, y - 7);
				GL11.glVertex2f(x + 7, y - 6);

				GL11.glVertex2f(x + 6, y - 5);
				GL11.glVertex2f(x + 5, y - 4);
				GL11.glVertex2f(x + 4, y - 3);
				GL11.glVertex2f(x + 3, y - 2);
				GL11.glVertex2f(x + 2, y - 1);
				GL11.glVertex2f(x + 1, y);
				x += 8;
			} else if (c == '8') {
				for (int i = 1; i <= 7; i++) {
					GL11.glVertex2f(x + 1, y - i);
					GL11.glVertex2f(x + 7, y - i);
				}
				for (int i = 2; i <= 6; i++) {
					GL11.glVertex2f(x + i, y - 8);
					GL11.glVertex2f(x + i, y - 0);
				}
				for (int i = 2; i <= 6; i++) {
					GL11.glVertex2f(x + i, y - 4);
				}
				x += 8;
			} else if (c == '9') {
				for (int i = 1; i <= 7; i++) {
					GL11.glVertex2f(x + 7, y - i);
				}
				for (int i = 5; i <= 7; i++) {
					GL11.glVertex2f(x + 1, y - i);
				}
				for (int i = 2; i <= 6; i++) {
					GL11.glVertex2f(x + i, y - 8);
					GL11.glVertex2f(x + i, y - 0);
				}
				for (int i = 2; i <= 6; i++) {
					GL11.glVertex2f(x + i, y - 4);
				}
				GL11.glVertex2f(x + 1, y - 0);
				x += 8;
			} else if (c == '.') {
				GL11.glVertex2f(x + 1, y);
				x += 2;
			} else if (c == ',') {
				GL11.glVertex2f(x + 1, y);
				GL11.glVertex2f(x + 1, y - 1);
				x += 2;
			} else if (c == '\n') {
				y -= 10;
				x = startX;
			} else if (c == ' ') {
				x += 4;
			} else if (c == '/') {
				int yy = y + 2;
				for (int i = 9; i >= 1; i--)
					GL11.glVertex2f(x + i / 2, yy - i * 1.37f);
				x += 6;
			}
		}
		GL11.glColor4f(1, 1, 1, 1);
		GL11.glEnd();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}

}
