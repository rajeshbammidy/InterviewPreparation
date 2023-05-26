package TopicWiseSolutions.Math_II;

public class ComputenCr {
    public int solve(int a, int b, int c) {
        int dp[] = new int[b + 1];
        dp[0] = 1;
        for (int i = 1; i <= a; i++) {
            for (int j = Math.min(i, b); j > 0; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % c;
            }
        }
        return dp[b];

    }
}
