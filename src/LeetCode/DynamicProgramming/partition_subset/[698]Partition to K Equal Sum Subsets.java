package LeetCode.DynamicProgramming.partition_subset;

import java.util.*;

class Solution698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int i : nums) sum += i;
        /**
         * If the sum is not divided by k, we cannot divide the array into k subsets
         */
        if (sum % k != 0) return false;
        /**
         * We are sorting the array to get rid of the duplicates
         */
        Arrays.sort(nums);

        return dfs(nums, new boolean[nums.length], k, 0, sum / k, 0);
    }

    private boolean dfs(int[] nums, boolean[] visited, int k, int currentSum, int targetSum, int position) {
        // if k is 0, for sure nothing will be left unvisited! this is conclusion from simple math.
        if (k == 0) return true;

        // begin next sum search. Critical point: start search from nums.length - 1, not position!!!
        if (currentSum == targetSum) return dfs(nums, visited, k - 1, 0, targetSum, 0);

        for (int i = position; i < nums.length; i++) {
            // Skip logic 1:
            // Of course you cannot visit what's already visited.
            if (visited[i]) continue;
            // Skip logic 2:
            // if the last position (i + 1) is not visited, that means it does not work for current combination,
            // and of course this position (i) has same value, it won't work as well, skip it.
            if (i - 1 >= 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            // Skip logic 3:
            // No need to explain, just out of range case.
            if (currentSum + nums[i] > targetSum) continue;

            // simple recursion and backtracking
            visited[i] = true;
            if (dfs(nums, visited, k, currentSum + nums[i], targetSum, i + 1)) return true;
            visited[i] = false;
        }
        return false;
    }
}