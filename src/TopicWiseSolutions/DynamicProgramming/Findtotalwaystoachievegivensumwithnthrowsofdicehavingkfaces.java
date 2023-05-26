package TopicWiseSolutions.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.DynamicProgramming|Findtotalwaystoachievegivensumwithnthrowsofdicehavingkfaces| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class Findtotalwaystoachievegivensumwithnthrowsofdicehavingkfaces {
    /**
     * @param n   rolls
     * @param k   faces
     * @param sum that we have to make
     * @return
     */
    int dp[][] = new int[100000][100000];

    {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
    }


    int count(int n, int k, int sum) {
        if (n == 0) {
            if (sum == 0) return 1;
        }

        if (sum <= 0 || n * k < sum || n > sum) return 0;
        if (dp[n][sum] != -1) return dp[n][sum];

        int res = 0;
        for (int i = 1; i <= 6; i++) {
            res += count(n - 1, k, sum - i);
        }
        dp[n][sum] = res;
        return res;

    }
}
