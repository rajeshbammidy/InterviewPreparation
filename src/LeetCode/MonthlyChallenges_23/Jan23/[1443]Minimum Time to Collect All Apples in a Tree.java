package LeetCode.MonthlyChallenges_23.Jan23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given an undirected tree consisting of n vertices numbered from 0 to n-1, which
 * has some apples in their vertices. You spend 1 second to walk over one edge of
 * the tree. Return the minimum time in seconds you have to spend to collect all
 * apples in the tree, starting at vertex 0 and coming back to this vertex.
 *
 * The edges of the undirected tree are given in the array edges, where edges[i] =
 * [ai, bi] means that exists an edge connecting the vertices ai and bi.
 * Additionally, there is a boolean array hasApple, where hasApple[i] = true means that
 * vertex i has an apple; otherwise, it does not have any apple.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,
 * false,true,false,true,true,false]
 * Output: 8
 * Explanation: The figure above represents the given tree where red vertices have
 * an apple. One optimal path to collect all apples is shown by the green arrows.
 *
 *
 *
 * Example 2:
 *
 *
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,
 * false,true,false,false,true,false]
 * Output: 6
 * Explanation: The figure above represents the given tree where red vertices have
 * an apple. One optimal path to collect all apples is shown by the green arrows.
 *
 *
 *
 * Example 3:
 *
 *
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,
 * false,false,false,false,false,false]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 10⁵
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai < bi <= n - 1
 * fromi < toi
 * hasApple.length == n
 *
 *
 * Related Topics Hash Table Tree Depth-First Search Breadth-First Search 👍 3004
 * 👎 247
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1443 {
    /**
     * Added +2 for the nodes with the apple, the following is the breakdown of +2
     * 1 - for visiting the node
     * 1 - for leaving the node
     *
     * For every root r which is not root, we will add +2 (its contribution) only when if it left subtree or its right subtree has apple
     */
    private static HashSet<Integer> visited;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        /**
         * its a undirected graph so we have to add [u,v] and [v,u]
         */
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += getMinTime(graph, 0, hasApple);
        }
        return ans;


    }

    private int getMinTime(ArrayList<ArrayList<Integer>> graph, int src, List<Boolean> hasApple) {


        int total = 0;
        visited.add(src);
        for (int v : graph.get(src)) {
            if (!visited.contains(v))
                total += getMinTime(graph, v, hasApple);
        }
        /**
         * We should not +2 for root node since we start from there
         */
        if (src != 0 && (hasApple.get(src) || total > 0)) {
            total += 2;
        }
        return total;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
