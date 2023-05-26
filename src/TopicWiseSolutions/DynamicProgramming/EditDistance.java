package TopicWiseSolutions.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EditDistance {
    public static int minEdit(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        int m = dp.length;
        int n = dp[0].length;
        for (int i = 1; i < n; i++) dp[0][i] = i;
        for (int i = 1; i < m; i++) dp[i][0] = i;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m - 1][n - 1];

    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            bf.readLine();


            String iws[] = bf.readLine().split("\\s");

            System.out.println(minEdit(iws[0], iws[1]));
        }

    }
}
