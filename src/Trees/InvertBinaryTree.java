package Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|InvertBinaryTree| on Jun,2020
 *  
 * Happy Coding :)
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 **/
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode node = new TreeNode(root.val);

            node.right = invertTree(root.left);
            node.left = invertTree(root.right);

            return node;
        }
        return null;
    }
}

