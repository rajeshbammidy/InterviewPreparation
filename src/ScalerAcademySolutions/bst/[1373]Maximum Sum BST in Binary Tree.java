package ScalerAcademySolutions.bst;//Given a binary tree root, return the maximum sum of all keys of any sub-tree
//which is also a Binary Search Tree (TopicWiseSolutions.Strings.BST).
//
// Assume a TopicWiseSolutions.Strings.BST is defined as follows:
//
// 
// The left subtree of a node contains only nodes with keys less than the 
//node's key. 
// The right subtree of a node contains only nodes with keys greater than the 
//node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
//Output: 20
//Explanation: Maximum sum in a valid Binary search tree is obtained in root 
//node with key equal to 3.
// 
//
// Example 2: 
//
// 
//
// 
//Input: root = [4,3,null,1,2]
//Output: 2
//Explanation: Maximum sum in a valid Binary search tree is obtained in a 
//single root node with key equal to 2.
// 
//
// Example 3: 
//
// 
//Input: root = [-4,-2,-5]
//Output: 0
//Explanation: All values are negatives. Return an empty TopicWiseSolutions.Strings.BST.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 4  10⁴]. 
// -4  10⁴ <= Node.val <= 4  10⁴ 
// 
//
// Related Topics Dynamic Programming Tree Depth-First Search Binary Search 
//Tree Binary Tree 👍 1681 👎 143


class Solution {
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

    static class Node {
        int min, max, value;

        public Node(int min, int max, int value) {
            this.min = min;
            this.max = max;
            this.value = value;
        }
    }

    int maxValue = 0;

    public int maxSumBST(TreeNode root) {
        maxValue = 0;
        getMaxSumBST(root);
        return maxValue;

    }


    private Node getMaxSumBST(TreeNode root) {
        if (root != null) {
            Node leftNode = getMaxSumBST(root.left);
            Node rightNode = getMaxSumBST(root.right);
            if (root.val > leftNode.max && root.val < rightNode.min) {
                int sum = root.val + leftNode.value + rightNode.value;
                maxValue = Math.max(maxValue, sum);
                return new Node(Math.min(root.val, Math.min(leftNode.min, rightNode.min)),
                        Math.max(root.val, Math.max(leftNode.max, rightNode.max)), sum
                );
            }
            return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);

        }
        return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
