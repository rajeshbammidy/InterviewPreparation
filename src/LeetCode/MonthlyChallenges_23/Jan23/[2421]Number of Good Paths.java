package LeetCode.MonthlyChallenges_23.Jan23;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * There is a tree (i.e. a connected, undirected graph with no cycles) consisting
 * of n nodes numbered from 0 to n - 1 and exactly n - 1 edges.
 *
 * You are given a 0-indexed integer array vals of length n where vals[i] denotes
 * the value of the iᵗʰ node. You are also given a 2D integer array edges where
 * edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes
 * ai and bi.
 *
 * A good path is a simple path that satisfies the following conditions:
 *
 *
 * The starting node and the ending node have the same value.
 * All nodes between the starting node and the ending node have values less than
 * or equal to the starting node (i.e. the starting node's value should be the
 * maximum value along the path).
 *
 *
 * Return the number of distinct good paths.
 *
 * Note that a path and its reverse are counted as the same path. For example, 0 -
 * > 1 is considered to be the same as 1 -> 0. A single node is also considered as
 * a valid path.
 *
 *
 * Example 1:
 *
 *
 * Input: vals = [1,3,2,1,3], edges = [[0,1],[0,2],[2,3],[2,4]]
 * Output: 6
 * Explanation: There are 5 good paths consisting of a single node.
 * There is 1 additional good path: 1 -> 0 -> 2 -> 4.
 * (The reverse path 4 -> 2 -> 0 -> 1 is treated as the same as 1 -> 0 -> 2 -> 4.)
 * Note that 0 -> 2 -> 3 is not a good path because vals[2] > vals[0].
 *
 *
 * Example 2:
 *
 *
 * Input: vals = [1,1,2,2,3], edges = [[0,1],[1,2],[2,3],[2,4]]
 * Output: 7
 * Explanation: There are 5 good paths consisting of a single node.
 * There are 2 additional good paths: 0 -> 1 and 2 -> 3.
 *
 *
 * Example 3:
 *
 *
 * Input: vals = [1], edges = []
 * Output: 1
 * Explanation: The tree consists of only one node, so there is one good path.
 *
 *
 *
 * Constraints:
 *
 *
 * n == vals.length
 * 1 <= n <= 3 * 10⁴
 * 0 <= vals[i] <= 10⁵
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * edges represents a valid tree.
 *
 *
 * Related Topics Array Tree Union Find Graph 👍 1455 👎 75
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2421 {
    static int parent[];
    static int rank[];
    private static List<List<Integer>> adjacencyList;
    private static TreeMap<Integer, ArrayList<Integer>> valueToNodeMap;

    static int find(int i) {
        if (i == parent[i]) return i;
        parent[i] = find(parent[i]);
        return parent[i];
    }

    static void union(int x, int y) {
        int x_rep = find(x);
        int y_rep = find(y);
        if (x_rep == y_rep) return;
        if (rank[x_rep] > rank[y_rep]) {
            parent[y_rep] = x_rep;
        } else if (rank[x_rep] < rank[y_rep]) {
            parent[x_rep] = y_rep;
        } else {
            parent[y_rep] = x_rep;
            rank[x_rep] += 1;
        }
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        adjacencyList = new ArrayList<>();
        valueToNodeMap = new TreeMap<>();
        parent = new int[vals.length];
        rank = new int[vals.length];
        for (int i = 0; i < vals.length; i++) {
            adjacencyList.add(new ArrayList<>());
            parent[i] = i;
            if (valueToNodeMap.get(vals[i]) == null) {
                valueToNodeMap.put(vals[i], new ArrayList<>());
            }
            valueToNodeMap.get(vals[i]).add(i);
        }
        buildGraph(adjacencyList, edges);
        int res = 0;

        for (Map.Entry<Integer, ArrayList<Integer>> entry : valueToNodeMap.entrySet()) {

            for (int nodeValue : entry.getValue()) {
                for (int adjacentNode : adjacencyList.get(nodeValue)) {
                    if (vals[adjacentNode] <= vals[nodeValue]) {
                        union(adjacentNode, nodeValue);
                    }
                }
            }
            int temp[] = new int[vals.length];
            for (int nodeValue : entry.getValue()) {
                int rep = find(nodeValue);
                temp[rep] += 1;
                res += temp[rep];
            }

        }
        return res;


    }

    private void buildGraph(List<List<Integer>> adjacencyList, int[][] edges) {
        for (int edge[] : edges) {
            int p = edge[0];
            int c = edge[1];
            adjacencyList.get(p).add(c);
            adjacencyList.get(c).add(p);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
