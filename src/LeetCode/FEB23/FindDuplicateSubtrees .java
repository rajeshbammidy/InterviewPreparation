package LeetCode.FEB23;

/**
 * Given the root of a binary tree, return all duplicate subtrees.
 *
 * For each kind of duplicate subtrees, you only need to return the root node of
 * any one of them.
 *
 * Two trees are duplicate if they have the same structure with the same node
 * values.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,null,2,4,null,null,4]
 * Output: [[2,4],[4]]
 *
 *
 * Example 2:
 *
 *
 * Input: root = [2,1,1]
 * Output: [[1]]
 *
 *
 * Example 3:
 *
 *
 * Input: root = [2,2,2,3,null,3,null]
 * Output: [[2,3],[3]]
 *
 *
 *
 * Constraints:
 *
 *
 * The number of the nodes in the tree will be in the range [1, 5000]
 * -200 <= Node.val <= 200
 *
 *
 * Related Topics Hash Table Tree Depth-First Search Binary Tree 👍 5045 👎 404
 */

import java.util.*;

class FindDuplicateSubtrees {
    public static void main(String args[]) {
        Solution solution = new FindDuplicateSubtrees().new Solution();
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
    class Solution {
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

        private List<TreeNode> result;
        private HashMap<String, Integer> map;

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            result = new ArrayList<>();
            map = new HashMap<>();
            postOrder(root);
            return result;
        }

        private String postOrder(TreeNode root) {
            if (root != null) {

                String left = postOrder(root.left);
                String right = postOrder(root.right);
                String subTreeStr = root.val + "-" + left + "-" + right;
                map.put(subTreeStr, map.getOrDefault(subTreeStr, 0) + 1);
                if (map.get(subTreeStr) == 2) result.add(root);
                return subTreeStr;
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
