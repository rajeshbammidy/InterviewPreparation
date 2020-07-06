package Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|MaxSumPath| on Jul,2020
 *  
 * Happy Coding :)
 *
 * Max Sum Path in Binary Tree
 * Problem Description
 *
 * Given a binary tree T, find the maximum path sum.
 *
 * The path may start and end at any node in the tree.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of Nodes <= 7e4
 *
 * -1000 <= Value of Node in T <= 1000
 *
 *
 *
 * Input Format
 * The first and the only argument contains a pointer to the root of T, A.
 *
 *
 *
 * Output Format
 * Return an integer representing the maximum sum path.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *     1
 *    / \
 *   2   3
 * Input 2:
 *
 *        20
 *       /  \
 *    -10   20
 *         /  \
 *       -10  -50
 *
 *
 * Example Output
 * Output 1:
 *
 *  6
 * Output 2:
 *
 *  40
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *      The path with maximum sum is: 2 -> 1 -> 3
 * Explanation 2:
 *
 *      The path with maximum sum is: 20 -> 20
 **/
public class MaxSumPath {
    static int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxSumPath(root);
        return maxSum;
    }

    private int maxSumPath(TreeNode root) {
        if (root == null) return 0;

        int left = maxSumPath(root.left);
        int right = maxSumPath(root.right);

        int c1 = root.val;
        int c2 = root.val + left;
        int c3 = root.val + right;
        int c4 = root.val + right + left;
        maxSum = Math.max(maxSum, Math.max(c1, Math.max(Math.max(c3, c4), c2)));
        return Math.max(0, Math.max(left, right)) + root.val;


    }
}
