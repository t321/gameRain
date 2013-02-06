package t321.graphics;

import java.util.Random;

import t321.level.tile.Tile;

public class Screen {

	public int width;
	public int height;
	public int[] pixels;

	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	
	public int xOffset, yOffset;

	public int[] tiles = new int[MAP_SIZE * MAP_SIZE]; // 4096

	private Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height]; // 50400

		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

//	public void render(int xOffset, int yOffset) {
//
//		for (int y = 0; y < height; y++) {
//			int yp = y + yOffset;
//			if (yp < 0 || yp >= height) continue;
//
//			for (int x = 0; x < width; x++) {
//				int xp = x + xOffset;
//				if (xp < 0 || xp >= width) continue;
//
//				// (xx >> 4) == (xx / 16)
//				// el valor de tileIndex vale de 0 a 15 lo mismo, de 16 a 31 lo mismo y así para rellenar los cuadros del mismo color
//				pixels[(x + xOffset) + (y + yOffset) * width] = Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.SIZE];
//			}
//
//		}
//
//	}

	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < 0 || xa > width || ya < 0 || ya > width) break;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}

	}
	
	public void setOffset(int xOffset, int yOffset)
	{
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
