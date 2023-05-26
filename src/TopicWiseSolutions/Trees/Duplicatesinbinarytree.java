package TopicWiseSolutions.Trees;

import java.util.HashSet;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Trees|Duplicatesinbinarytree| on Jul,2020
 *  
 * Happy Coding :)
 *
 * Duplicates in binary tree
 * Given a binary tree of integers. Return whether it contains a duplicate sub-tree of size 2 or more.
 *
 * All node values lie between 0 and 9 inclusive.
 *
 * Return 1 if it contains a duplicate sub-tree of size 2 or more else return 0.
 *
 * Note: Two same leaf nodes are not considered as a subtree, As the size of a leaf node is one.
 *
 * Constraints
 *
 * 1 <= Number of nodes in binary tree <= 10000
 * 0 <= node values <= 9
 * For Example
 *
 * Input 1:
 *             1
 *           /   \
 *          2     6
 *         / \     \
 *        4   5     2
 *                 / \
 *                4   5
 *
 * Output 1:
 *     1
 *
 *     Duplicate Subtree     2
 *                          / \
 *                         4   5
 *
 * Input 2:
 *             1
 *            /  \
 *           2    3
 *            \
 *             4
 *              \
 *               5
 * Output 2:
 *     0
 **/
public class Duplicatesinbinarytree {
    static HashSet<String> set = new HashSet<>();

    public int solve(TreeNode root) {
        set = new HashSet<>();
        String res = findDup(root);
        if (res.isEmpty()) return 1;
        else return 0;

    }

    final String fstr = "/";

    private String findDup(TreeNode root) {
        String curStr = "";
        if (root == null) return curStr + fstr;

        String lhs = findDup(root.left);
        if (lhs.equals("")) return "";
        String rhs = findDup(root.right);
        if (rhs.equals("")) return "";
        curStr = root.val + lhs + rhs;
/**
 * Here we are checking len > 3 because we know if the left and right is null they will contribute length 2 because we add char "/"
 *
 *         Ex:
 *                   10
 *                  /  \
 *                 /    \
 * it return"/"<--null  null--> it will return "/"
 */
        if (curStr.length() > 3 && set.contains(curStr)) return "";
        else {
            set.add(curStr);
        }
        return curStr;

    }


}
