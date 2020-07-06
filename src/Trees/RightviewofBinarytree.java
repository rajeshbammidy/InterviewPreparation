package Trees;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|RightviewofBinarytree| on Jul,2020
 *  
 * Happy Coding :)
 *
 * Right view of Binary tree
 * Problem Description
 *
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
 **/
public class RightviewofBinarytree {
    static ArrayList<Integer> res;
    static int maxlevel = 0;

    public ArrayList<Integer> solve(TreeNode root) {
        res = new ArrayList<>();
        maxlevel = 0;
        rightView(root, 1);
        return res;

    }

    private void rightView(TreeNode root, int level) {

        if (root != null) {
            if (maxlevel < level) {
                res.add(root.val);
                maxlevel = level;
            }
            rightView(root.right, level + 1);
            rightView(root.left, level + 1);


        }
    }
}
