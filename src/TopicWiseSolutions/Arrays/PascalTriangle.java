package TopicWiseSolutions.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Arrays|PascalTriangle| on Apr,2020
 *  
 * Happy Coding :)
 **/
public class PascalTriangle {
    public static int[][] solve(int n) {

        if (n == 0) {
            int res[][] = new int[1][1];

            res[0][0] = 0;
            return res;

        }
        int res[][] = new int[n][];
        res[0] = new int[1];
        res[0][0] = 1;
        for (int i = 1; i < n; i++) {
            int dp[] = new int[i + 1];
            dp[0] = 1;
            for (int j = i; j > 0; j--) {
                if (j == i) {
                    dp[j] = res[i - 1][j - 1];
                } else

                    dp[j] = res[i - 1][j] + res[i - 1][j - 1];

            }
            res[i] = dp;
        }

        return res;

    }
}
