package ScalerAcademySolutions.trees;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.trees
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 * Given 3 array of integers A, B and C.
 *
 * A represents preorder traversal of a binary tree.
 *
 * B represents inorder traversal of a binary tree.
 *
 * C represents postorder traversal of a binary tree.
 *
 * Check whether these tree traversals are of the same tree or not. If they are of same tree return 1 else return 0.
 *
 *
 * Input Format
 *
 * The arguments given are integer arrays A, B, and C.
 * Output Format
 *
 * Return 1 if they are of same tree else return 0.
 * Constraints
 *
 * 1 <= length of the array <= 1000
 * all arrays are of same length
 * 1 <= A[i], B[i], C[i] <= 10^9
 * For Example
 *
 * Input 1:
 *     A = [1, 2, 4, 5, 3]
 *     B = [4, 2, 5, 1, 3]
 *     C = [4, 5, 2, 3, 1]
 * Output 1:
 *     1
 *
 * Input 2:
 *     A = [1, 5, 4, 2, 3]
 *     B = [4, 2, 5, 1, 3]
 *     C = [4, 1, 2, 3, 5]
 *
 * Output 2:
 *     0
 */
public class CheckIfGivenPreorderInorderAndPostorderTraversalsAreOfSameTree {
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

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        flag = false;
        HashSet<Integer> set = new HashSet<>(A);
        if (!B.stream().allMatch(x -> set.contains(x)) || !C.stream().allMatch(x -> set.contains(x))) {
            return 0;
        }
        TreeNode root = buildTree(B, C);
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> preOrder = new ArrayList<>();
        preOrderTraversal(preOrder, root);
        return A.equals(preOrder) ? 1 : 0;
    }

    private void preOrderTraversal(ArrayList<Integer> preOrder, TreeNode root) {
        if (root != null) {
            preOrder.add(root.val);
            preOrderTraversal(preOrder, root.left);
            preOrderTraversal(preOrder, root.right);
        }
    }

    public TreeNode buildTree(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder) {
        posIndex = postOrder.size() - 1;
        return build(inOrder, postOrder, 0, inOrder.size() - 1);
    }

    int posIndex = 0;

    static boolean flag = false;

    private TreeNode build(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder, int ix, int px) {

        if (ix > px) return null;

        int element = postOrder.get(posIndex--);
        TreeNode node = new TreeNode(element);
        int fIndex = -1;
        for (int i = ix; i <= px; i++) {
            if (inOrder.get(i) == element) {
                fIndex = i;
                break;
            }
        }
        if (fIndex == -1) {
            flag = true;
            return null;
        }
        node.right = build(inOrder, postOrder, fIndex + 1, px);
        if (flag) return null;
        node.left = build(inOrder, postOrder, ix, fIndex - 1);
        if (flag) return null;
        return node;

    }


}
