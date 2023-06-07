package LeetCode.MonthlyChallenges_23.March23;

/**
 * Alice and Bob have an undirected graph of n nodes and three types of edges:
 *
 *
 * Type 1: Can be traversed by Alice only.
 * Type 2: Can be traversed by Bob only.
 * Type 3: Can be traversed by both Alice and Bob.
 *
 *
 * Given an array edges where edges[i] = [typei, ui, vi] represents a
 * bidirectional edge of type typei between nodes ui and vi, find the maximum number of edges
 * you can remove so that after removing the edges, the graph can still be fully
 * traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob if
 * starting from any node, they can reach all other nodes.
 *
 * Return the maximum number of edges you can remove, or return -1 if Alice and
 * Bob cannot fully traverse the graph.
 *
 *
 * Example 1:
 *
 *
 *
 *
 * Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
 * Output: 2
 * Explanation: If we remove the 2 edges [1,1,2] and [1,1,3]. The graph will still
 * be fully traversable by Alice and Bob. Removing any additional edge will not
 * make it so. So the maximum number of edges we can remove is 2.
 *
 *
 * Example 2:
 *
 *
 *
 *
 * Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
 * Output: 0
 * Explanation: Notice that removing any edge will not make the graph fully
 * traversable by Alice and Bob.
 *
 *
 * Example 3:
 *
 *
 *
 *
 * Input: n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
 * Output: -1
 * Explanation: In the current graph, Alice cannot reach node 4 from the other
 * nodes. Likewise, Bob cannot reach 1. Therefore it's impossible to make the graph
 * fully traversable.
 *
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 10⁵
 * 1 <= edges.length <= min(10⁵, 3 * n * (n - 1) / 2)
 * edges[i].length == 3
 * 1 <= typei <= 3
 * 1 <= ui < vi <= n
 * All tuples (typei, ui, vi) are distinct.
 *
 *
 * Related Topics Union Find Graph 👍 1614 👎 23
 */

import java.util.*;

class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    public static void main(String args[]) {
        Solution solution = new RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int find(int parent[], int x) {
            if (x == parent[x]) return x;
            return find(parent, parent[x]);
        }

        boolean union(int parent[], int height[], int x, int y) {
            int xp = find(parent, x);
            int yp = find(parent, y);
            if (xp == yp) return false;
            if (height[xp] > height[yp]) {
                parent[yp] = xp;
            } else if (height[xp] < height[yp]) {
                parent[xp] = yp;
            } else {
                parent[yp] = xp;
                height[xp]++;
            }
            return true;
        }

        int aliceParent[];
        int aliceHeight[];
        int bobParent[];
        int bobHeight[];

        public int maxNumEdgesToRemove(int n, int[][] edges) {
            Arrays.sort(edges, (int[] o1, int[] o2) -> {
                return -(o1[0] - o2[0]);
            });

            aliceParent = new int[n + 1];
            aliceHeight = new int[n + 1];
            bobParent = new int[n + 1];
            bobHeight = new int[n + 1];
            HashSet<String> aliceNodes = new HashSet<>();
            HashSet<String> bobNodes = new HashSet<>();
            for (int i = 0; i <= n; i++) {
                aliceParent[i] = i;
                aliceHeight[i] = 1;
                bobParent[i] = i;
                bobHeight[i] = 1;
            }
            int aliceCount = 0;
            int bobCount = 0;

            //Alice
            for (int edge[] : edges) {
                if (edge[0] == 3 || edge[0] == 1) {
                    boolean value = union(aliceParent, aliceHeight, edge[1], edge[2]);
                    if (!value) {
                        aliceNodes.add(edge[1] + "-" + edge[2] + "-" + edge[0]);
                    }
                }
            }
            int sameParent = 0;
            System.out.println(Arrays.toString(aliceParent));
            for (int i = 1; i <= n; i++) {
                if (aliceParent[i] == i) sameParent++;
                if (sameParent > 1) return -1;
            }
            //Alice
            for (int edge[] : edges) {
                if (edge[0] == 3 || edge[0] == 2) {
                    boolean value = union(bobParent, bobHeight, edge[1], edge[2]);
                    if (!value) {
                        bobNodes.add(edge[1] + "-" + edge[2] + "-" + edge[0]);
                    }
                }
            }
            sameParent = 0;
            for (int i = 1; i <= n; i++) {
                if (bobParent[i] == i) sameParent++;
                if (sameParent > 1) return -1;
            }
            for (String x : bobNodes) {
                aliceNodes.add(x);
            }
            return aliceNodes.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
