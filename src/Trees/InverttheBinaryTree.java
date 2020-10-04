package Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|InverttheBinaryTree| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class InverttheBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode newRoot = new TreeNode(root.val);
            newRoot.left = invertTree(root.right);
            newRoot.right = invertTree(root.left);
            return newRoot;
        }
        return null;
    }
}
