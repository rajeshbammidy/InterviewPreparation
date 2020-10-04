package Trees;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|RecoverBinarySearchTree| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class RecoverBinarySearchTree {
    ArrayList<Integer> list;
    static TreeNode parent = null;

    public ArrayList<Integer> recoverTree(TreeNode root) {
        parent = null;
        list = new ArrayList<>();
        inorderTraversal(root);
        ArrayList<Integer> ans = new ArrayList<>();
        if (list.size() > 0) {
            ans.add(list.get(list.size() - 1));
            ans.add(list.get(0));
        }
        return ans;
    }

    private void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);

            if (parent!=null && parent.val > root.val) {
                list.add(parent.val);
                list.add(root.val);
            }
            parent = root;

            inorderTraversal(root.right);
        }
    }
}
