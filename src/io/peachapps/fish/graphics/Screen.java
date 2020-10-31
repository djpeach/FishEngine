package io.peachapps.fish.graphics;

public class Screen {
    private int width;
    private int height;
    public int[] pixels;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new int[width * height];
    }

    public void render() {
        // loop over 1D array as 2D x,y coords, from top to bottom, right to left
        for (int y = 0; y < height ;y++) {
            for (int x = 0; x < width; x++) {
                int row = y*width;
                int col = x;
                pixels[col + row] = 0xff00ff;
            }
        }
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++ ) {
            pixels[i] = 0x000000;
        }
    }
}
