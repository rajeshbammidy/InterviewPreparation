package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongestCommonSubstring {
    static int lcs(String a, String b) {
        int dp[][] = new int[a.length() + 1][b.length() + 1];
        int m = dp.length;
        int n = dp[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                }

            }
        }
        return max==Integer.MIN_VALUE?0:max;


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
