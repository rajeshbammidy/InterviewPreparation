package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongestCommonSubsequence {
    static int lcs(String a, String b) {
        int dp[][] = new int[a.length() + 1][b.length() + 1];
        int m = dp.length;
        int n = dp[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[m - 1][n - 1];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            String is[] = bf.readLine().split("\\s");
            String a = bf.readLine();
            String b = bf.readLine();
            System.out.println(lcs(a, b));
        }

    }
}
