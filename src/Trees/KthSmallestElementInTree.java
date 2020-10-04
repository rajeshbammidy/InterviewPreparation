package Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|KthSmallestElementInTree| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class KthSmallestElementInTree {

    static int c = 0;

    public int kthsmallest(TreeNode root, int val) {
        c = 0;
        return inorder(root, val);
    }

    private int inorder(TreeNode root, int val) {
        if (root != null) {
            int x = inorder(root.left, val);
            c++;
            if (c == val) return root.val;
            int y = inorder(root.right, val);
            if (x != -1) return x;
            else if (y != -1) return y;

        }
        return -1;
    }

}
