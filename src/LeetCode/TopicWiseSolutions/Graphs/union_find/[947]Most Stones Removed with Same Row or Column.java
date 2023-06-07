package LeetCode.TopicWiseSolutions.Graphs.union_find;

import java.util.HashSet;

/**
 * On a 2D plane, we place n stones at some integer coordinate points. Each
 * coordinate point may have at most one stone.
 *
 * A stone can be removed if it shares either the same row or the same column as
 * another stone that has not been removed.
 *
 * Given an array stones of length n where stones[i] = [xi, yi] represents the
 * location of the iᵗʰ stone, return the largest possible number of stones that can
 * be removed.
 *
 *
 * Example 1:
 *
 *
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * Output: 5
 * Explanation: One way to remove 5 stones is as follows:
 * 1. Remove stone [2,2] because it shares the same row as [2,1].
 * 2. Remove stone [2,1] because it shares the same column as [0,1].
 * 3. Remove stone [1,2] because it shares the same row as [1,0].
 * 4. Remove stone [1,0] because it shares the same column as [0,0].
 * 5. Remove stone [0,1] because it shares the same row as [0,0].
 * Stone [0,0] cannot be removed since it does not share a row/column with another
 * stone still on the plane.
 *
 *
 * Example 2:
 *
 *
 * Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * Output: 3
 * Explanation: One way to make 3 moves is as follows:
 * 1. Remove stone [2,2] because it shares the same row as [2,0].
 * 2. Remove stone [2,0] because it shares the same column as [0,0].
 * 3. Remove stone [0,2] because it shares the same row as [0,0].
 * Stones [0,0] and [1,1] cannot be removed since they do not share a row/column
 * with another stone still on the plane.
 *
 *
 * Example 3:
 *
 *
 * Input: stones = [[0,0]]
 * Output: 0
 * Explanation: [0,0] is the only stone on the plane, so you cannot remove it.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= stones.length <= 1000
 * 0 <= xi, yi <= 10⁴
 * No two stones are at the same coordinate point.
 *
 *
 * Related Topics Depth-First Search Union Find Graph 👍 4418 👎 601
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution947 {
    /**
     * Idea:
     * Find all the elements that belongs to the group ie.. all the elements in the group should
     * match with other element x or y value.
     * We can do the above by doing a dfs, which will help us find all the possible pairs
     * which have identical x or y values.
     *
     * Once the groups are formed we cant delete the  group head,except that we can delete the rest of the element
     */

    HashSet<Integer> visited;

    public int removeStones(int[][] stones) {
        int m = stones.length;
        visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!visited.contains(i)) {
                dfs(stones, i, stones[i][0], stones[i][1]);
                count++;
            }

        }
        return m - count;


    }

    private void dfs(int[][] stones, int i, int x, int y) {
        visited.add(i);
        for (int j = 0; j < stones.length; j++) {
            if (!visited.contains(j) && (stones[j][0] == x || stones[j][1] == y)) {
                dfs(stones, j, stones[j][0], stones[j][1]);
            }

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
