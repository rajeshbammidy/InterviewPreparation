package ScalerAcademy.trees;

import java.util.*;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.trees
 * Date:Sep, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 * Problem Description
 * Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.
 *
 * Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side
 *
 * NOTE: The value comes first in the array which have lower level.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 *
 * 0 <= node values <= 109
 *
 *
 *
 * Input Format
 * First and only argument is a root node of the binary tree, A.
 *
 *
 *
 * Output Format
 * Return an integer array denoting the left view of the Binary tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *             1
 *           /   \
 *          2    3
 *         / \  / \
 *        4   5 6  7
 *       /
 *      8
 * Input 2:
 *
 *             1
 *            /  \
 *           2    3
 *            \
 *             4
 *              \
 *               5
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 2, 4, 8]
 * Output 2:
 *
 *  [1, 2, 4, 5]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Left view of the binary tree is returned.
 */
public class LeftViewOfBinaryTree {
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

    public ArrayList<Integer> solve(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.poll();
                if (i == 0) {
                    ans.add(treeNode.val);
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }

            }
        }
        return ans;
    }
}