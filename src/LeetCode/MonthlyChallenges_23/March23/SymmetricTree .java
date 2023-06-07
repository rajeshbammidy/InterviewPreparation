package LeetCode.MonthlyChallenges_23.March23;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e.,
 * symmetric around its center).
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *
 *
 *
 * Follow up: Could you solve it both recursively and iteratively?
 *
 * Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 1312
 * 5 👎 291
 */

class SymmetricTree {
    public static void main(String args[]) {
        Solution solution = new SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {

            return isCheckSymmetric(root.left, root.right);

        }

        private boolean isCheckSymmetric(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) return true;
            if (root1 == null) return false;
            if (root2 == null) return false;

            return root1.val == root2.val &&
                            (isCheckSymmetric(root1.left, root2.right) && isCheckSymmetric(root1.right, root2.left));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
