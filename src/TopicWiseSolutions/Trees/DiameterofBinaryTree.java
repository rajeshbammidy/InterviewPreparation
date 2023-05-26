package TopicWiseSolutions.Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Trees|DiameterofBinaryTree| on Jul,2020
 *  
 * Happy Coding :)
 * <p>
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 **/
public class DiameterofBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
         TreeNode node = new TreeNode(root.val);

         node.right = invertTree(root.left);
         node.left = invertTree(root.right);

         return node;
         }
         return null;


    }

    public static int height(TreeNode root) {
        if (root != null) {
            int l = height(root.left);
            int r = height(root.right);
            return Math.max(l, r) + 1;
        }
        return 0;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(Math.max(lh + rh, diameterOfBinaryTree(root.left)), diameterOfBinaryTree(root.right));


    }
}
