package kattis;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class mailbox {
    /**
     * 3 dp to memoize the overlapping  sub problems
     */
    static int dp[][][];

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        while (tc-- > 0) {
            /**
             * Read the input
             */
            String input[] = bf.readLine().split("\\s");
            int k = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            /**
             * Initialize the dp array
             */
            dp = new int[k + 1][m + 1][m + 1];
            int ans = findMinimumFireCrackers(k, 1, m);
            System.out.println(ans);

        }
    }

    private static int findMinimumFireCrackers(int mailBoxes, int startCracker, int endCrackers) {
        /**
         * If the start of crackers is greater than end of crackers, this case is invalid so return 0
         */

        if (startCracker > endCrackers) {
            return 0;
        }
        /**
         * If we have only one mailbox, we can simply find the number of fire crackers required by using the following formula
         */
        if (mailBoxes == 1) {
            int prevFireCrackerEndAt = startCracker - 1;
            return endCrackers * (endCrackers + 1) / 2 - (prevFireCrackerEndAt * (prevFireCrackerEndAt + 1) / 2);
        }
        /**
         * If we have only one set of crackers, then it would take # of crackers to blast the mailbox in the worstcase
         */
        if (startCracker == endCrackers) {
            return startCracker;
        }
        /**
         * Memoize it
         */
        if (dp[mailBoxes][startCracker][endCrackers] != 0) return dp[mailBoxes][startCracker][endCrackers];
        int minFireCrackers = Integer.MAX_VALUE;
        for (int i = startCracker; i <= endCrackers; i++) {

            int maxFireCrackersRequired = i + Math.max(findMinimumFireCrackers(mailBoxes - 1, startCracker, i - 1),
                    findMinimumFireCrackers(mailBoxes, i + 1, endCrackers));
            minFireCrackers = Math.min(maxFireCrackersRequired, minFireCrackers);
        }
        dp[mailBoxes][startCracker][endCrackers] = minFireCrackers;
        return minFireCrackers;
    }
}