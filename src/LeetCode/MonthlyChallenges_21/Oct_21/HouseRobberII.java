package LeetCode.MonthlyChallenges_21.Oct_21;

import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|LeetCode.Oct_LeetCode|HouseRobberII| on Oct,2020
 *  
 * Happy Coding :)
 **/
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(findAns(0, nums.length - 1, nums), findAns(1, nums.length - 1, nums));


    }

    private int findAns(int i, int n, int[] nums) {
        int dp[] = new int[n + 1];
        dp[i] = nums[i];
        dp[i + 1] = Math.max(nums[i], nums[i + 1]);
        for (int j = i + 2; j < n + 1; j++) {
            dp[j] = Math.max(dp[j - 1], dp[j - 2] + nums[j]);
        }
        System.out.println(Arrays.toString(dp));
        return i == 0 ? dp[n - 1] : dp[n];
    }

}
