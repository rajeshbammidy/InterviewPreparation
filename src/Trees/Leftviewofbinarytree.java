package Trees;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|Leftviewofbinarytree| on Jul,2020
 *  
 * Happy Coding :)
 *
 * Left view of binary tree
 * Problem Description
 *
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
 **/
public class Leftviewofbinarytree {
    static ArrayList<Integer> res;
    static int maxlevel = 0;

    public ArrayList<Integer> solve(TreeNode root) {
        res = new ArrayList<>();
        maxlevel = 0;
        leftView(root, 1);
        return res;

    }

    private void leftView(TreeNode root, int level) {

        if (root != null) {
            if (maxlevel < level) {
                res.add(root.val);
                maxlevel = level;
            }
            leftView(root.left, level + 1);
            leftView(root.right, level + 1);

        }
    }
}
