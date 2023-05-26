package TopicWiseSolutions.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Min no of deletions =min no insertions
 */
public class Minimumnumberofdeletioninastringtomakeitapalindrome {
    static int minDeletions(String str) {
        int lcsLen = lps(str);
        return str.length() - lcsLen;
    }

    private static int lps(String str) {
        int dp[][] = new int[str.length()][str.length()];
        int n = dp[0].length;
        int m = dp.length;
        for (int i = 0; i < m; i++) dp[i][i] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m - i; j++) {
                int cl = i + j;
                if (str.charAt(j) == str.charAt(cl)) {
                    dp[j][cl] = 2 + dp[j + 1][cl - 1];
                } else {
                    dp[j][cl] = Math.max(dp[j + 1][cl], dp[j][cl - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {

            System.out.println(minDeletions(bf.readLine()));
        }

    }
}
