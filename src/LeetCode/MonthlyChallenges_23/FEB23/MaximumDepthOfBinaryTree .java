package LeetCode.MonthlyChallenges_23.FEB23;

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 *
 * Example 2:
 *
 *
 * Input: root = [1,null,2]
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is in the range [0, 10⁴].
 * -100 <= Node.val <= 100
 *
 *
 * Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 1016
 * 0 👎 161
 */

class MaximumDepthOfBinaryTree {
    public static void main(String args[]) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

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
        public int maxDepth(TreeNode root) {
            if (root != null) {
                int left = maxDepth(root.left);
                int right = maxDepth(root.right);
                return Math.max(left, right) + 1;
            }
            return 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
