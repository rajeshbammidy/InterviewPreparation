package LeetCode.MonthlyChallenges_22.Oct22;//You want to schedule a list of jobs in d days. Jobs are dependent (i.e To
//work on the iᵗʰ job, you have to finish all the jobs j where 0 <= j < i). 
//
// You have to finish at least one task every day. The difficulty of a job 
//schedule is the sum of difficulties of each day of the d days. The difficulty of a 
//day is the maximum difficulty of a job done on that day. 
//
// You are given an integer array jobDifficulty and an integer d. The 
//difficulty of the iᵗʰ job is jobDifficulty[i]. 
//
// Return the minimum difficulty of a job schedule. If you cannot find a 
//schedule for the jobs return -1. 
//
// 
// Example 1: 
// 
// 
//Input: jobDifficulty = [6,5,4,3,2,1], d = 2
//Output: 7
//Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
//Second day you can finish the last job, total difficulty = 1.
//The difficulty of the schedule = 6 + 1 = 7 
// 
//
// Example 2: 
//
// 
//Input: jobDifficulty = [9,9,9], d = 4
//Output: -1
//Explanation: If you finish a job per day you will still have a free day. you 
//cannot find a schedule for the given jobs.
// 
//
// Example 3: 
//
// 
//Input: jobDifficulty = [1,1,1], d = 3
//Output: 3
//Explanation: The schedule is one job per day. total difficulty will be 3.
// 
//
// 
// Constraints: 
//
// 
// 1 <= jobDifficulty.length <= 300 
// 0 <= jobDifficulty[i] <= 1000 
// 1 <= d <= 10 
// 
//
// Related Topics Array Dynamic Programming 👍 2181 👎 210


//leetcode submit region begin(Prohibit modification and deletion)
class Solution1355 {
    int n;
    Integer dp[][];

    public int minDifficulty(int[] jobDifficulty, int d) {

        n = jobDifficulty.length;
        dp = new Integer[n][d + 1];
        if (n < d) return -1;

        return helper(0, jobDifficulty, d);
    }

    private int helper(int start, int[] jobDifficulty, int d) {
        if (start == n && d == 0) return 0;
        if (n - start < d) return Integer.MAX_VALUE;
        if (d == 0) return Integer.MAX_VALUE;

        if (dp[start][d] != null) return dp[start][d];
        long max = 0;
        long ans = Integer.MAX_VALUE;

        for (int j = start; j < n; j++) {

            max = Math.max(max, jobDifficulty[j]);
            ans = Math.min(ans, max + helper(j + 1, jobDifficulty, d - 1));
        }
        dp[start][d] = (int) (ans);

        return (int) (ans);

    }


}
//leetcode submit region end(Prohibit modification and deletion)
