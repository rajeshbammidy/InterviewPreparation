package LeetCode.FEB23;

/**
 * Given an n x n grid containing only values 0 and 1, where 0 represents water
 * and 1 represents land, find a water cell such that its distance to the nearest
 * land cell is maximized, and return the distance. If no land or water exists in the
 * grid, return -1.
 *
 * The distance used in this problem is the Manhattan distance: the distance
 * between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 * Explanation: The cell (1, 1) is as far as possible from all the land with
 * distance 2.
 *
 *
 * Example 2:
 *
 *
 * Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
 * Output: 4
 * Explanation: The cell (2, 2) is as far as possible from all the land with
 * distance 4.
 *
 *
 *
 * Constraints:
 *
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] is 0 or 1
 *
 *
 * Related Topics Array Dynamic Programming Breadth-First Search Matrix 👍 3377 👎
 * 88
 */

import javafx.util.Pair;

import java.util.*;

class AsFarFromLandAsPossible {
    public static void main(String args[]) {
        Solution solution = new AsFarFromLandAsPossible().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDistance(int[][] grid) {

            int ans = -1;
            int m = grid.length;
            int n = grid[0].length;
            HashSet<Pair<Integer, Integer>> set = new HashSet<Pair<Integer, Integer>>();
            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        queue.add(new Pair<Integer, Integer>(i, j));
                        set.add(new Pair<Integer, Integer>(i, j));
                    }
                }
            }

            int dirx[] = {0, -1, 1, 0};
            int diry[] = {1, 0, 0, -1};
            int distance = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Pair<Integer, Integer> p = queue.poll();

                    for (int j = 0; j < dirx.length; j++) {
                        int nx = dirx[j] + p.getKey();
                        int ny = diry[j] + p.getValue();
                        if (isValid(nx, ny, grid.length, grid[0].length) && !set.contains(new Pair<Integer, Integer>(nx, ny))) {
                            if (grid[nx][ny] == 1) continue;
                            set.add(new Pair<Integer, Integer>(nx, ny));
                            queue.add(new Pair<Integer, Integer>(nx, ny));
                        }

                    }

                }
                distance++;

            }
            return distance == 1 ? -1 : distance - 1;


        }

        private int bfs(int[][] grid, int x, int y) {
            HashSet<Pair<Integer, Integer>> set = new HashSet<Pair<Integer, Integer>>();
            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
            queue.add(new Pair<Integer, Integer>(x, y));
            set.add(new Pair<Integer, Integer>(x, y));
            int dirx[] = {0, -1, 1, 0};
            int diry[] = {1, 0, 0, -1};
            int distance = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Pair<Integer, Integer> p = queue.poll();

                    for (int j = 0; j < dirx.length; j++) {
                        int nx = dirx[j] + p.getKey();
                        int ny = diry[j] + p.getValue();
                        if (isValid(nx, ny, grid.length, grid[0].length) && !set.contains(new Pair<Integer, Integer>(nx, ny))) {
                            if (grid[nx][ny] == 1) return distance + 1;
                            set.add(new Pair<Integer, Integer>(nx, ny));
                            queue.add(new Pair<Integer, Integer>(nx, ny));
                        }

                    }

                }
                distance++;

            }
            return -1;

        }

        private boolean isValid(int nextRow, int nextCol, int m, int n) {
            return nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
