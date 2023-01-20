package LeetCode.Graphs.leetcode.editor.en.union_find;

import java.util.ArrayList;

/**
 * In this problem, a tree is an undirected graph that is connected and has no
 * cycles.
 *
 * You are given a graph that started as a tree with n nodes labeled from 1 to n,
 * with one additional edge added. The added edge has two different vertices
 * chosen from 1 to n, and was not an edge that already existed. The graph is
 * represented as an array edges of length n where edges[i] = [ai, bi] indicates that there
 * is an edge between nodes ai and bi in the graph.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of n
 * nodes. If there are multiple answers, return the answer that occurs last in the
 * input.
 *
 *
 * Example 1:
 *
 *
 * Input: edges = [[1,2],[1,3],[2,3]]
 * Output: [2,3]
 *
 *
 * Example 2:
 *
 *
 * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
 * Output: [1,4]
 *
 *
 *
 * Constraints:
 *
 *
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ai < bi <= edges.length
 * ai != bi
 * There are no repeated edges.
 * The given graph is connected.
 *
 *
 * Related Topics Depth-First Search Breadth-First Search Union Find Graph 👍 4890
 * 👎 336
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution684 {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

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

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        parent = new int[n];
        height = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Node node = null;
        for (int i = 0; i < edges.length; i++) {

            int x_rep = find(edges[i][0]);
            int y_rep = find(edges[i][1]);
            if (x_rep == y_rep) {
                node = new Node(edges[i][0], edges[i][1]);
            } else {
                union(edges[i][0], edges[i][1]);
            }
        }
        int ans[] = new int[]{node.x, node.y};
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
