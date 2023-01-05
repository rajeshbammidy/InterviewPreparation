/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find
 * all possible paths from node 0 to node n - 1 and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all nodes you can visit
 * from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 *
 *
 * Example 1:
 *
 *
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 *
 *
 * Example 2:
 *
 *
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 *
 *
 *
 * Constraints:
 *
 *
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i (i.e., there will be no self-loops).
 * All the elements of graph[i] are unique.
 * The input graph is guaranteed to be a DAG.
 *
 *
 * Related Topics Backtracking Depth-First Search Breadth-First Search Graph 👍 59
 * 79 👎 129
 */

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        /**
         * Initialise the result
         */
        result = new ArrayList<>();
        for (int i = 0; i < graph[0].length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            dfs(graph, graph[0][i], list);
        }
        return result;

    }

    private void dfs(int[][] graph, int src, List<Integer> list) {
        list.add(src);
        /**
         * If src == n-1 add the list to the result set
         */
        if (src == graph.length - 1) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (src < graph.length && graph[src].length > 0) {
            for (int i = 0; i < graph[src].length; i++) {
                dfs(graph, graph[src][i], list);
                list.remove(list.size() - 1);

            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
