package LeetCode.Oct22;//Given an integer array nums and an integer k, return true if nums has a
//continuous subarray of size at least two whose elements sum up to a multiple of k, or 
//false otherwise. 
//
// An integer x is a multiple of k if there exists an integer n such that x = n 
//* k. 0 is always a multiple of k. 
//
// 
// Example 1: 
//
// 
//Input: nums = [23,2,4,6,7], k = 6
//Output: true
//Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up 
//to 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [23,2,6,4,7], k = 6
//Output: true
//Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose 
//elements sum up to 42.
//42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
// 
//
// Example 3: 
//
// 
//Input: nums = [23,2,6,4,7], k = 13
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= sum(nums[i]) <= 2³¹ - 1 
// 1 <= k <= 2³¹ - 1 
// 
//
// Related Topics Array Hash Table TopicWiseSolutions.Strings.Math Prefix Sum 👍 3832 👎 379


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 1) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            int mod = sum % k;
            if (map.containsKey(mod)) {
                if (i - map.get(mod) >= 2)
                    return true;
            } else
                map.put(mod, i);
        }

        return false;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
