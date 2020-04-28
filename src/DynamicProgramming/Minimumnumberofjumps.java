package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Minimumnumberofjumps {
    /**
     * *Leet code
     */
    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
            if (dp[i] == Integer.MAX_VALUE) return false;
        }
        return true;

    }

    public static int minJumps(int arr[]) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            boolean entered = false;
            for (int j = 0; j < i; j++) {
                if (j + arr[j] >= i) {
                    entered = true;
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
            if (!entered) return -1;
        }
        return dp[arr.length - 1];
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

            System.out.println(minJumps(wt));
        }

    }
}
