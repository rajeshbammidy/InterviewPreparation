package LeetCode.MonthlyChallenges_22.Oct22;//You are given an m x n integer matrix grid where each cell is either 0 (empty)
// or 1 (obstacle). You can move up, down, left, or right from and to an empty 
//cell in one step. 
//
// Return the minimum number of steps to walk from the upper left corner (0, 0) 
//to the lower right corner (m - 1, n - 1) given that you can eliminate at most k 
//obstacles. If it is not possible to find such walk return -1. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
//Output: 6
//Explanation: 
//The shortest path without eliminating any obstacle is 10.
//The shortest path with one obstacle elimination at position (3,2) is 6. Such 
//path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
// 
//
// Example 2: 
// 
// 
//Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
//Output: -1
//Explanation: We need to eliminate at least two obstacles to find such a walk.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 40 
// 1 <= k <= m * n 
// grid[i][j] is either 0 or 1. 
// grid[0][0] == grid[m - 1][n - 1] == 0 
// 
//
// Related Topics Array Breadth-First Search Matrix 👍 3522 👎 61


//leetcode submit region begin(Prohibit modification and deletion)
class Solution1293 {
    static int answer;
    int dirx[] = {0, -1, 1, 0};
    int diry[] = {1, 0, 0, -1};

    public int shortestPath(int[][] grid, int k) {
        if (grid[0][0] == 1) return -1;
        answer = Integer.MAX_VALUE;
        findTheShortestPath(grid, k, 0, 0, grid.length, grid[0].length, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;

    }

    private int findTheShortestPath(int[][] grid, int k, int row, int col, int m, int n, int count) {
        if (row >= m && col >= n) {
            return -1;
        }
        if (row == m - 1 && col == n - 1) {
            answer = Math.min(answer, count);
        }

        /*if (k == 0 && row < m && col < n && grid[row][col] == 1) {
            return -1;
        }*/

        int returnedValue = 0;

        //right
        if (isValid(row, col, dirx[0], diry[0], m, n)) {
            int nextX = dirx[0], nextY = diry[0];
            if (isObstacle(grid, row + nextX, col + nextY)) {
                if (k > 0) {
                    returnedValue = findTheShortestPath(grid, k - 1, row + nextX, col + nextY, m, n, count + 1);
                } else {
                    returnedValue = -1;
                }

            } else {
                returnedValue = findTheShortestPath(grid, k, row + nextX, col + nextY, m, n, count + 1);
            }
        }


        //up
        if (isValid(row, col, dirx[1], diry[1], m, n)) {
            int nextX = dirx[1], nextY = diry[1];
            if (isObstacle(grid, row + nextX, col + nextY)) {
                if (k > 0) {
                    returnedValue = findTheShortestPath(grid, k - 1, row + nextX, col + nextY, m, n, count + 1);
                } else {
                    returnedValue = -1;
                }

            } else {
                returnedValue = findTheShortestPath(grid, k, row + nextX, col + nextY, m, n, count + 1);
            }
        }

        //down
        if (isValid(row, col, dirx[2], diry[2], m, n)) {
            int nextX = dirx[2], nextY = diry[2];
            if (isObstacle(grid, row + nextX, col + nextY)) {
                if (k > 0) {
                    returnedValue = findTheShortestPath(grid, k - 1, row + nextX, col + nextY, m, n, count + 1);
                } else {
                    returnedValue = -1;
                }

            } else {
                returnedValue = findTheShortestPath(grid, k, row + nextX, col + nextY, m, n, count + 1);
            }
        }

        //bottom
        if (isValid(row, col, dirx[3], diry[3], m, n)) {
            int nextX = dirx[3], nextY = diry[3];
            if (isObstacle(grid, row + nextX, col + nextY)) {
                if (k > 0) {
                    returnedValue = findTheShortestPath(grid, k - 1, row + nextX, col + nextY, m, n, count + 1);
                } else {
                    returnedValue = -1;
                }

            } else {
                returnedValue = findTheShortestPath(grid, k, row + nextX, col + nextY, m, n, count + 1);
            }
        }

        return -1;
    }

    private boolean isObstacle(int[][] grid, int i, int i1) {
        return grid[i][i1] == 1;
    }

    private boolean isValid(int row, int col, int dirx, int diry, int m, int n) {
        return row + dirx < m && col + diry < n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
