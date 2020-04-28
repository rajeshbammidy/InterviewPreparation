package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EggDroppingProblem {
    static int dp[][];

    static int findAttempts(int eggs, int floors) {
        dp = new int[eggs + 1][floors + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return findMinAttempts(eggs, floors);
    }

    private static int findMinAttempts(int eggs, int floors) {
        if (floors == 0 || floors == 1) return floors;
        if (eggs == 1) return floors;

        if (dp[eggs][floors] != -1) return dp[eggs][floors];
        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= floors; k++) {
            int t = 1 + Math.max(findMinAttempts(eggs - 1, k - 1), findMinAttempts(eggs, floors - k));
            min = Math.min(min, t);
        }
        dp[eggs][floors] = min;
        return min;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {


            String iws[] = bf.readLine().split("\\s");
            int wt[] = new int[iws.length];

            for (int j = 0; j < wt.length; j++) {
                wt[j] = Integer.parseInt(iws[j]);
            }

            System.out.println(findAttempts(wt[0], wt[1]));
        }

    }
}
