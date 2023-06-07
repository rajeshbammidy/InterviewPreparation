package LeetCode.FEB23.leetcode.editor.en;

/**
 * You are given a list of bombs. The range of a bomb is defined as the area where
 * its effect can be felt. This area is in the shape of a circle with the center
 * as the location of the bomb.
 *
 * The bombs are represented by a 0-indexed 2D integer array bombs where bombs[i]
 * = [xi, yi, ri]. xi and yi denote the X-coordinate and Y-coordinate of the
 * location of the iᵗʰ bomb, whereas ri denotes the radius of its range.
 *
 * You may choose to detonate a single bomb. When a bomb is detonated, it will
 * detonate all bombs that lie in its range. These bombs will further detonate the
 * bombs that lie in their ranges.
 *
 * Given the list of bombs, return the maximum number of bombs that can be
 * detonated if you are allowed to detonate only one bomb.
 *
 *
 * Example 1:
 *
 *
 * Input: bombs = [[2,1,3],[6,1,4]]
 * Output: 2
 * Explanation:
 * The above figure shows the positions and ranges of the 2 bombs.
 * If we detonate the left bomb, the right bomb will not be affected.
 * But if we detonate the right bomb, both bombs will be detonated.
 * So the maximum bombs that can be detonated is max(1, 2) = 2.
 *
 *
 * Example 2:
 *
 *
 * Input: bombs = [[1,1,5],[10,10,5]]
 * Output: 1
 * Explanation:
 * Detonating either bomb will not detonate the other bomb, so the maximum number
 * of bombs that can be detonated is 1.
 *
 *
 * Example 3:
 *
 *
 * Input: bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
 * Output: 5
 * Explanation:
 * The best bomb to detonate is bomb 0 because:
 * - Bomb 0 detonates bombs 1 and 2. The red circle denotes the range of bomb 0.
 * - Bomb 2 detonates bomb 3. The blue circle denotes the range of bomb 2.
 * - Bomb 3 detonates bomb 4. The green circle denotes the range of bomb 3.
 * Thus all 5 bombs are detonated.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= bombs.length <= 100
 * bombs[i].length == 3
 * 1 <= xi, yi, ri <= 10⁵
 *
 *
 * Related Topics Array Math Depth-First Search Breadth-First Search Graph
 * Geometry 👍 1382 👎 89
 */

import javafx.util.Pair;

import java.util.*;

class DetonateTheMaximumBombs {
    public static void main(String args[]) {
        Solution solution = new DetonateTheMaximumBombs().new Solution();
        solution.maximumDetonation(new int[][]{{1, 1, 5}, {10, 10, 5}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }

    class Solution {

        public int maximumDetonation(int[][] bombs) {
            int max = 1;
            int m = bombs.length;
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                graph.add(new ArrayList<>());
                for (int j = 0; j < m; j++) {
                    if (i != j) {
                        if (isInsideRadius(new Pair<>(new Node(bombs[i][0], bombs[i][1]), bombs[i][2]), bombs[j])) {
                            graph.get(i).add(j);
                        }
                    }
                }

            }

            System.out.println(graph);
            for (int i = 0; i < m; i++) {
                HashSet<Integer> visited = new HashSet<>();
                dfs(i, visited, graph);
                max = Math.max(max, visited.size());

            }
            return max;

        }

        private void dfs(int index, HashSet<Integer> visited, List<List<Integer>> graph) {
            visited.add(index);
            for (int x : graph.get(index)) {
                if (!visited.contains(x)) {
                    dfs(x, visited, graph);
                }
            }
        }

        private boolean isInsideRadius(Pair<Node, Integer> pair, int[] bomb) {
            Node parentCords = pair.getKey();
            int parentRadius = pair.getValue();
            return ((long) parentRadius * parentRadius) >= ((long) (bomb[0] - parentCords.x) * (bomb[0] - parentCords.x)) + ((long) (bomb[1] - parentCords.y) * (bomb[1] - parentCords.y));

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
