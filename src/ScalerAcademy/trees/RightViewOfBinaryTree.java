package ScalerAcademy.trees;

import java.sql.Array;
import java.util.ArrayList;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.trees
 * Date:Sep, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 * Problem Description
 * Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.
 *
 * Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.
 *
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 *
 * 0 <= node values <= 10^9
 *
 *
 *
 * Input Format
 * First and only argument is head of the binary tree A.
 *
 *
 *
 * Output Format
 * Return an array, representing the right view of the binary tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
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
 *  [1, 3, 7, 8]
 * Output 2:
 *
 *  [1, 3, 4, 5]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Right view is described.
 * Explanation 2:
 *
 * Right view is described.
 */
public class RightViewOfBinaryTree {
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

    static int level = 1;

    public ArrayList<Integer> solve(TreeNode root) {
        level = 1;
        ArrayList<Integer> res = new ArrayList<Integer>();
        reverPostOrder(root, 1, res);
        return res;
    }

    private void reverPostOrder(TreeNode root, int maxLevel, ArrayList<Integer> list) {
        if (root != null) {
            if (level == maxLevel) {
                list.add(root.val);
                level++;
            }
            reverPostOrder(root.right, maxLevel + 1, list);
            reverPostOrder(root.left, maxLevel + 1, list);
        }
    }
}
