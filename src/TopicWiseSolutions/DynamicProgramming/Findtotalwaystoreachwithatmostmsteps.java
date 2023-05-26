package TopicWiseSolutions.DynamicProgramming;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.DynamicProgramming|Findtotalwaystoreachwithatmostmsteps| on Sep,2020
 *  
 * Happy Coding :)
 * <p>
 * Find total ways to reach the n’th stair with at-most m steps
 * Given a staircase, find total number of ways to reach the n’th stair from bottom of the stair when a person is only allowed to take at-most m steps at a time.
 * <p>
 * <p>
 * <p>
 * <p>
 * For example,
 * <p>
 * <p>
 * Input: n = 3, m = 2
 * Output: Total ways to reach the 3’rd stair with at-most 2 steps are 3
 * <p>
 * 1 step  + 1 step  + 1 step
 * 1 step  + 2 steps
 * 2 steps + 1 step
 * <p>
 * <p>
 * Input: n = 4, m = 3
 * Output: Total ways to reach the 4’th stair with at-most 3 steps are 7
 * <p>
 * 1 step  + 1 step  + 1 step  + 1 steps
 * 1 step  + 1 step  + 2 steps
 * 1 step  + 2 steps + 1 step
 * 1 step  + 3 steps
 * 2 steps + 1 step  + 1 step
 * 2 steps + 2 steps
 * 3 steps + 1 step
 **/
public class Findtotalwaystoreachwithatmostmsteps {
    public static int totalWays(int n, int m) {
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 2;
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {

            for (int j = 1; j <= m && (i - j) >= 0; j++) {
                dp[i] += dp[i - j];
            }

        }
        return dp[n];


    }
}
