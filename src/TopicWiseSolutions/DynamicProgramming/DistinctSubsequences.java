package TopicWiseSolutions.DynamicProgramming;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.DynamicProgramming|DistinctSubsequences| on Jun,2020
 *  
 * Happy Coding :)
 *
 * Given two sequences A, B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.
 *
 * Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, “ACE” is a subsequence of “ABCDE” while “AEC” is not).
 *
 * Input Format:
 *
 * The first argument of input contains a string, A.
 * The second argument of input contains a string, B.
 * Output Format:
 *
 * Return an integer representing the answer as described in the problem statement.
 * Constraints:
 *
 * 1 <= length(A), length(B) <= 700
 * Example :
 *
 * Input 1:
 *     A = "abc"
 *     B = "abc"
 *
 * Output 1:
 *     1
 *
 * Explanation 1:
 *     Both the strings are equal.
 *
 * Input 2:
 *     A = "rabbbit"
 *     B = "rabbit"
 *
 * Output 2:
 *     3
 *
 * Explanation 2:
 *     These are the possible removals of characters:
 *         => A = "ra_bbit"
 *         => A = "rab_bit"
 *         => A = "rabb_it"
 *
 *     Note: "_" marks the removed character.
 **/
public class DistinctSubsequences {
    public int numDistinct(String patt, String str) {
        int dp[][] = new int[str.length() + 1][patt.length() + 1];
        for (int i = 0; i < dp[0].length; i++) dp[0][i] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (str.charAt(i - 1) == patt.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }

        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
