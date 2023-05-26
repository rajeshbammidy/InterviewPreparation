package TopicWiseSolutions.DynamicProgramming;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.DynamicProgramming|RussianDollEnvelopes| on Jun,2020
 *  
 * Happy Coding :)
 *
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 *
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 *
 * Note:
 * Rotation is not allowed.
 *
 * Example:
 *
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 **/
import  java.util.*;
public class RussianDollEnvelopes
{
    static  class node{
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        int dp[] = new int[envelopes.length];
        ArrayList<node> list=new ArrayList<>();
        for(int i=0;i<envelopes.length;i++){
            list.add(new node(envelopes[i][0],envelopes[i][1]));
        }
        list.sort(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return o1.x-o2.x;
            }
        });
        Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(j).x < list.get(i).x && list.get(j).y < list.get(i).y && dp[i]<=dp[j]) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }

            }
        }

        return max;
    }
}
