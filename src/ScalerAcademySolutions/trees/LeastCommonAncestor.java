package ScalerAcademySolutions.trees;

import java.util.HashSet;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.trees
 * Date:Sep, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 * Problem Description
 * Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
 *
 * Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.
 *
 *
 *
 * Problem Constraints
 * 1 <= size of tree <= 100000
 *
 * 1 <= B, C <= 109
 *
 *
 *
 * Input Format
 * First argument is head of tree A.
 *
 * Second argument is integer B.
 *
 * Third argument is integer C.
 *
 *
 *
 * Output Format
 * Return the LCA.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *
 *       1
 *      /  \
 *     2    3
 * B = 2
 * C = 3
 * Input 2:
 *
 *       1
 *      /  \
 *     2    3
 *    / \
 *   4   5
 * B = 4
 * C = 5
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  LCA is 1.
 * Explanation 2:
 *
 *  LCA is 2.
 */
public class LeastCommonAncestor {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public int lca(TreeNode root, int B, int C) {
        HashSet<Integer> set = new HashSet<>();
        inorder(root, set);
        if (!set.contains(B) || !set.contains(C)) {
            return -1;
        }
        return lcaOfTree(root, B, C);

    }

    private void inorder(TreeNode root, HashSet<Integer> set) {
        if (root != null) {
            inorder(root.left, set);
            set.add(root.val);
            inorder(root.right, set);
        }
    }

    private int lcaOfTree(TreeNode root, int B, int C) {
        if (root != null) {
            if (root.val == B || root.val == C) {
                return root.val;
            }

            int ls = lcaOfTree(root.left, B, C);
            int rs = lcaOfTree(root.right, B, C);
            if (ls != -1 && rs != -1) {
                return root.val;
            }
            if (ls != -1) return ls;
            return rs;

        }
        return -1;
    }
}
