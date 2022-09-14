package ScalerAcademy.trees;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.bst
 * Date:Sep, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 *
 * Problem Description
 * Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 *
 *
 * Input Format
 * First and only argument is the root node of the binary tree.
 *
 *
 *
 * Output Format
 * Return 0 / 1 ( 0 for false, 1 for true ).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * Input 2:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The above binary tree is symmetric.
 * Explanation 2:
 *
 * The above binary tree is not symmetric.
 */
public class SymmetricBinaryTree {
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

    public int isSymmetric(TreeNode root) {
        return isSymmetricTree(root.left, root.right) ? 1 : 0;
    }

    private boolean isSymmetricTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.val == root2.val && isSymmetricTree(root1.left, root2.right) && isSymmetricTree(root1.right, root2.left);


    }
}
