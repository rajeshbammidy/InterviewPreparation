package LeetCode.TopicWiseSolutions.Graphs.dfs;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * You are given an m x n integer matrix grid, and three integers row, col, and
 * color. Each value in the grid represents the color of the grid square at that
 * location.
 *
 * Two squares belong to the same connected component if they have the same color
 * and are next to each other in any of the 4 directions.
 *
 * The border of a connected component is all the squares in the connected
 * component that are either 4-directionally adjacent to a square not in the component,
 * or on the boundary of the grid (the first or last row or column).
 *
 * You should color the border of the connected component that contains the
 * square grid[row][col] with color.
 *
 * Return the final grid.
 *
 *
 * Example 1:
 * Input: grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * Output: [[3,3],[3,2]]
 *
 * Example 2:
 * Input: grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * Output: [[1,3,3],[2,3,3]]
 *
 * Example 3:
 * Input: grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
 * Output: [[2,2,2],[2,1,2],[2,2,2]]
 *
 *
 * Constraints:
 *
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j], color <= 1000
 * 0 <= row < m
 * 0 <= col < n
 *
 *
 * Related Topics Array Depth-First Search Breadth-First Search Matrix 👍 574 👎 7
 * 49
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1034 {
    /**
     * We should only color the border not the elements inside the border.
     * Approach:
     * 1.Run a dfs from row,col and find all the elements in the connected component
     * 2.Once we get elements in the connected component, we can check if we have to color a element or not by following the below given rules
     * i)If the node is surrounded by all same color nodes don't color it
     * ii)If the node at-least have one non-same color node adjacent to it, then color it
     */
    private static int prevColor;
    private static HashSet<Pair<Integer, Integer>> visited;
    private static ArrayList<Pair<Integer, Integer>> connectedComponent;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        prevColor = grid[row][col];
        visited = new HashSet<>();
        connectedComponent = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean flag = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == prevColor) {
                    dfs(grid, row, col);
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        int newGrid[][] = new int[m][n];
        //copy grid to newGrid
        for (int i = 0; i < m; i++) {
            newGrid[i] = grid[i].clone();
        }
        for (int i = 0; i < connectedComponent.size(); i++) {
            Pair<Integer, Integer> p = connectedComponent.get(i);

            if (!isSame(grid, p.getKey(), p.getValue(), prevColor)) {
                newGrid[p.getKey()][p.getValue()] = color;
            }

        }
        return newGrid;
    }


    //Helper method to determine if we have to color or not
    private boolean isSame(int[][] grid, Integer row, Integer col, int prevColor) {
        int m = grid.length;
        int n = grid[0].length;
        int dirX[] = {0, -1, 0, 1};
        int dirY[] = {-1, 0, 1, 0};
        //iterate all the four directions and see if it is surrounded by same color
        for (int i = 0; i < dirX.length; i++) {
            int nextRow = dirX[i] + row;
            int nextCol = dirY[i] + col;
            if (!isValid(nextRow, nextCol, m, n) || grid[nextRow][nextCol] != prevColor) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int[][] grid, int row, int col) {
        visited.add(new Pair<Integer, Integer>(row, col));
        connectedComponent.add(new Pair<Integer, Integer>(row, col));

        int dirX[] = {0, -1, 0, 1};
        int dirY[] = {-1, 0, 1, 0};
        for (int i = 0; i < dirX.length; i++) {
            int nextRow = dirX[i] + row;
            int nextCol = dirY[i] + col;
            if (isValid(nextRow, nextCol, grid.length, grid[0].length) && !visited.contains(new Pair<Integer, Integer>(nextRow, nextCol)) && grid[nextRow][nextCol] == prevColor) {
                dfs(grid, nextRow, nextCol);
            }
        }
    }

    private boolean isValid(int nextRow, int nextCol, int m, int n) {
        return nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
