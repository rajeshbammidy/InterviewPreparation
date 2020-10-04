package Trees;

import java.util.Stack;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|BSTIterator| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class BSTIterator {

    Stack<TreeNode> left;

    public BSTIterator(TreeNode root) {
        left = new Stack<>();
        includeAllLeft(root, left);
    }

    private void includeAllLeft(TreeNode root, Stack<TreeNode> left) {
        if (root != null) {
            left.push(root);
            includeAllLeft(root.left, left);

        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        if (left.size() > 0) return true;
        return false;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode smaller = left.pop();
        if (smaller.right != null) includeAllLeft(smaller.right, left);
        return smaller.val;
    }
}
