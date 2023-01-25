package LeetCode.Jan23.leetcode.editor.en;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * You are given a directed graph of n nodes numbered from 0 to n - 1, where each
 * node has at most one outgoing edge.
 *
 * The graph is represented with a given 0-indexed array edges of size n,
 * indicating that there is a directed edge from node i to node edges[i]. If there is no
 * outgoing edge from i, then edges[i] == -1.
 *
 * You are also given two integers node1 and node2.
 *
 * Return the index of the node that can be reached from both node1 and node2,
 * such that the maximum between the distance from node1 to that node, and from node2
 * to that node is minimized. If there are multiple answers, return the node with
 * the smallest index, and if no possible answer exists, return -1.
 *
 * Note that edges may contain cycles.
 *
 *
 * Example 1:
 *
 *
 * Input: edges = [2,2,3,-1], node1 = 0, node2 = 1
 * Output: 2
 * Explanation: The distance from node 0 to node 2 is 1, and the distance from
 * node 1 to node 2 is 1.
 * The maximum of those two distances is 1. It can be proven that we cannot get a
 * node with a smaller maximum distance than 1, so we return node 2.
 *
 *
 * Example 2:
 *
 *
 * Input: edges = [1,2,-1], node1 = 0, node2 = 2
 * Output: 2
 * Explanation: The distance from node 0 to node 2 is 2, and the distance from
 * node 2 to itself is 0.
 * The maximum of those two distances is 2. It can be proven that we cannot get a
 * node with a smaller maximum distance than 2, so we return node 2.
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
 * 0 <= node1, node2 < n
 *
 *
 * Related Topics Depth-First Search Graph 👍 557 👎 127
 */

//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;

class Solution {
    /**
     * Intuition : Since the graph is unweighted we can use BFS/DFS to find the shortest path the start vertex to all
     * other vertices.
     * We have to find the shortest distance from node1 to all other nodes and store it in the node1Dist
     * We have to find the shortest distance from node2 to all other nodes and store it in the node2Dist
     *
     * Once the distances are obtained find the min-max distance from the two given start nodes to all other nodes/vertices
     */
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        long node1Dist[] = new long[n];
        long node2Dist[] = new long[n];
        /**
         * Initialize all values of the array with Integer.MAX_VALUE
         */
        Arrays.fill(node1Dist, Integer.MAX_VALUE);
        Arrays.fill(node2Dist, Integer.MAX_VALUE);
        node1Dist[node1] = 0;
        node2Dist[node2] = 0;
        dfs(node1, node1Dist, edges, 0);
        dfs(node2, node2Dist, edges, 0);
        int minMaxDistance = Integer.MAX_VALUE;
        int index = -1;
        /**
         * Find the min-max distance and its respective index;
         */
        for (int i = 0; i < n; i++) {
            if (node1Dist[i] != Integer.MAX_VALUE && node1Dist[i] != Integer.MAX_VALUE) {
                if (minMaxDistance > Math.max(node1Dist[i], node2Dist[i])) {
                    minMaxDistance = (int) Math.max(node1Dist[i], node2Dist[i]);
                    index = i;
                }
            }
        }
        return index;

    }

    private void dfs(int node1, long nodeDist[], int[] edges, int distance) {
        if (node1 == -1) return;
        int next = edges[node1];
        /**
         * If the vertex doesn't have any neighbour return
         */
        if (next == -1) return;
        /**
         * Relax the vertex if it has more distance than the currentDistance+1
         */
        if (nodeDist[next] > distance + 1) {
            nodeDist[next] = distance + 1;
            dfs(next, nodeDist, edges, distance + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
