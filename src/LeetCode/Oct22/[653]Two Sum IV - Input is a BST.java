package LeetCode.Oct22;//Given the root of a Binary Search Tree and a target number k, return true if
//there exist two elements in the BST such that their sum is equal to the given 
//target. 
//
// 
// Example 1: 
// 
// 
//Input: root = [5,3,6,2,4,null,7], k = 9
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: root = [5,3,6,2,4,null,7], k = 28
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -10⁴ <= Node.val <= 10⁴ 
// root is guaranteed to be a valid binary search tree. 
// -10⁵ <= k <= 10⁵ 
// 
//
// Related Topics Hash Table Two Pointers Tree Depth-First Search Breadth-First 
//Search Binary Search Tree Binary Tree 👍 5137 👎 225


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;

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
class Solution653 {
    static class TreeNode {
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

    HashSet<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        return findIfTargetExists(root, k);

    }

    private boolean findIfTargetExists(TreeNode root, int k) {
        if (root != null) {
            if (set.contains(k - root.val)) return true;
            set.add(root.val);
            boolean left = findTarget(root.left, k);
            if (left) return true;
            boolean right = findTarget(root.right, k);
            if (right) return true;

        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
