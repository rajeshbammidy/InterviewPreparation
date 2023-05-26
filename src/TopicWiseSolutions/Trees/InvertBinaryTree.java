package TopicWiseSolutions.Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Trees|InvertBinaryTree| on Jun,2020
 *  
 * Happy Coding :)
 * Invert a binary tree.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * Output:
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 * <p>
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

    int ans = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root != null) {
            findPath(root, sum, 0);
            pathSum(root.left, sum);
            pathSum(root.right, sum);
            return ans;
        }
        return 0;
    }

    private void findPath(TreeNode root, int sum, int curSum) {
        if (root != null) {
            curSum += (root.val);
            if (curSum == sum) ans++;
            findPath(root.left, sum, curSum);
            findPath(root.right, sum, curSum);
        }
    }

}

