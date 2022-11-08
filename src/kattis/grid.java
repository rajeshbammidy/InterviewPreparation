package kattis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class grid {
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
        HashSet<String> set = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));


        //set.add(0 + "-" + 0);
       /* //T,L,B,R
        int dirX[] = {-1, 0, 1, 0};
        int dirY[] = {0, -1, 0, 1};*/
        int count = 0;
        int distI = grid.length - 1;
        int distJ = grid[0].length - 1;
        while (!queue.isEmpty()) {
            int qs = queue.size();
            count++;
            while (qs-- > 0) {
                Pair pair = queue.poll();
                int distance = grid[pair.i][pair.j];
                grid[0][0] = Integer.MIN_VALUE;
                //Top

                if (isValid(pair.i - distance, pair.j, m, n) && grid[(pair.i - distance)][pair.j] != Integer.MIN_VALUE) {
                    if (pair.i - distance == distI && pair.j == distJ) {
                        return count;
                    }
                    queue.add(new Pair(pair.i - distance, pair.j));
                }
                //Left
                if (isValid(pair.i, pair.j - distance, m, n) && grid[(pair.i)][pair.j - distance] != Integer.MIN_VALUE) {
                    if (pair.i == distI && pair.j - distance == distJ) {
                        return count;
                    }
                    queue.add(new Pair(pair.i, pair.j - distance));

                }
                //Bottom
                if (isValid(pair.i + distance, pair.j, m, n) && grid[(pair.i + distance)][pair.j] != Integer.MIN_VALUE) {
                    if (pair.i + distance == distI && pair.j == distJ) {
                        return count;
                    }
                    queue.add(new Pair(pair.i + distance, pair.j));

                }

                //Right
                if (isValid(pair.i, pair.j + distance, m, n) && grid[(pair.i)][pair.j + distance] != Integer.MIN_VALUE) {
                    if (pair.i == distI && pair.j + distance == distJ) {
                        return count;
                    }
                    queue.add(new Pair(pair.i, pair.j + distance));

                }
                grid[(pair.i)][pair.j] = Integer.MIN_VALUE;

            }
        }
        return -1;


    }

    private static boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String size[] = bf.readLine().split("\\s");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);
        int dp[][] = new int[n][m];
        int ri = 0;
        while (ri < n) {
            int rj = 0;
            String colNums[] = bf.readLine().split("");
            while (rj < colNums.length) {
                dp[ri][rj] = Integer.parseInt(colNums[rj]);
                rj++;
            }
            ri++;

        }
        System.out.println(bfs(dp));

    }
}
