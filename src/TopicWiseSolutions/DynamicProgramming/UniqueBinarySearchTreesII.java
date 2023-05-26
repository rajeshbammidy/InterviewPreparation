package TopicWiseSolutions.DynamicProgramming;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.DynamicProgramming|UniqueBinarySearchTreesII| on Jul,2020
 *  
 * Happy Coding :)
 *
 * Given an integer A, how many structurally unique TopicWiseSolutions.Strings.BST’s (binary search trees) exist that can store values 1…A?
 *
 * Input Format:
 *
 * The first and the only argument of input contains the integer, A.
 * Output Format:
 *
 * Return an integer, representing the answer asked in problem statement.
 * Constraints:
 *
 * 1 <= A <= 18
 * Example:
 *
 * Input 1:
 *     A = 3
 *
 * Output 1:
 *     5
 *
 * Explanation 1:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 **/
public class UniqueBinarySearchTreesII {
    public int numTrees(int n) {
        if (n == 0 || n == 1) return n;
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int ans = 0;
            for (int j = 0; j < i; j++) {
                ans += (dp[j] * dp[i - j - 1]);
            }
            dp[i] = ans;
        }
        return dp[n];
    }
}
