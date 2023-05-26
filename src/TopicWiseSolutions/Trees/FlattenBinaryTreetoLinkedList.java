package TopicWiseSolutions.Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Trees|FlattenBinaryTreetoLinkedList| on Jul,2020
 *  
 * Happy Coding :)
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * Example :
 * Given
 *
 *
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * Note that the left child of all nodes should be NULL.
 **/
public class FlattenBinaryTreetoLinkedList {
    static TreeNode head, prev;

    public TreeNode flatten(TreeNode root) {
        head = null;
        prev = null;
        flatIt(root);
        return head;
    }

    private void flatIt(TreeNode root) {
        if (root != null) {
            TreeNode tempL = root.left;
            TreeNode tempR = root.right;
            if (head == null) {
                root.left = null;
                root.right = null;
                head = root;
                prev = root;
            } else {
                root.left = null;
                root.right = null;
                prev.right = root;
                prev = root;
            }
            flatIt(tempL);
            flatIt(tempR);


        }
    }

}
