package TopicWiseSolutions.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.DynamicProgramming|MaximumLengthofPairChain| on Jun,2020
 *  
 * Happy Coding :)
 *
 * 646. Maximum Length of Pair Chain
 * Medium
 *
 * 827
 *
 * 74
 *
 * Add to List
 *
 * Share
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 *
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 *
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
 *
 * Example 1:
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * Note:
 * The number of given pairs will be in the range [1, 1000].
 **/
public class MaximumLengthofPairChain {
    static class node {
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int findLongestChain(int[][] pairs) {

        ArrayList<node> list = new ArrayList<>();
        if (pairs.length == 0) return 0;
        if (pairs.length == 1) return 1;
        for (int i = 0; i < pairs.length; i++) {
            list.add(new node(pairs[i][0], pairs[i][1]));
        }
        list.sort(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return o1.x - o2.x;
            }
        });
        int dp[] = new int[pairs.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(j).y < list.get(i).x && dp[j] <= dp[i]) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;

    }
}
