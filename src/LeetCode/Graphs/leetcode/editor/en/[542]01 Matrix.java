import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each
 * cell.
 *
 * The distance between two adjacent cells is 1.
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 *
 *
 * Example 2:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 *
 *
 *
 * Constraints:
 *
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10⁴
 * 1 <= m * n <= 10⁴
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 *
 *
 * Related Topics Array Dynamic Programming Breadth-First Search Matrix 👍 6453 👎
 * 311
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static class Node {
        int i;
        int j;
        int distance;

        public Node(int i, int j, int distance) {
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int res[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    int distance = findDistance(mat, i, j);
                    res[i][j] = distance;
                } else {
                    res[i][j] = 0;
                }
            }

        }
        return res;

    }

    private int findDistance(int[][] mat, int i, int j) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<Node> queue = new LinkedList<>();
        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
        queue.add(new Node(i, j, 0));
        visited.add(new Pair<Integer, Integer>(i, j));
        int dirX[] = {0, -1, 0, 1};
        int dirY[] = {-1, 0, 1, 0};
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int k = 0; k < dirX.length; k++) {
                int nextRow = dirX[k] + node.i;
                int nextCol = dirY[k] + node.j;

                if (isValid(nextRow, nextCol, m, n) && !visited.contains(new Pair<Integer, Integer>(nextRow, nextCol))) {
                    if (mat[nextRow][nextCol] == 0) return node.distance + 1;
                    queue.add(new Node(nextRow, nextCol, node.distance + 1));
                    visited.add(new Pair<Integer, Integer>(nextRow, nextCol));
                }

            }

        }
        return -1;

    }

    private boolean isValid(int nextRow, int nextCol, int m, int n) {
        return nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
