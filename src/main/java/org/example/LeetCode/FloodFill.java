package org.example.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    static class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int cols = image[0].length;
            int rows = image.length;

            if(image[sr][sc] == color) return image;

            int initColor = image[sr][sc];
            Queue<Pixel> queue = new LinkedList<>();
            queue.add(new Pixel(sr, sc));
            do {
                Pixel pixel = queue.remove();
                addPixelToQueue(new Pixel(pixel.row + 1, pixel.col), rows, cols, queue, initColor, image);
                addPixelToQueue(new Pixel(pixel.row - 1, pixel.col), rows, cols, queue, initColor, image);
                addPixelToQueue(new Pixel(pixel.row, pixel.col + 1), rows, cols, queue, initColor, image);
                addPixelToQueue(new Pixel(pixel.row, pixel.col - 1), rows, cols, queue, initColor, image);
                image[pixel.row][pixel.col] = color;
            }while (!queue.isEmpty());
            return image;
        }

        private void addPixelToQueue(Pixel pixel, int row, int col, Queue<Pixel> queue, int initColor, int[][] image){
            if (pixel.row < 0 || pixel.row >= row) return;
            if (pixel.col < 0 || pixel.col >= col) return;
            if (image[pixel.row][pixel.col] != initColor) return;

            queue.add(pixel);
        }

        record Pixel(int row, int col){}
    }
}
