package DynamicProgramming;

/**
 * Created by RajeshAatrayan|InterviewPreparation|DynamicProgramming|CoinsinaLine| on Sep,2020
 *  
 * Happy Coding :)
 **/

import java.util.*;

public class CoinsinaLine {
    int dp[][];

    public int maxcoin(int[] arr) {
        dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return backtrack(arr, 0, arr.length - 1);

    }

    private int backtrack(int[] arr, int i, int j) {
        if (i == j) return arr[i];

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i + 1 == j) {
            return Math.max(arr[i], arr[j]);
        }


        int start = arr[i] + Math.min(backtrack(arr, i + 2, j), backtrack(arr, i + 1, j - 1));
        int end = arr[j] + Math.min(backtrack(arr, i + 1, j - 1), backtrack(arr, i, j - 2));
        dp[i][j] = Math.max(start, end);
        return Math.max(start, end);
    }
}
