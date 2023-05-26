package TopicWiseSolutions.Trees;

import java.util.HashSet;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Trees|LeastCommonAncestor| on Jul,2020
 *  
 * Happy Coding :)
 * <p>
 * Problem Description
 * <p>
 * Find the lowest common ancestor in an unordered binary tree A given two values B and C in the tree.
 * <p>
 * Lowest common ancestor : the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= size of tree <= 100000
 * <p>
 * 1 <= B, C <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is head of tree A.
 * <p>
 * Second argument is integer B.
 * <p>
 * Third argument is integer C.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the LCA.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * <p>
 * 1
 * /  \
 * 2    3
 * B = 2
 * C = 3
 * Input 2:
 * <p>
 * 1
 * /  \
 * 2    3
 * / \
 * 4   5
 * B = 4
 * C = 5
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * LCA is 1.
 * Explanation 2:
 * <p>
 * LCA is 2.
 **/
public class LeastCommonAncestor {
    public int lca(TreeNode root, int p, int q) {

        HashSet<Integer> set = new HashSet<>();
        inorder(set, root);
        if (!set.contains(p) || !set.contains(q)) return -1;
        TreeNode lstNode = leastCommonAncestor(root, p, q);
        if (lstNode != null) {
            return lstNode.val;
        }
        return -1;


    }

    private void inorder(HashSet<Integer> set, TreeNode root) {
        if (root != null) {
            inorder(set, root.left);
            set.add(root.val);
            inorder(set, root.right);

        }
    }

    private TreeNode leastCommonAncestor(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;
        TreeNode left = leastCommonAncestor(root.left, p, q);
        TreeNode right = leastCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;

        return left != null ? left : right;
    }
}
