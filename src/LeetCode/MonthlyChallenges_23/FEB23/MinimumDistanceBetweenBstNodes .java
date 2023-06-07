package LeetCode.MonthlyChallenges_23.FEB23;

/**
 * Given the root of a Binary Search Tree (TopicWiseSolutions.Strings.BST), return the minimum difference
 * between the values of any two different nodes in the tree.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,6,1,3]
 * Output: 1
 *
 *
 * Example 2:
 *
 *
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is in the range [2, 100].
 * 0 <= Node.val <= 10⁵
 *
 *
 *
 * Note: This question is the same as 530: https://leetcode.com/problems/minimum-
 * absolute-difference-in-bst/
 *
 * Related Topics Tree Depth-First Search Breadth-First Search Binary Search Tree
 * Binary Tree 👍 2907 👎 384
 */

import java.util.*;

class MinimumDistanceBetweenBstNodes {
    public static void main(String args[]) {
        Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
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
        ArrayList<Integer> list;

        public int minDiffInBST(TreeNode root) {
            list = new ArrayList<>();
            getDifference(root);
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < list.size(); i++) {
                min = Math.min(min, list.get(i) - list.get(i - 1));
            }
            return min;

        }

        private void getDifference(TreeNode root) {
            if (root != null) {
                getDifference(root.left);
                list.add(root.val);
                getDifference(root.right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
