package com.github.desmaster.Devio.realm;

import static com.github.desmaster.Devio.realm.Level.BLOCKS_HEIGHT;
import static com.github.desmaster.Devio.realm.Level.BLOCKS_WIDTH;
import static com.github.desmaster.Devio.realm.Level.BLOCK_SIZE;

import com.github.desmaster.Devio.texture.iTexture;

public class Scenery extends BlockGrid {

	public Scenery() {
		for (int x = 0; x < BLOCKS_WIDTH; x++) {
			for (int y = 0; y < BLOCKS_HEIGHT; y++) {
				int seed = random.nextInt(iTexture.objects.length - random.nextInt(14));
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
