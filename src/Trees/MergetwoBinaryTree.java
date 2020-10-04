package Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|MergetwoBinaryTree| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class MergetwoBinaryTree {
    public TreeNode solve(TreeNode rootA, TreeNode rootB) {
        return preOrder(rootA, rootB);
    }

    private TreeNode preOrder(TreeNode rootA, TreeNode rootB) {
        if (rootA == null && rootB == null) return null;

        if (rootA != null && rootB != null) {
            TreeNode root = new TreeNode(rootA.val + rootB.val);
            root.left = preOrder(rootA.left, rootB.left);
            root.right = preOrder(rootA.right, rootB.right);
            return root;
        } else if (rootA == null) {
            TreeNode root = new TreeNode(rootB.val);
            root.left = preOrder(null, rootB.left);
            root.right = preOrder(null, rootB.right);
            return root;
        } else if (rootB == null) {
            TreeNode root = new TreeNode(rootA.val);
            root.left = preOrder(rootA.left, null);
            root.right = preOrder(rootA.right, null);
            return root;
        }
        return null;
    }
}
