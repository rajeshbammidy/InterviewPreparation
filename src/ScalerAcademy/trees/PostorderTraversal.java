package ScalerAcademy.trees;

import java.util.ArrayList;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.trees
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 */
public class PostorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add(root.val);
        }
    }
}
