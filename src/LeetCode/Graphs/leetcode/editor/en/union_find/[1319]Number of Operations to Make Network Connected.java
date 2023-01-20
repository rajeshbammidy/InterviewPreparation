package LeetCode.Graphs.leetcode.editor.en.union_find;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables
 * connections forming a network where connections[i] = [ai, bi] represents a
 * connection between computers ai and bi. Any computer can reach any other computer
 * directly or indirectly through the network.
 *
 * You are given an initial computer network connections. You can extract certain
 * cables between two directly connected computers, and place them between any
 * pair of disconnected computers to make them directly connected.
 *
 * Return the minimum number of times you need to do this in order to make all
 * the computers connected. If it is not possible, return -1.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4, connections = [[0,1],[0,2],[1,2]]
 * Output: 1
 * Explanation: Remove cable between computer 1 and 2 and place between computers 1
 * and 3.
 *
 *
 * Example 2:
 *
 *
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * Output: 2
 *
 *
 * Example 3:
 *
 *
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * Output: -1
 * Explanation: There are not enough cables.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 10⁵
 * 1 <= connections.length <= min(n * (n - 1) / 2, 10⁵)
 * connections[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * There are no repeated connections.
 * No two computers are connected by more than one cable.
 *
 *
 * Related Topics Depth-First Search Breadth-First Search Union Find Graph 👍 3024
 * 👎 38
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1319 {
    static int parent[];
    static int height[];

    /**
     * PathCompression
     */
    static int find(int x) {
        if (x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    /**
     * Union By Rank
     */
    static void union(int x, int y) {
        int x_rep = find(x);
        int y_rep = find(y);
        if (x_rep == y_rep) return;
        if (height[x_rep] > height[y_rep]) {
            parent[y_rep] = x_rep;
        } else if (height[x_rep] < height[y_rep]) {
            parent[x_rep] = y_rep;
        } else {
            parent[y_rep] = x_rep;
            height[x_rep]++;
        }

    }

    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        height = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int extras = 0;
        for (int i = 0; i < connections.length; i++) {
            int x_rep = find(connections[i][0]);
            int y_rep = find(connections[i][1]);
            /**
             * If connections[i][0],connections[i][1] are already in the same group, it's an extra edge
             */
            if (x_rep == y_rep) {
                extras++;
                continue;
            }
            /**
             * Otherwise union them to form a group
             */
            union(x_rep, y_rep);
        }

        HashSet<Integer> set = new HashSet<>();
        /**
         * Now, check the number of disconnected groups.
         */
        for (int i = 0; i < n; i++) {
            set.add(find(i));
        }
        /**
         * If there are n disconnected groups, we would need n-1 edges to connect them.
         */
        int disConnectedNodes = set.size() - 1;
        if (extras < disConnectedNodes) return -1;
        return disConnectedNodes;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
