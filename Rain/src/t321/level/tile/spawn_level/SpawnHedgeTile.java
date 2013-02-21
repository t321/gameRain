package t321.level.tile.spawn_level;

import t321.graphics.Screen;
import t321.graphics.Sprite;
import t321.level.tile.Tile;

public class SpawnHedgeTile extends Tile {

	public SpawnHedgeTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean solid(){
		return true;
	}
	
	public boolean breakable()
	{
		return true;
	}
}
