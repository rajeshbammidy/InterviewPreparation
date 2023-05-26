package LeetCode.FEB23.leetcode.editor.en;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder
 * traversal of a binary tree and inorder is the inorder traversal of the same tree,
 * construct and return the binary tree.
 *
 *
 * Example 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 *
 * Example 2:
 *
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 *
 *
 * Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 👍 12449 👎
 * 364
 */

import java.util.*;

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String args[]) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
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

    class Solution {


        int preOrderIndex = 0;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            preOrderIndex = 0;
            return build(preorder, inorder, 0, inorder.length - 1);

        }

        private TreeNode build(int[] preorder, int[] inorder, int i, int j) {
            if (i > j || preOrderIndex>=preorder.length) return null;
            TreeNode node = new TreeNode(preorder[preOrderIndex]);
            int index = 0;
            for (int k = i; k <= j; k++) {
                if (inorder[k] == preorder[preOrderIndex]) {
                    index = k;
                    break;
                }
            }
            preOrderIndex++;
            node.left = build(preorder, inorder, i, index - 1);
            node.right = build(preorder, inorder, index + 1, j);
            return node;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
