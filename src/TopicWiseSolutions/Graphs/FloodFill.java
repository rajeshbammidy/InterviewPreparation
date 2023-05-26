package TopicWiseSolutions.Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Graphs|FloodFill| on May,2020
 *  
 * Happy Coding :)
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 *
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 *
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 *
 * At the end, return the modified image.
 *
 * Example 1:
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 * Note:
 *
 * The length of image and image[0] will be in the range [1, 50].
 * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 **/
public class FloodFill {
    static class node {
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int rows[] = new int[]{-1, 0, 1, 0};
        int cols[] = new int[]{0, 1, 0, -1};
        int m = image.length;
        int n = image[0].length;

        Queue<node> queue = new LinkedList<>();
        queue.add(new node(sr, sc));
        int target = image[sr][sc];
        image[sr][sc] = -1;
        while (!queue.isEmpty()) {
            node temp = queue.poll();
            int x = temp.x;
            int y = temp.y;
            for (int i = 0; i < 4; i++) {

                if (isValid(x + rows[i], y + cols[i], m, n) && image[x + rows[i]][y + cols[i]] == target) {
                    image[x + rows[i]][y + cols[i]] = -1;
                    queue.add(new node(x + rows[i], y + cols[i]));
                }

            }

        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (image[i][j] == -1) image[i][j] = newColor;
            }
        }
        return image;


    }

    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;

    }
}
