package kattis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class grid {
    /**
     * Pair class to hold the i,j index of a square
     */
    static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int bfs(int grid[][]) {
        int m = grid.length;
        int n = grid[0].length;
        /**
         * visited array to store the visited indexes of the grid
         */
        int visited[][] = new int[m][n];
        /**
         * queue to process BFS
         */
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        visited[0][0] = -1;
        int count = 0;
        /**
         * Store the current coordinates in currentI,currentJ
         */
        int currentI = grid.length - 1;
        int currentJ = grid[0].length - 1;
        while (!queue.isEmpty()) {
            int qs = queue.size();
            count++;
            while (qs-- > 0) {
                Pair pair = queue.poll();
                int distance = grid[pair.i][pair.j];
                //Validate and Move towards Top
                if (isValid(pair.i - distance, pair.j, m, n) && visited[(pair.i - distance)][pair.j] != -1) {
                    if (pair.i - distance == currentI && pair.j == currentJ) {
                        return count;
                    }
                    /**
                     * Add the adjacent square into queue and mark it as visited
                     */
                    queue.add(new Pair(pair.i - distance, pair.j));
                    visited[(pair.i - distance)][pair.j] = -1;
                }
                //Validate and Move towards Left
                if (isValid(pair.i, pair.j - distance, m, n) && visited[(pair.i)][pair.j - distance] != -1) {
                    if (pair.i == currentI && pair.j - distance == currentJ) {
                        return count;
                    }
                    /**
                     * Add the adjacent square into queue and mark it as visited
                     */
                    queue.add(new Pair(pair.i, pair.j - distance));
                    visited[(pair.i)][pair.j - distance] = -1;
                }
                //Validate and Move towards Bottom
                if (isValid(pair.i + distance, pair.j, m, n) && visited[(pair.i + distance)][pair.j] != -1) {
                    if (pair.i + distance == currentI && pair.j == currentJ) {
                        return count;
                    }
                    /**
                     * Add the adjacent square into queue and mark it as visited
                     */
                    queue.add(new Pair(pair.i + distance, pair.j));
                    visited[(pair.i + distance)][pair.j] = -1;
                }

                //Validate and Move towards Right
                if (isValid(pair.i, pair.j + distance, m, n) && visited[(pair.i)][pair.j + distance] != -1) {
                    if (pair.i == currentI && pair.j + distance == currentJ) {
                        return count;
                    }
                    /**
                     * Add the adjacent square into queue and mark it as visited
                     */
                    queue.add(new Pair(pair.i, pair.j + distance));
                    visited[(pair.i)][pair.j + distance] = -1;
                }

            }
        }
        return -1;


    }

    /**
     * Helper method to validate the coordinates
     */
    private static boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String size[] = bf.readLine().split("\\s");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);
        int dp[][] = new int[n][m];
        int row = 0;
        while (row < n) {
            int col = 0;
            String colNums[] = bf.readLine().split("");
            while (col < colNums.length) {
                dp[row][col] = Integer.parseInt(colNums[col]);
                col++;
            }
            row++;

        }
        System.out.println(bfs(dp));

    }
}

