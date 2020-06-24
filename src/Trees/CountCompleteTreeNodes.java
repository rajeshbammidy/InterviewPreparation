package Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|CountCompleteTreeNodes| on Jun,2020
 *  
 * Happy Coding :)
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 **/
public class CountCompleteTreeNodes {
    int leftCount(TreeNode root) {
        if (root != null) {
            return 1 + leftCount(root.left);
        }
        return 0;
    }

    int rightCount(TreeNode root) {
        if (root != null) {
            return 1 + leftCount(root.right);
        }
        return 0;
    }

    public int countNodes(TreeNode root) {

        if (root != null) {
            int lc = leftCount(root);
            int rc = rightCount(root);
            if (lc == rc) {

                return (int) Math.pow(2, lc) - 1;
            }

            return 1 + countNodes(root.left) + countNodes(root.right);

        }
        return 0;

    }
}
