package LeetCode.FEB23.leetcode.editor.en;

/**
 * There is a directed graph of n colored nodes and m edges. The nodes are
 * numbered from 0 to n - 1.
 *
 * You are given a string colors where colors[i] is a lowercase English letter
 * representing the color of the iᵗʰ node in this graph (0-indexed). You are also
 * given a 2D array edges where edges[j] = [aj, bj] indicates that there is a directed
 * edge from node aj to node bj.
 *
 * A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk
 * such that there is a directed edge from xi to xi+1 for every 1 <= i < k. The
 * color value of the path is the number of nodes that are colored the most frequently
 * occurring color along that path.
 *
 * Return the largest color value of any valid path in the given graph, or -1 if
 * the graph contains a cycle.
 *
 *
 * Example 1:
 *
 *
 *
 *
 * Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
 * Output: 3
 * Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a" (
 * red in the above image).
 *
 *
 * Example 2:
 *
 *
 *
 *
 * Input: colors = "a", edges = [[0,0]]
 * Output: -1
 * Explanation: There is a cycle from 0 to 0.
 *
 *
 *
 * Constraints:
 *
 *
 * n == colors.length
 * m == edges.length
 * 1 <= n <= 10⁵
 * 0 <= m <= 10⁵
 * colors consists of lowercase English letters.
 * 0 <= aj, bj < n
 *
 *
 * Related Topics Hash Table Dynamic Programming Graph Topological Sort
 * Memoization Counting 👍 1458 👎 49
 */

import java.awt.image.ImageProducer;
import java.util.*;

class LargestColorValueInADirectedGraph {
    public static void main(String args[]) {
        Solution solution = new LargestColorValueInADirectedGraph().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestPathValue(String colors, int[][] edges) {
            int n = colors.length();
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<Integer>());
                map.put(i, 0);
            }


            for (int x[] : edges) {
                list.get(x[0]).add(x[1]);
                map.put(x[1], map.get(x[1]) + 1);
            }

            //Checking for cycle
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!set.contains(i)) {
                    HashSet<Integer> parent = new HashSet<>();
                    parent.add(-1);
                    boolean cycleExists = checkForCycle(i, list, set, parent);
                    if (cycleExists) return -1;
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            return 0;

        }

        private boolean checkForCycle(int u, ArrayList<ArrayList<Integer>> list, HashSet<Integer> set, HashSet<Integer> parent) {

            set.add(u);
            parent.add(u);
            for (int v : list.get(u)) {
                if (!set.contains(v)) {
                    if (checkForCycle(v, list, set, parent)) {
                        return true;
                    }
                } else {
                    if (parent.contains(v)) return true;
                }
            }
            parent.remove(u);
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
