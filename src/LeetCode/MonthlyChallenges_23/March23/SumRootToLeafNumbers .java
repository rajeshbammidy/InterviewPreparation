package LeetCode.MonthlyChallenges_23.March23;

/**
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 *
 *
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so
 * that the answer will fit in a 32-bit integer.
 *
 * A leaf node is a node with no children.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 *
 *
 * Example 2:
 *
 *
 * Input: root = [4,9,0,5,1]
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 9
 * The depth of the tree will not exceed 10.
 *
 *
 * Related Topics Tree Depth-First Search Binary Tree 👍 6440 👎 100
 */

class SumRootToLeafNumbers {
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

    public static void main(String args[]) {
        Solution solution = new SumRootToLeafNumbers().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        int sum = 0;

        public int sumNumbers(TreeNode root) {
            sum = 0;
            getSum(root, 0);
            return sum;

        }

        private void getSum(TreeNode root, int num) {
            if (root != null) {
                num = num * 10 + root.val;
                getSum(root.left, num);
                getSum(root.right, num);
                if (root.left == null && root.right == null) {
                    sum += num;
                }
                num /= 10;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
