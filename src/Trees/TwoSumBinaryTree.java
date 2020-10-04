package Trees;

import java.util.Stack;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|TwoSumBinaryTree| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class TwoSumBinaryTree {
    public int t2Sum(TreeNode root, int sum) {
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        includeAllLeft(root, left);

        includeAllRight(root, right);
        return findSum(left, right, sum);
    }

    private int findSum(Stack<TreeNode> left, Stack<TreeNode> right, int sum) {
        TreeNode lf = left.peek();
        TreeNode rt = right.peek();

        while (lf != rt && !left.isEmpty() && !right.isEmpty() && left.peek() != right.peek()) {
            if (lf.val + rt.val == sum) return 1;
            if (lf.val + rt.val < sum) {
                if (lf.right != null) {
                    left.pop();
                    includeAllLeft(lf.right, left);
                    if(!left.isEmpty())
                        lf = left.peek();
                } else {
                    left.pop();
                    if(!left.isEmpty())
                        lf = left.peek();
                }
            } else {
                if (rt.left != null) {
                    right.pop();
                    includeAllRight(rt.left, right);
                    if(!right.isEmpty())
                        rt = right.peek();
                } else {
                    right.pop();
                    if(!right.isEmpty())
                        rt = right.peek();
                }
            }
        }
        return 0;
    }

    private void includeAllRight(TreeNode root, Stack<TreeNode> right) {
        if (root != null) {
            right.push(root);
            includeAllRight(root.right, right);

        }
    }

    private void includeAllLeft(TreeNode root, Stack<TreeNode> left) {
        if (root != null) {
            left.push(root);
            includeAllLeft(root.left, left);

        }
    }


}
