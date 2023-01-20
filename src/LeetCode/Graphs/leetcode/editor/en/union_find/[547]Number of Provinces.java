package LeetCode.Graphs.leetcode.editor.en.union_find;

import java.util.ArrayList;
import java.util.List;

/**
 * There are n cities. Some of them are connected, while some are not. If city a
 * is connected directly with city b, and city b is connected directly with city c,
 * then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other
 * cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the iᵗ
 * ʰ city and the jᵗʰ city are directly connected, and isConnected[i][j] = 0
 * otherwise.
 *
 * Return the total number of provinces.
 *
 *
 * Example 1:
 *
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 *
 *
 * Related Topics Depth-First Search Breadth-First Search Union Find Graph 👍 6872
 * 👎 279
 */

//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;

class Solution547 {

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

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        height = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) union(i, j);
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(i));
        }
        return set.size();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
