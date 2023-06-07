package LeetCode.MonthlyChallenges_23.March23;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 *
 *
 * Example 3:
 *
 *
 * Input: root = []
 * Output: true
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -10⁴ <= Node.val <= 10⁴
 *
 *
 * Related Topics Tree Depth-First Search Binary Tree 👍 8567 👎 486
 */

class BalancedBinaryTree {
    public static void main(String args[]) {
        Solution solution = new BalancedBinaryTree().new Solution();
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


        boolean isBal = true;

        public boolean isBalanced(TreeNode root) {
            isBal = true;
            checkBalanced(root);
            return isBal;
        }

        private int checkBalanced(TreeNode root) {
            if (root != null) {
                int left = checkBalanced(root.left);
                int right = checkBalanced(root.right);
                if (Math.abs(left - right) >= 2) {
                    isBal = isBal & false;
                }
                return Math.max(left, right) + 1;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
