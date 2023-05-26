package ScalerAcademySolutions.bst;

import java.util.Stack;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.bst
 * Date:Sep, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 * Implement an iterator over a binary search tree (TopicWiseSolutions.Strings.BST). Your iterator will be initialized with the root node of a TopicWiseSolutions.Strings.BST.
 *
 * The first call to next() will return the smallest number in TopicWiseSolutions.Strings.BST. Calling next() again will return the next smallest number in the TopicWiseSolutions.Strings.BST, and so on.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree. Try to optimize the additional space complexity apart from the amortized time complexity.
 */
public class BstIterator {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Stack<TreeNode> stack;

    public void Solution(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (stack.isEmpty()) return -1;
        TreeNode node = stack.pop();
        int value = node.val;
        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return value;
    }
}
