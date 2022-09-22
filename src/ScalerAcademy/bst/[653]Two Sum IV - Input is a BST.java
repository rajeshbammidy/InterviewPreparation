package ScalerAcademy.bst;//Given the root of a Binary Search Tree and a target number k, return true if
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
//Search Binary Search Tree Binary Tree 👍 4417 👎 213


//leetcode submit region begin(Prohibit modification and deletion)



import java.util.HashSet;

class Solution653 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    HashSet<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        set.clear();
        return checkForSum(root, k);
    }

    private boolean checkForSum(TreeNode root, int sum) {
        if (root != null) {

            if (checkForSum(root.left, sum)) {
                return true;
            }
            if (set.contains(root.val)) return true;
            set.add(sum - root.val);
            if (checkForSum(root.right, sum)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
