package TopicWiseSolutions.Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Trees|MaximumWidthofBinaryTree| on Jul,2020
 *  
 * Happy Coding :)
 *
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 *
 * Example 1:
 *
 * Input:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * Example 2:
 *
 * Input:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 * Example 3:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * Example 4:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 *
 *
 * Note: Answer will in the range of 32-bit signed integer.
 **/
public class MaximumWidthofBinaryTree {
    static class Node {
        TreeNode root;
        int index;

        public Node(TreeNode root, int index) {
            this.root = root;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0));
        int ans = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {

            int size = queue.size();
            int i = 0;
            int minIndex = 0;
            while (i < size) {
                Node temp = queue.poll();
                TreeNode curNode = temp.root;
                int curIndex = temp.index;

                if (i == 0) {
                    minIndex = curIndex;
                }
                if (i == size - 1) {
                    ans = Math.max(curIndex - minIndex + 1, ans);
                }

                if (curNode.left != null) queue.add(new Node(curNode.left, curIndex * 2 + 1));

                if (curNode.right != null) queue.add(new Node(curNode.right, curIndex * 2 + 2));

                i++;
            }


        }
        return ans;


    }
}
