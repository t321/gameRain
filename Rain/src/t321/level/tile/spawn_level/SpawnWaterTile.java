package t321.level.tile.spawn_level;

import t321.graphics.Screen;
import t321.graphics.Sprite;
import t321.level.tile.Tile;

public class SpawnWaterTile extends Tile {

	public SpawnWaterTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}
