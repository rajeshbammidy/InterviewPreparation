package LeetCode.Jan23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * You are given a tree (i.e. a connected, undirected graph that has no cycles)
 * rooted at node 0 consisting of n nodes numbered from 0 to n - 1. The tree is
 * represented by a 0-indexed array parent of size n, where parent[i] is the parent of
 * node i. Since node 0 is the root, parent[0] == -1.
 *
 * You are also given a string s of length n, where s[i] is the character
 * assigned to node i.
 *
 * Return the length of the longest path in the tree such that no pair of
 * adjacent nodes on the path have the same character assigned to them.
 *
 *
 * Example 1:
 *
 *
 * Input: parent = [-1,0,0,1,1,2], s = "abacbe"
 * Output: 3
 * Explanation: The longest path where each two adjacent nodes have different
 * characters in the tree is the path: 0 -> 1 -> 3. The length of this path is 3, so 3
 * is returned.
 * It can be proven that there is no longer path that satisfies the conditions.
 *
 *
 * Example 2:
 *
 *
 * Input: parent = [-1,0,0,0], s = "aabc"
 * Output: 3
 * Explanation: The longest path where each two adjacent nodes have different
 * characters is the path: 2 -> 0 -> 3. The length of this path is 3, so 3 is returned.
 *
 *
 *
 * Constraints:
 *
 *
 * n == parent.length == s.length
 * 1 <= n <= 10⁵
 * 0 <= parent[i] <= n - 1 for all i >= 1
 * parent[0] == -1
 * parent represents a valid tree.
 * s consists of only lowercase English letters.
 *
 *
 * Related Topics Array String Tree Depth-First Search Graph Topological Sort 👍 1
 * 814 👎 45
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static List<List<Integer>> list;
    static HashSet<Integer> set;
    int maxPathLength;

    public int longestPath(int[] parent, String s) {
        list = new ArrayList<>();
        set = new HashSet<>();
        int n = parent.length;
        maxPathLength = 1;
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        buildAdjacencyList(n, parent);
        System.out.println(list);
        traverseForPath(0, list, s);
        return maxPathLength;
    }

    private String traverseForPath(int src, List<List<Integer>> list, String str) {
        set.add(src);
        if (list.get(src).size() == 0) {
            return "" + str.charAt(src);
        }
        String temp = "";
        char currentChar = str.charAt(src);
        for (int v : list.get(src)) {
            if (set.contains(v)) continue;
            String childString = traverseForPath(v, list, str);
            if (childString.length()>0 && childString.charAt(childString.length() - 1) != currentChar && temp.length() < childString.length()) {
                temp = childString + currentChar;
            }
        }
        if (temp.length() > 0)
            maxPathLength = Math.max(maxPathLength, (temp + currentChar).length());
        return temp;


    }

    private void buildAdjacencyList(int length, int[] parent) {
        for (int i = 1; i < length; i++) {
            int p = parent[i];
            int c = i;
            list.get(p).add(c);
            list.get(c).add(p);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
