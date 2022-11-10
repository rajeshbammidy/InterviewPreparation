package kattis;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class mailbox {
    static int dp[][][];

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        while (tc-- > 0) {
            String input[] = bf.readLine().split("\\s");
            int k = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            dp = new int[k + 1][m + 1][m + 1];
            int ans = recurDP(k, 1, m);
            System.out.println(ans);

        }
    }

    private static int recurDP(int mailBoxes, int startCracker, int endCrackers) {

        if (startCracker > endCrackers) {
            return 0;
        }
        if (mailBoxes == 1) {
            int prevEnd = startCracker - 1;
            return endCrackers * (endCrackers + 1) / 2 - (prevEnd * (prevEnd + 1) / 2);
        }
        if (startCracker == endCrackers) {
            return startCracker;
        }
        if (dp[mailBoxes][startCracker][endCrackers] != 0) return dp[mailBoxes][startCracker][endCrackers];
        int min = Integer.MAX_VALUE;
        for (int i = startCracker; i <= endCrackers; i++) {
            int temp = i + Math.max(recurDP(mailBoxes - 1, startCracker, i - 1), recurDP(mailBoxes, i + 1, endCrackers));
            min = Math.min(temp, min);
        }
        dp[mailBoxes][startCracker][endCrackers] = min;
        return min;
    }
}