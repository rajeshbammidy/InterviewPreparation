package ScalerAcademySolutions.trees;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.trees
 * Date:Sep, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 * Problem Description
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
 */
public class MaxSumPathInBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }


    static int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMaxPathSum(root);
        return maxSum;
    }

    private int findMaxPathSum(TreeNode root) {
        if (root != null) {
            int lSum = findMaxPathSum(root.left);
            int rSum = findMaxPathSum(root.right);
            int d1 = root.val;
            int d2 = root.val + lSum;
            int d3 = root.val + rSum;
            int d4 = root.val + lSum + rSum;
            maxSum = Math.max(maxSum, Math.max(d1, Math.max(d2, Math.max(d3, d4))));

            return Math.max(d1, Math.max(d2, d3));
        }
        return 0;
    }
}
