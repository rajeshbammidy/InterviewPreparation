
import java.util.*;


public class Test {
    int dp[][];
    boolean[][] result;

    public int minCut(String s) {
        if (s.length() == 0) return 0;
        int n = s.length();
        dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        result = new boolean[n][n];
        for (int i = 0; i < result.length; i++) {
            result[i][i] = true;
        }
        for (int i = 0; i < result.length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                result[i][i + 1] = true;
            }
        }
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j) && result[i + 1][j - 1]) {
                    result[i][j] = true;
                }
            }
        }

        return backtrack(s, 0, s.length() - 1);

    }

    private int backtrack(String s, int i, int j) {
        if (i >= j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (result[i][j]) return 0;


        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int lp = 0, rp = 0;
            if (dp[i][k] != -1) {
                lp = dp[i][k];
            } else {
                lp = backtrack(s, i, k);
            }
            if (dp[k + 1][j] != -1) {
                rp = dp[k + 1][j];
            } else {
                rp = backtrack(s, k + 1, j);
            }
            int ans = lp + rp + 1;
            min = Math.min(min, ans);
        }
        dp[i][j] = min;
        return min;
    }


    public static void main(String[] args) {
        System.out.println(new Test().minCut("coder"));
    }

}