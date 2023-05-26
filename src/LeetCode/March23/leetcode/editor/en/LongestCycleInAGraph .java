package LeetCode.FEB23.leetcode.editor.en;

/**
 * You are given a directed graph of n nodes numbered from 0 to n - 1, where each
 * node has at most one outgoing edge.
 *
 * The graph is represented with a given 0-indexed array edges of size n,
 * indicating that there is a directed edge from node i to node edges[i]. If there is no
 * outgoing edge from node i, then edges[i] == -1.
 *
 * Return the length of the longest cycle in the graph. If no cycle exists,
 * return -1.
 *
 * A cycle is a path that starts and ends at the same node.
 *
 *
 * Example 1:
 *
 *
 * Input: edges = [3,3,4,2,3]
 * Output: 3
 * Explanation: The longest cycle in the graph is the cycle: 2 -> 4 -> 3 -> 2.
 * The length of this cycle is 3, so 3 is returned.
 *
 *
 * Example 2:
 *
 *
 * Input: edges = [2,-1,3,1]
 * Output: -1
 * Explanation: There are no cycles in this graph.
 *
 *
 *
 * Constraints:
 *
 *
 * n == edges.length
 * 2 <= n <= 10⁵
 * -1 <= edges[i] < n
 * edges[i] != i
 *
 *
 * Related Topics Depth-First Search Graph Topological Sort 👍 1746 👎 34
 */

import java.util.*;

class LongestCycleInAGraph {
    public static void main(String args[]) {
        Solution solution = new LongestCycleInAGraph().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans;

        public int longestCycle(int[] edges) {
            int n = edges.length;
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < edges.length; i++) {
                if(edges[i]!=-1)
                graph.get(i).add(edges[i]);
            }
            HashSet<Integer> set = new HashSet<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            ans = -1;
            for (int i = 0; i < n; i++) {
                if (!set.contains(i)) {
                    map = new HashMap<>();
                    dfs(i, set, graph, map, 1);
                }
            }
            return ans;
        }

        private void dfs(int src, HashSet<Integer> set, ArrayList<ArrayList<Integer>> graph, HashMap<Integer, Integer> map, int start) {
            set.add(src);
            map.put(src, start);


            for (int v : graph.get(src)) {
                if (!set.contains(v)) {
                    dfs(v, set, graph, map, start + 1);
                } else {
                    if (map.get(v) != null) {
                        ans = Math.max(ans, start - map.get(v) + 1);
                    }
                }
            }
            map.remove(src);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
