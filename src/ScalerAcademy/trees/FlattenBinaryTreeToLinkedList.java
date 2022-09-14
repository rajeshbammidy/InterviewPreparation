package ScalerAcademy.trees;


/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.trees
 * Date:Sep, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 * Problem Description
 * Given a binary tree A, flatten it to a linked list in-place.
 *
 * The left child of all nodes should be NULL.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of tree <= 100000
 *
 *
 *
 * Input Format
 * First and only argument is the head of tree A.
 *
 *
 *
 * Output Format
 * Return the linked-list after flattening.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *      1
 *     / \
 *    2   3
 * Input 2:
 *
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 * Output 2:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Tree flattening looks like this.
 * Explanation 2:
 *
 *  Tree flattening looks like this.
 */
public class FlattenBinaryTreeToLinkedList {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static TreeNode prev = null, head = null;

    public TreeNode flatten(TreeNode root) {
        prev = null;
        head = null;
        flatIt(root);
        return head;

    }

    private void flatIt(TreeNode root) {
        if (root != null) {
            if (prev == null) {
                head = new TreeNode(root.val);
                prev = head;
            } else {
                prev.right = new TreeNode(root.val);
                prev = prev.right;
            }
            flatIt(root.left);
            flatIt(root.right);
        }
    }
}
