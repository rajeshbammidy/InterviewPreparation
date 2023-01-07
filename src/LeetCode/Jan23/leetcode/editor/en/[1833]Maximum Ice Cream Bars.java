package LeetCode.Jan23.leetcode.editor.en;

import java.lang.reflect.Array;

/**
 It is a sweltering summer day, and a boy wants to buy some ice cream bars.

 At the store, there are n ice cream bars. You are given an array costs of 
 length n, where costs[i] is the price of the iᵗʰ ice cream bar in coins. The boy
 initially has coins coins to spend, and he wants to buy as many ice cream bars as
 possible.

 Return the maximum number of ice cream bars the boy can buy with coins coins. 

 Note: The boy can buy the ice cream bars in any order. 


 Example 1: 


 Input: costs = [1,3,2,4,1], coins = 7
 Output: 4
 Explanation: The boy can buy ice cream bars at indices 0,1,2,4 for a total
 price of 1 + 3 + 2 + 1 = 7.


 Example 2: 


 Input: costs = [10,6,8,7,7,8], coins = 5
 Output: 0
 Explanation: The boy cannot afford any of the ice cream bars.


 Example 3: 


 Input: costs = [1,6,3,1,2,5], coins = 20
 Output: 6
 Explanation: The boy can buy all the ice cream bars for a total price of 1 + 6 +
 3 + 1 + 2 + 5 = 18.



 Constraints: 


 costs.length == n 
 1 <= n <= 10⁵ 
 1 <= costs[i] <= 10⁵ 
 1 <= coins <= 10⁸ 


 Related Topics Array Greedy Sorting 👍 843 👎 377

 */

//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;

class Solution1833 {
    public int maxIceCream(int[] costs, int coins) {
        /**
         * Sort the array in ASC order
         */
        Arrays.sort(costs);
        int ans = 0;
        int i = 0;
        while (coins > 0 && i < costs.length) {
            if (coins >= costs[i]) {
                coins -= costs[i];
                i++;
                ans++;
            } else {
                return ans;
            }
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
