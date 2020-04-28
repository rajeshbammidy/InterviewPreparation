package Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|TreeFromPreorder| on Apr,2020
 *  
 * Happy Coding :)
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 *
 *
 *
 * Example 1:
 *
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 *
 *
 * Note:
 *
 * 1 <= preorder.length <= 100
 * The values of preorder are distinct.
 **/
public class TreeFromPreorder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int index = 0;


    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);

        return buildTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, preorder.length);

    }

    private TreeNode buildTree(int[] preorder, int minValue, int maxValue, int size) {


        if (index >= size) {
            return null;
        }
        TreeNode root = null;
        int key = preorder[index];
        if (key > minValue && key < maxValue) {
            root = new TreeNode(key);
            index += 1;
            if (index < size) {
                root.left = buildTree(preorder, minValue, key, size);
                root.right = buildTree(preorder, key, maxValue, size);
            }

        }
        return root;

    }



}
