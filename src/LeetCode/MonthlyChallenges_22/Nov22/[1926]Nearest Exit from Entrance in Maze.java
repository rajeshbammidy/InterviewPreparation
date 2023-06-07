package LeetCode.MonthlyChallenges_22.Nov22;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as
 * '.') and walls (represented as '+'). You are also given the entrance of the
 * maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the
 * cell you are initially standing at.
 *
 * In one step, you can move one cell up, down, left, or right. You cannot step
 * into a cell with a wall, and you cannot step outside the maze. Your goal is to
 * find the nearest exit from the entrance. An exit is defined as an empty cell that
 * is at the border of the maze. The entrance does not count as an exit.
 *
 * Return the number of steps in the shortest path from the entrance to the
 * nearest exit, or -1 if no such path exists.
 *
 *
 * Example 1:
 *
 *
 * Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance
 * = [1,2]
 * Output: 1
 * Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
 * Initially, you are at the entrance cell [1,2].
 * - You can reach [1,0] by moving 2 steps left.
 * - You can reach [0,2] by moving 1 step up.
 * It is impossible to reach [2,3] from the entrance.
 * Thus, the nearest exit is [0,2], which is 1 step away.
 *
 *
 * Example 2:
 *
 *
 * Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
 * Output: 2
 * Explanation: There is 1 exit in this maze at [1,2].
 * [1,0] does not count as an exit since it is the entrance cell.
 * Initially, you are at the entrance cell [1,0].
 * - You can reach [1,2] by moving 2 steps right.
 * Thus, the nearest exit is [1,2], which is 2 steps away.
 *
 *
 * Example 3:
 *
 *
 * Input: maze = [[".","+"]], entrance = [0,0]
 * Output: -1
 * Explanation: There are no exits in this maze.
 *
 *
 *
 * Constraints:
 *
 *
 * maze.length == m
 * maze[i].length == n
 * 1 <= m, n <= 100
 * maze[i][j] is either '.' or '+'.
 * entrance.length == 2
 * 0 <= entrancerow < m
 * 0 <= entrancecol < n
 * entrance will always be an empty cell.
 *
 *
 * Related Topics Array Breadth-First Search Matrix 👍 1371 👎 54
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1926 {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Pair> queue = new LinkedList<>();
        //Bottom,top,right,left
        int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Pair start = new Pair(entrance[0], entrance[1]);
        HashSet<String> set = new HashSet<>();
        queue.add(start);
        set.add(start.x + "-" + start.y);
        int count = 0;
        int m = maze.length;
        int n = maze[0].length;
        while (!queue.isEmpty()) {
            int size = queue.size();

            count++;
            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                //bottom
                if (isValid(p.x + dir[0][0], p.y + dir[0][1], m, n) && isEmptyCell(p.x + dir[0][0], p.y + dir[0][1], maze) && !set.contains((p.x + dir[0][0]) + "-" + (p.y + dir[0][1]))) {
                    queue.add(new Pair(p.x + dir[0][0], p.y + dir[0][1]));
                    set.add((p.x + dir[0][0]) + "-" + (p.y + dir[0][1]));
                } else {
                    if (!isValid(p.x + dir[0][0], p.y + dir[0][1], m, n) && p != start) {

                        return count - 1;
                    }
                }

                //top
                if (isValid(p.x + dir[1][0], p.y + dir[1][1], m, n) && isEmptyCell(p.x + dir[1][0], p.y + dir[1][1], maze) && !set.contains((p.x + dir[1][0]) + "-" + (p.y + dir[1][1]))) {
                    queue.add(new Pair(p.x + dir[1][0], p.y + dir[1][1]));
                    set.add((p.x + dir[1][0]) + "-" + (p.y + dir[1][1]));
                } else {
                    if (!isValid(p.x + dir[1][0], p.y + dir[1][1], m, n) && p != start) {

                        return count - 1;
                    }

                }
                //right
                if (isValid(p.x + dir[2][0], p.y + dir[2][1], m, n) && isEmptyCell(p.x + dir[2][0], p.y + dir[2][1], maze) && !set.contains((p.x + dir[2][0]) + "-" + (p.y + dir[2][1]))) {
                    queue.add(new Pair(p.x + dir[2][0], p.y + dir[2][1]));
                    set.add((p.x + dir[2][0]) + "-" + (p.y + dir[2][1]));
                } else {
                    if (!isValid(p.x + dir[2][0], p.y + dir[2][1], m, n) && p != start) {
                        return count - 1;
                    }
                }
//left
                if (isValid(p.x + dir[3][0], p.y + dir[3][1], m, n) && isEmptyCell(p.x + dir[3][0], p.y + dir[3][1], maze) && !set.contains((p.x + dir[3][0]) + "-" + (p.y + dir[3][1]))) {
                    queue.add(new Pair(p.x + dir[3][0], p.y + dir[3][1]));
                    set.add((p.x + dir[3][0]) + "-" + (p.y + dir[3][1]));
                } else {
                    if (!isValid(p.x + dir[3][0], p.y + dir[3][1], m, n) && p != start) {

                        return count - 1;
                    }
                }

            }

        }
        return -1;

    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    private boolean isEmptyCell(int i, int j, char[][] maze) {
        return maze[i][j] == '.';
    }

}
//leetcode submit region end(Prohibit modification and deletion)
