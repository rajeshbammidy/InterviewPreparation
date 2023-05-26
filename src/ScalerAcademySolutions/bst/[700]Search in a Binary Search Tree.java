package ScalerAcademySolutions.bst;//You are given the root of a binary search tree (TopicWiseSolutions.Strings.BST) and an integer val.
//
// Find the node in the TopicWiseSolutions.Strings.BST that the node's value equals val and return the
//subtree rooted with that node. If such a node does not exist, return null. 
//
// 
// Example 1: 
// 
// 
//Input: root = [4,2,7,1,3], val = 2
//Output: [2,1,3]
// 
//
// Example 2: 
// 
// 
//Input: root = [4,2,7,1,3], val = 5
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 5000]. 
// 1 <= Node.val <= 10⁷ 
// root is a binary search tree. 
// 1 <= val <= 10⁷ 
// 
//
// Related Topics Tree Binary Search Tree Binary Tree 👍 3988 👎 157


//leetcode submit region begin(Prohibit modification and deletion)

class Solution700 {
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
    public TreeNode searchBST(TreeNode root, int val) {

        if (root != null) {
            if (root.val == val) return root;
            if (val < root.val) return searchBST(root.left, val);
            return searchBST(root.right, val);
        }
        return null;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
