package ScalerAcademySolutions.trees;

import java.util.Stack;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.trees
 * Date:Sep, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 */
public class KDistance {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Stack<TreeNode> stack;
    int res = 0;

    public int solve(TreeNode root, int k) {
        res = 0;
        stack = new Stack<>();
        checkForCount(root, k);
        return res;

    }

    private void checkForCount(TreeNode root, int k) {
        if (root != null) {
            stack.add(root);
            count(stack, k);
            checkForCount(root.left, k);
            checkForCount(root.right, k);
            stack.pop();
        }
    }

    private void count(Stack<TreeNode> stack, int k) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        int element = stack.peek().val;
        treeNodeStack.push(stack.pop());
        while (!stack.isEmpty()) {
            if (Math.abs(element - stack.peek().val) <= k) res++;
            treeNodeStack.push(stack.pop());
        }
        while (!treeNodeStack.isEmpty()) {
            stack.push(treeNodeStack.pop());
        }
    }
}
