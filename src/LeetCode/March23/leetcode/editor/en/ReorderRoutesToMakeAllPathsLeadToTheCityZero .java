package LeetCode.FEB23.leetcode.editor.en;

/**
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is
 * only one way to travel between two different cities (this network form a tree).
 * Last year, The ministry of transport decided to orient the roads in one
 * direction because they are too narrow.
 *
 * Roads are represented by connections where connections[i] = [ai, bi]
 * represents a road from city ai to city bi.
 *
 * This year, there will be a big event in the capital (city 0), and many people
 * want to travel to this city.
 *
 * Your task consists of reorienting some roads such that each city can visit the
 * city 0. Return the minimum number of edges changed.
 *
 * It's guaranteed that each city can reach city 0 after reorder.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * Output: 3
 * Explanation: Change the direction of edges show in red such that each node can
 * reach the node 0 (capital).
 *
 *
 * Example 2:
 *
 *
 * Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * Output: 2
 * Explanation: Change the direction of edges show in red such that each node can
 * reach the node 0 (capital).
 *
 *
 * Example 3:
 *
 *
 * Input: n = 3, connections = [[1,0],[2,0]]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * 2 <= n <= 5 * 10⁴
 * connections.length == n - 1
 * connections[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 *
 *
 * Related Topics Depth-First Search Breadth-First Search Graph 👍 3062 👎 72
 */

import java.util.*;

class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public static void main(String args[]) {
        Solution solution = new ReorderRoutesToMakeAllPathsLeadToTheCityZero().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int minReorder(int n, int[][] connections) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
            }
            for (int x[] : connections) {
                list.get(x[0]).add(x[1]);
            }

            int ans = 0;
            HashSet<Integer> visited = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i)) {

                    int value = dfs(i, list, visited,i);
                    System.out.println(i + " " + value);
                    if (value >0) {
                        ans += (value - 1);
                    }
                }
            }
            return ans;

        }

        private int dfs(int src, ArrayList<ArrayList<Integer>> list, HashSet<Integer> visited,int osrc) {

            if (visited.contains(src)) return -1;
            visited.add(src);
            if (list.get(src).size() == 0) return 1;
            int cnt = 0;
            int nonVisited = -1;
            for (int v : list.get(src)) {
                int value = dfs(v, list, visited,osrc);
                if (value != -1) {
                    nonVisited = 0;
                    cnt += value;
                }
            }
            if(cnt==0 && osrc==src)return 0;
            return nonVisited == 0 ? cnt + 1 : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
