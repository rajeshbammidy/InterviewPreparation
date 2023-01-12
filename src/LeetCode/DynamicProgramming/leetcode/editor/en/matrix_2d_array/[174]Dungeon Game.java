package LeetCode.DynamicProgramming.leetcode.editor.en.matrix_2d_array;

import java.util.Arrays;

/**
 * The demons had captured the princess and imprisoned her in the bottom-right
 * corner of a dungeon. The dungeon consists of m x n rooms laid out in a 2D grid. Our
 * valiant knight was initially positioned in the top-left room and must fight his
 * way through dungeon to rescue the princess.
 *
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons (represented by negative integers), so
 * the knight loses health upon entering these rooms; other rooms are either empty
 * (represented as 0) or contain magic orbs that increase the knight's health (
 * represented by positive integers).
 *
 * To reach the princess as quickly as possible, the knight decides to move only
 * rightward or downward in each step.
 *
 * Return the knight's minimum initial health so that he can rescue the princess.
 *
 *
 * Note that any room can contain threats or power-ups, even the first room the
 * knight enters and the bottom-right room where the princess is imprisoned.
 *
 *
 * Example 1:
 *
 *
 * Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
 * Output: 7
 * Explanation: The initial health of the knight must be at least 7 if he follows
 * the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.
 *
 *
 * Example 2:
 *
 *
 * Input: dungeon = [[0]]
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *
 * m == dungeon.length
 * n == dungeon[i].length
 * 1 <= m, n <= 200
 * -1000 <= dungeon[i][j] <= 1000
 *
 *
 * Related Topics Array Dynamic Programming Matrix 👍 4837 👎 87
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution174 {
    /**
     * We know that we would require at-latest 1 health to go from a cell to another cell, which means the value in the cell must be greater than 1
     * to be alive.
     *
     * Keeping this in mind at each cell we should calculate what is the minimum energy that is required to a cell to enter the current cell.
     *
     * Lets consider the last cell of dungeon, if it positive which means we just need 1 minimum health for our knight to enter that cell.
     * If it is -ve we would require x+(value in the last cell)=1
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dungeon[i][j] = dungeon[i][j] < 0 ? Math.abs(dungeon[i][j]) + 1 : 1;
                    continue;
                }

                int right = Integer.MAX_VALUE;
                int bottom = Integer.MAX_VALUE;

                if (j + 1 < n) {
                    right = dungeon[i][j + 1] - dungeon[i][j];
                    if (right <= 0) right = 1;
                }
                if (i + 1 < m) {
                    bottom = dungeon[i + 1][j] - dungeon[i][j];
                    if (bottom <= 0) bottom = 1;
                }
                dungeon[i][j] = Math.min(right, bottom);
            }

        }
        System.out.println(Arrays.deepToString(dungeon));
        return dungeon[0][0];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
