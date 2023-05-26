package LeetCode.FEB23.leetcode.editor.en;

/**
 * Given the root of a binary tree, calculate the vertical order traversal of the
 * binary tree.
 *
 * For each node at position (row, col), its left and right children will be at
 * positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the
 * tree is at (0, 0).
 *
 * The vertical order traversal of a binary tree is a list of top-to-bottom
 * orderings for each column index starting from the leftmost column and ending on the
 * rightmost column. There may be multiple nodes in the same row and same column. In
 * such a case, sort these nodes by their values.
 *
 * Return the vertical order traversal of the binary tree.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation:
 * Column -1: Only node 9 is in this column.
 * Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
 * Column 1: Only node 20 is in this column.
 * Column 2: Only node 7 is in this column.
 *
 * Example 2:
 *
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * Column -2: Only node 4 is in this column.
 * Column -1: Only node 2 is in this column.
 * Column 0: Nodes 1, 5, and 6 are in this column.
 * 1 is at the top, so it comes first.
 * 5 and 6 are at the same position (2, 0), so we order them by their
 * value, 5 before 6.
 * Column 1: Only node 3 is in this column.
 * Column 2: Only node 7 is in this column.
 *
 *
 * Example 3:
 *
 *
 * Input: root = [1,2,3,4,6,5,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * This case is the exact same as example 2, but with nodes 5 and 6 swapped.
 * Note that the solution remains the same since 5 and 6 are in the same location
 * and should be ordered by their values.
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 1000
 *
 *
 * Related Topics Hash Table Tree Depth-First Search Breadth-First Search Binary
 * Tree 👍 5862 👎 4084
 */

import javafx.util.Pair;

import java.util.*;

class VerticalOrderTraversalOfABinaryTree {
    public static void main(String args[]) {
        Solution solution = new VerticalOrderTraversalOfABinaryTree().new Solution();
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
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            Map<Integer, List<Integer>> map = new TreeMap<>();
            Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
            queue.add(new Pair<>(root, 0));
            while (!queue.isEmpty()) {
                int size = queue.size();
                Map<Integer, List<Integer>> curMap = new TreeMap<>();
                for (int i = 0; i < size; i++) {
                    Pair<TreeNode, Integer> p = queue.poll();
                    TreeNode node = p.getKey();
                    int hd = p.getValue();
                    curMap.putIfAbsent(hd, new ArrayList<>());
                    curMap.get(hd).add(node.val);
                    if (node.left != null) {
                        queue.add(new Pair<>(node.left, hd - 1));
                    }
                    if (node.right != null) {
                        queue.add(new Pair<>(node.right, hd + 1));
                    }
                }

                for (Map.Entry<Integer, List<Integer>> entry : curMap.entrySet()) {
                    entry.getValue().sort(null);
                    map.putIfAbsent(entry.getKey(), new ArrayList<>());
                    map.get(entry.getKey()).addAll(entry.getValue());
                }

            }
            List<List<Integer>> res = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                res.add(entry.getValue());
            }
            return res;

        }

        ArrayList<Integer> ans;

        public ArrayList<Integer> solve(TreeNode root, int B) {
            ans = new ArrayList<>();
            preOrder(root, B, new ArrayList<Integer>());
            return ans;
        }

        private void preOrder(TreeNode root, int b, ArrayList<Integer> stack) {
            if (root != null) {
                stack.add(root.val);
                if (root.val == b) {
                    ans.addAll(new ArrayList<Integer>(stack));
                }
                preOrder(root.left, b, stack);
                preOrder(root.right, b, stack);
                stack.remove(stack.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
