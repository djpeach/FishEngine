package io.peachapps.fish.graphics;

import java.util.Random;

public class Screen {
    private int width;
    private int height;
    public int[] pixels;

    private int tileRowCount = 64;
    private int tileColCount = 64;

    private final int MAP_SIZE = 8;
    private final int MAP_SIZE_MASK = MAP_SIZE - 1;

    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

    private Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new int[width * height];

        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = random.nextInt(0xffffff);
        }
    }

    public void render(int xOffset, int yOffset) {
        // loop over 1D array as 2D x,y coords, from top to bottom, right to left
        for (int y = 0; y < height ;y++) {
            int yy = y + yOffset;
//            if (yy < 0 || yy >= height) break;
            for (int x = 0; x < width; x++) {
                int xx = x + xOffset;
//                if (xx < 0 || xx >= width) break;
//                int tileIndex = (x / 16) + (y / 16) * tileColCount;
                int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE; // faster to use bitwise shift for values of powers of two
                int row = y*width;
                int col = x;
                pixels[col + row] = tiles[tileIndex];
            }
        }
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++ ) {
            pixels[i] = 0x000000;
        }
    }
}
