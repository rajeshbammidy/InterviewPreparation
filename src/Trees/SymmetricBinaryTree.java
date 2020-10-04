package Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|SymmetricBinaryTree| on Oct,2020
 *  
 * Happy Coding :)
 **/
public class SymmetricBinaryTree {
    public int isSymmetric(TreeNode root) {

        return findIfSymmetric(root, root) ? 1 : 0;
    }

    private boolean findIfSymmetric(TreeNode rootA, TreeNode rootB) {
        if (rootA == null && rootB == null) return true;
        if (rootA != null && rootB != null) {
            return rootA.val == rootB.val && findIfSymmetric(rootA.left, rootB.right) && findIfSymmetric(rootA.right, rootB.left);
        }
        return false;
    }
}
