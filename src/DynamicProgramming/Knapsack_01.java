package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Knapsack_01 {
    public static int maxProfit(int wt[], int val[], int kw) {
        int dp[][] = new int[wt.length][kw + 1];
        int m = dp.length;
        int n = dp[0].length;
        for (int i = wt[0]; i < n; i++) {
            dp[0][i] = val[0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (wt[i] > j) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i]] + val[i]);
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
            int wtb = Integer.parseInt(bf.readLine());


            String iws[] = bf.readLine().split("\\s");
            int wt[] = new int[iws.length];

            for (int j = 0; j < wt.length; j++) {
                wt[j] = Integer.parseInt(iws[j]);
            }
            String ivs[] = bf.readLine().split("\\s");
            int vl[] = new int[ivs.length];
            for (int j = 0; j < vl.length; j++) {
                vl[j] = Integer.parseInt(ivs[j]);
            }
            System.out.println(maxProfit(wt, vl, wtb));
        }

    }
}
