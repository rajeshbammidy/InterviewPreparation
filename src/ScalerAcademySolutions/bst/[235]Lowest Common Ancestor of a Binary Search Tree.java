package ScalerAcademySolutions.bst;//Given a binary search tree (TopicWiseSolutions.Strings.BST), find the lowest common ancestor (LCA) node
//of two given nodes in the TopicWiseSolutions.Strings.BST.
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor 
//is defined between two nodes p and q as the lowest node in T that has both p 
//and q as descendants (where we allow a node to be a descendant of itself).” 
//
// 
// Example 1: 
// 
// 
//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//Output: 6
//Explanation: The LCA of nodes 2 and 8 is 6.
// 
//
// Example 2: 
// 
// 
//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//Output: 2
//Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant 
//of itself according to the LCA definition.
// 
//
// Example 3: 
//
// 
//Input: root = [2,1], p = 2, q = 1
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 10⁵]. 
// -10⁹ <= Node.val <= 10⁹ 
// All Node.val are unique. 
// p != q 
// p and q will exist in the TopicWiseSolutions.Strings.BST.
// 
//
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 👍 7802
// 👎 232


//leetcode submit region begin(Prohibit modification and deletion)

class Solution1 {
    static class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() { } TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; } }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        return lcaForBST(root, p, q);

    }

    private TreeNode lcaForBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null) {

            if (root.val == p.val || root.val == q.val) {
                return root;

            }
            TreeNode onLeft = null, onRight = null;
            if (p.val < root.val || q.val < root.val) {
                onLeft = lcaForBST(root.left, p, q);
            }
            if (p.val > root.val || q.val > root.val) {
                onRight = lcaForBST(root.right, p, q);

            }

            if (onLeft != null && onRight != null) return root;
            if (onLeft != null) return onLeft;
            return onRight;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
