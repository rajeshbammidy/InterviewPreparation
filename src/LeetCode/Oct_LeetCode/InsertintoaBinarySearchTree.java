package LeetCode.Oct_LeetCode;

/**
 * Created by RajeshAatrayan|InterviewPreparation|LeetCode.Oct_LeetCode|InsertintoaBinarySearchTree| on Oct,2020
 *  
 * Happy Coding :)
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class InsertintoaBinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            if (cur.val == val) return root;
            else if (cur.val > val) {
                prev = cur;
                cur = cur.left;
            } else {
                prev = cur;
                cur = cur.right;
            }
        }
        if (prev != null) {
            if (prev.val > val) {
                prev.left = new TreeNode(val);
            } else {
                prev.right = new TreeNode(val);
            }
        }
        return root;


    }
}
