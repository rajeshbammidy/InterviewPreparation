package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|DynamicProgramming|LongestPalindromicSubsequence| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class LongestPalindromicSubsequence {


    public int solve(String a) {
        int dp[][] = new int[a.length() + 1][a.length() + 1];
        int m = dp.length;
        for (int i = 1; i < m; i++) {
            dp[i][i] = 1;
        }


        for (int i = 1; i < m; i++) {
            int k = 1;
            for (int j = i + 1; j < m && k < m - i; j++) {
                /**
                 * For string of len 2 handle it separately
                 */
                if (a.charAt(k - 1) == a.charAt(j - 1) && i == 1) {
                    dp[k][j] = 2;
                }
                if (a.charAt(k - 1) == a.charAt(j - 1)) {
                    /**
                     * If the two char are equal count those characters in and move ahead
                     */
                    dp[k][j] = dp[k + 1][j - 1] + 2;
                } else {
                    dp[k][j] = Math.max(dp[k + 1][j], dp[k][j - 1]);
                }

                k++;

            }

        }

        return dp[1][m-1];
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubsequence().solve("bebdeeedaddecebbbbbabebedc"));
    }
}
