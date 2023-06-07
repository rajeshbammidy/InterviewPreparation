package LeetCode.FEB23.leetcode.editor.en;

/**
 * Given an n x n binary matrix grid, return the length of the shortest clear path
 * in the matrix. If there is no clear path, return -1.
 *
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0))
 * to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 *
 *
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they
 * are different and they share an edge or a corner).
 *
 *
 * The length of a clear path is the number of visited cells of this path.
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 *
 *
 * Example 3:
 *
 *
 * Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
 * Output: -1
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
 * Related Topics Array Breadth-First Search Matrix 👍 4968 👎 192
 */

import javafx.util.Pair;

import java.util.*;

class ShortestPathInBinaryMatrix {
    public static void main(String args[]) {
        Solution solution = new ShortestPathInBinaryMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int shortestPathBinaryMatrix(int[][] grid) {
            int m = grid.length - 1;
            int n = grid[0].length - 1;

            int xcords[] = {-1, -1, 0, 1, 1, 1, 0, -1};
            int ycords[] = {0, -1, -1, -1, 0, 1, 1, 1};

            Queue<Pair<Pair<Integer, Integer>, Integer>> queue = new LinkedList<>();
            HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
            if (grid[0][0] == 1) return -1;
            queue.add(new Pair<>(new Pair<>(0, 0), 1));
            visited.add(new Pair<>(0, 0));
            while (!queue.isEmpty()) {

                Pair<Pair<Integer, Integer>, Integer> currentPair = queue.poll();
                Pair<Integer, Integer> cords = currentPair.getKey();
                int currentDistance = currentPair.getValue();
                int curx = cords.getKey();
                int cury = cords.getValue();

                if (curx == m && cury == n) return currentDistance;

                for (int i = 0; i < xcords.length; i++) {

                    if ((curx + xcords[i] >= 0 && curx + xcords[i] <= m && (cury + ycords[i] >= 0 && cury + ycords[i] <= n)) && grid[curx + xcords[i]][cury + ycords[i]]==0) {
                        if (!visited.contains(new Pair<>(curx + xcords[i], cury + ycords[i]))) {
                            visited.add(new Pair<>(curx + xcords[i], cury + ycords[i]));
                            queue.add(new Pair<>(new Pair<>(curx + xcords[i], cury + ycords[i]), currentDistance + 1));
                        }

                    }

                }


            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
