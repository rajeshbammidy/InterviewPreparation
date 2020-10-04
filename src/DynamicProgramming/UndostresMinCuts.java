package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by RajeshAatrayan|InterviewPreparation|DynamicProgramming|UndostresMinCuts| on Oct,2020
 *  
 * Happy Coding :)
 **/
public class UndostresMinCuts {

    int dp[][];

    int favNumber(String str, String fav[]) {
        HashSet<String> set = new HashSet<>();
        for (String x : fav) {
            set.add(x);
        }
        dp = new int[str.length() + 1][str.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return bactrack(str, set, 0, str.length());


    }

    private int bactrack(String str, HashSet<String> set, int i, int j) {


        if (i > str.length() || j > str.length()) return Integer.MAX_VALUE;
        if (dp[i][j] != -1) return dp[i][j];

        if (j < str.length() && set.contains(str.substring(i, j + 1))) return 0;
        else if (j == str.length() && set.contains(str.substring(i, j))) return 0;

        if (i == j) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int lp = bactrack(str, set, i, k);
            int rp = bactrack(str, set, k + 1, j);
            if (lp != Integer.MAX_VALUE && rp != Integer.MAX_VALUE)
                min = Math.min(lp + rp + 1, min);
        }
        dp[i][j] = min;

        return min;


    }
}
