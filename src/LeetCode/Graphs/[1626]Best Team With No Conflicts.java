package LeetCode.Graphs;

import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are the manager of a basketball team. For the upcoming tournament, you want
 * to choose the team with the highest overall score. The score of the team is the
 * sum of scores of all the players in the team.
 *
 * However, the basketball team is not allowed to have conflicts. A conflict
 * exists if a younger player has a strictly higher score than an older player. A
 * conflict does not occur between players of the same age.
 *
 * Given two lists, scores and ages, where each scores[i] and ages[i] represents
 * the score and age of the iᵗʰ player, respectively, return the highest overall
 * score of all possible basketball teams.
 *
 *
 * Example 1:
 *
 *
 * Input: scores = [1,3,5,10,15], ages = [1,2,3,4,5]
 * Output: 34
 * Explanation: You can choose all the players.
 *
 *
 * Example 2:
 *
 *
 * Input: scores = [4,5,6,5], ages = [2,1,2,1]
 * Output: 16
 * Explanation: It is best to choose the last 3 players. Notice that you are
 * allowed to choose multiple people of the same age.
 *
 *
 * Example 3:
 *
 *
 * Input: scores = [1,2,3,5], ages = [8,9,10,1]
 * Output: 6
 * Explanation: It is best to choose the first 3 players.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= scores.length, ages.length <= 1000
 * scores.length == ages.length
 * 1 <= scores[i] <= 10⁶
 * 1 <= ages[i] <= 1000
 *
 *
 * Related Topics Array Dynamic Programming Sorting 👍 1089 👎 32
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1626 {
    /**
     * Approach: Sort the Pair according to the ages and break the tie by sorting according to the scores.
     * Then apply LIS
     */
    public int bestTeamScore(int[] scores, int[] ages) {
        if (scores.length == 1) return scores[0];
        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            list.add(new Pair<Integer, Integer>(ages[i], scores[i]));
        }
        list.sort((a, b) -> {
            int diff = a.getKey() - b.getKey();
            if (diff != 0) {
                return diff;
            }
            return a.getValue() - b.getValue();
        });
        int dp[] = new int[scores.length];
        int bestTeamScore = 0;
        dp[0] = list.get(0).getValue();
        for (int i = 1; i < list.size(); i++) {
            dp[i] = list.get(i).getValue();
            int currentScore = list.get(i).getValue();
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j).getValue() <= currentScore) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] += max;
            bestTeamScore = Math.max(bestTeamScore, dp[i]);

        }
        return bestTeamScore;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
