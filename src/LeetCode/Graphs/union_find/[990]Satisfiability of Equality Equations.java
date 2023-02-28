package LeetCode.Graphs.union_find;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * You are given an array of strings equations that represent relationships
 * between variables where each string equations[i] is of length 4 and takes one of two
 * different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not
 * necessarily different) that represent one-letter variable names.
 *
 * Return true if it is possible to assign integers to variable names so as to
 * satisfy all the given equations, or false otherwise.
 *
 *
 * Example 1:
 *
 *
 * Input: equations = ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is
 * satisfied, but not the second.
 * There is no way to assign the variables to satisfy both equations.
 *
 *
 * Example 2:
 *
 *
 * Input: equations = ["b==a","a==b"]
 * Output: true
 * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] is a lowercase letter.
 * equations[i][1] is either '=' or '!'.
 * equations[i][2] is '='.
 * equations[i][3] is a lowercase letter.
 *
 *
 * Related Topics Array String Union Find Graph 👍 3252 👎 48
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution990 {
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

    /**
     * Group all the characters included in the equation (which is having ==) using Disjoint Union
     *
     * Once all the characters are grouped, find the parent of the character in the equation which holds != .
     *
     * if the parents of characters comes out to be equal return false.
     */

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        height = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        HashSet<Character> set = new HashSet<>();
        for (String eq : equations) {
            char ch1 = eq.charAt(0);
            char ch2 = eq.charAt(1);
            char ch3 = eq.charAt(2);
            char ch4 = eq.charAt(3);
            if (ch2 == ch3) {
                union(ch1 - 'a', ch4 - 'a');
            }
        }

        for (String eq : equations) {
            char ch1 = eq.charAt(0);
            char ch2 = eq.charAt(1);
            char ch3 = eq.charAt(2);
            char ch4 = eq.charAt(3);
            if (ch2 != ch3) {
                int x_rep = find(ch1 - 'a');
                int y_rep = find(ch4 - 'a');
                if (x_rep == y_rep) return false;
            }

        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
