package LeetCode.MonthlyChallenges_23.March23;

/**
 * Given the root of a binary tree, determine if it is a complete binary tree.
 *
 * In a complete binary tree, every level, except possibly the last, is
 * completely filled, and all nodes in the last level are as far left as possible. It can
 * have between 1 and 2ʰ nodes inclusive at the last level h.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5,6]
 * Output: true
 * Explanation: Every level before the last is full (ie. levels with node-values {1
 * } and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as
 * possible.
 *
 *
 * Example 2:
 *
 *
 * Input: root = [1,2,3,4,5,null,7]
 * Output: false
 * Explanation: The node with value 7 isn't as far left as possible.
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is in the range [1, 100].
 * 1 <= Node.val <= 1000
 *
 *
 * Related Topics Tree Breadth-First Search Binary Tree 👍 3628 👎 46
 */

import java.util.*;

class CheckCompletenessOfABinaryTree {
    public static void main(String args[]) {
        Solution solution = new CheckCompletenessOfABinaryTree().new Solution();
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


        public boolean isCompleteTree(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            boolean isNullFound = false;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    if (isNullFound) return false;
                    queue.add(node.left);
                } else {
                    isNullFound = true;
                }

                if (node.right != null) {
                    if (isNullFound) return false;
                    queue.add(node.right);
                } else {
                    isNullFound = true;
                }
            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
