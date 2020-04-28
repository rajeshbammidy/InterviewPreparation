package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SubSetSum {
    static boolean isPosSubSetSum(int arr[], int sum) {
        boolean dp[][] = new boolean[arr.length + 1][sum + 1];
        int m = dp.length;
        int n = dp[0].length;
        for (int i = 0; i < m; i++) dp[i][0] = true;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (arr[i - 1] > j) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }

            }
        }
     //   System.out.println(Arrays.deepToString(dp));
        return dp[m - 1][n - 1];
    }

    static boolean isEqualPartitioned(int arr[]) {
        int sum = 0;
        for (int x :
                arr) {
            sum += x;
        }
        if ((sum & 1) == 1) return false;
        return isPosSubSetSum(arr, sum / 2);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            bf.readLine();


            String iws[] = bf.readLine().split("\\s");
            int wt[] = new int[iws.length];
            for (int j = 0; j < wt.length; j++) {
                wt[j] = Integer.parseInt(iws[j]);
            }
            System.out.println(isEqualPartitioned(wt));
        }

    }

}
