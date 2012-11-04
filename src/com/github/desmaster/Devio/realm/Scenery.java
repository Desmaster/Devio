package com.github.desmaster.Devio.realm;

import static com.github.desmaster.Devio.realm.Level.WORLD_HEIGHT;
import static com.github.desmaster.Devio.realm.Level.WORLD_WIDTH;
import static com.github.desmaster.Devio.realm.Level.BLOCK_SIZE;

import com.github.desmaster.Devio.texture.iTexture;

public class Scenery extends World {

	public Scenery() {
		for (int x = 0; x < WORLD_WIDTH; x++) {
			for (int y = 0; y < WORLD_HEIGHT; y++) {
				int seed = random.nextInt(iTexture.objects.length - random.nextInt(14));
				//seed = random(0, iTexture.objects.length - random(0, 14));
				if (random.nextInt(12 - random.nextInt(8)) == 1) {
					if (seed == iTexture.ID_FLOWER_RED)
						blocks[x][y] = new Block(iTexture.objects[seed], x * BLOCK_SIZE, y * BLOCK_SIZE);
					if (seed == iTexture.ID_FLOWER_YELLOW)
						blocks[x][y] = new Block(iTexture.objects[seed], x * BLOCK_SIZE, y * BLOCK_SIZE);
				}
			}
		}
	}

}
