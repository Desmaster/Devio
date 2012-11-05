package com.github.desmaster.Devio.realm;

import static com.github.desmaster.Devio.realm.Realm.BLOCK_SIZE;
import static com.github.desmaster.Devio.realm.Realm.WORLD_HEIGHT;
import static com.github.desmaster.Devio.realm.Realm.WORLD_WIDTH;
import static com.github.desmaster.Devio.tex.iTexture.ID_FLOWER_RED;
import static com.github.desmaster.Devio.tex.iTexture.ID_FLOWER_YELLOW;
import static com.github.desmaster.Devio.tex.iTexture.ID_GRASS;
import static com.github.desmaster.Devio.tex.iTexture.textures;

public class Scenery extends World_Old {

	public Scenery() {
		for (int x = 0; x < WORLD_WIDTH; x++) {
			for (int y = 0; y < WORLD_HEIGHT; y++) {
				int seed;// = random.nextInt(objects.length -
							// random.nextInt(14));
				seed = random(0, textures.length);
				if (random.nextInt(2) == 1) {
						if (seed == ID_FLOWER_RED || seed == ID_FLOWER_YELLOW) {
							if (blocks[x][y].texture == textures[ID_GRASS]) {
							blocks[x][y] = new Block(textures[seed], x * BLOCK_SIZE, y * BLOCK_SIZE);
							//Console.log("Rendered " + seed + " at x:" + x + ", y: " + y);
							}
					}
				}
			}
		}
	}
}
