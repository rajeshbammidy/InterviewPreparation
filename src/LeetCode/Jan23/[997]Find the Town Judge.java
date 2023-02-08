package LeetCode.Jan23;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of
 * these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 *
 *
 * You are given an array trust where trust[i] = [ai, bi] representing that the
 * person labeled ai trusts the person labeled bi.
 *
 * Return the label of the town judge if the town judge exists and can be
 * identified, or return -1 otherwise.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 2, trust = [[1,2]]
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: n = 3, trust = [[1,3],[2,3]]
 * Output: 3
 *
 *
 * Example 3:
 *
 *
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 1000
 * 0 <= trust.length <= 10⁴
 * trust[i].length == 2
 * All the pairs of trust are unique.
 * ai != bi
 * 1 <= ai, bi <= n
 *
 *
 * Related Topics Array Hash Table Graph 👍 5045 👎 402
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution997 {
    public int findJudge(int n, int[][] trust) {
        if(trust.length==0 && n==1)return 1;
        if(trust.length==0)return -1;
        HashMap<Integer, Integer> keyMap = new HashMap();
        HashMap<Integer, Integer> valueMap = new HashMap();
        for (int i = 0; i < trust.length; i++) {
            keyMap.put(trust[i][0], keyMap.getOrDefault(trust[i][0], 0) + 1);
            valueMap.put(trust[i][1], valueMap.getOrDefault(trust[i][1], 0) + 1);
        }
        for (int i = 1; i <= n; i++) {
            if (valueMap.containsKey(i) && (valueMap.get(i) == n - 1) && !keyMap.containsKey(i)) return i;
        }
        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
