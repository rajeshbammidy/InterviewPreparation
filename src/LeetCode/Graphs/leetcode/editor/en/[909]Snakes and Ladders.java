package LeetCode.Graphs.leetcode.editor.en;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an n x n integer matrix board where the cells are labeled from 1
 * to n² in a Boustrophedon style starting from the bottom left of the board (i.e.
 * board[n - 1][0]) and alternating direction each row.
 *
 * You start on square 1 of the board. In each move, starting from square curr,
 * do the following:
 *
 *
 * Choose a destination square next with a label in the range [curr + 1, min(curr
 * + 6, n²)].
 *
 *
 *
 * This choice simulates the result of a standard 6-sided die roll: i.e., there
 * are always at most 6 destinations, regardless of the size of the board.
 *
 *
 * If next has a snake or ladder, you must move to the destination of that snake
 * or ladder. Otherwise, you move to next.
 * The game ends when you reach the square n².
 *
 *
 * A board square on row r and column c has a snake or ladder if board[r][c] != -1
 * . The destination of that snake or ladder is board[r][c]. Squares 1 and n² do
 * not have a snake or ladder.
 *
 * Note that you only take a snake or ladder at most once per move. If the
 * destination to a snake or ladder is the start of another snake or ladder, you do not
 * follow the subsequent snake or ladder.
 *
 *
 * For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your
 * destination square is 2. You follow the ladder to square 3, but do not follow
 * the subsequent ladder to 4.
 *
 *
 * Return the least number of moves required to reach the square n². If it is not
 * possible to reach the square, return -1.
 *
 *
 * Example 1:
 *
 *
 * Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,
 * 35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
 * Output: 4
 * Explanation:
 * In the beginning, you start at square 1 (at row 5, column 0).
 * You decide to move to square 2 and must take the ladder to square 15.
 * You then decide to move to square 17 and must take the snake to square 13.
 * You then decide to move to square 14 and must take the ladder to square 35.
 * You then decide to move to square 36, ending the game.
 * This is the lowest possible number of moves to reach the last square, so return
 * 4.
 *
 *
 * Example 2:
 *
 *
 * Input: board = [[-1,-1],[-1,3]]
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *
 * n == board.length == board[i].length
 * 2 <= n <= 20
 * grid[i][j] is either -1 or in the range [1, n²].
 * The squares labeled 1 and n² do not have any ladders or snakes.
 *
 *
 * Related Topics Array Breadth-First Search Matrix 👍 2019 👎 568
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution909 {
    private static int n;

    public int snakesAndLadders(int[][] board) {
        n = board.length;
        /**
         * Flip the board wrt rows,for easier element access;
         */
        for (int i = 0; i <= Math.floor(n / 2) - 1; i++) {
            int temp[] = board[i];
            board[i] = board[n - i - 1];
            board[n - i - 1] = temp;
        }

        HashSet<Integer> set = new HashSet<>();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(1, 0));
        set.add(1);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int parentKey = (int) pair.getKey();
            int parentCost = (int) pair.getValue();
            for (int i = parentKey + 1; i <= parentKey + 6; i++) {
                if (i > n * n) {
                    continue;
                }
                int nextElement = getNextElement(i, board);
                /**
                 * If the nextElement coordinates  has -1, it must not have a ladder or snake therefore assign the value i
                 */
                if (nextElement == -1) {
                    nextElement = i;
                }
                if (nextElement == n * n) {
                    return parentCost + 1;
                }
                if (!set.contains(nextElement)) {
                    set.add(nextElement);
                    queue.add(new Pair<Integer, Integer>(nextElement, parentCost + 1));
                }

            }
        }
        return -1;
    }

    /**
     * Given the key say 2, get its coordinates to check if the coordinates has a ladder or snake.
     */
    private int getNextElement(int key, int[][] board) {
        //Gives you the row of the key
        int row = (key - 1) / n;
        //Gives you the col of the key
        int col = (key - 1) % n;
        //Since the board is in spiral format, we have to add this tweak;
        if ((row & 1) != 0) {
            col = (n - 1 - col);
        }
        return board[row][col];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
