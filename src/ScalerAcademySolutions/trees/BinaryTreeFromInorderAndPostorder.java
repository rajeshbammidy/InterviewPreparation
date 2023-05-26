package ScalerAcademySolutions.trees;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.trees
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 */
public class BinaryTreeFromInorderAndPostorder {
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

    int posIndex = 0;

    public  TreeNode buildTree(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder) {
        posIndex = postOrder.size() - 1;
        return build(inOrder, postOrder, 0, inOrder.size() - 1);
    }


    private TreeNode build(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder, int ix, int px) {

        if (ix > px) return null;

        int element = postOrder.get(posIndex--);
        TreeNode node = new TreeNode(element);
        int fIndex = 0;
        for (int i = ix; i <= px; i++) {
            if (inOrder.get(i) == element) {
                fIndex = i;
                break;
            }
        }
        node.right = build(inOrder, postOrder, fIndex + 1, px);
        node.left = build(inOrder, postOrder, ix, fIndex - 1);
        return node;

    }

    public static void main(String[] args) {
        new BinaryTreeFromInorderAndPostorder().buildTree(new ArrayList<>(Arrays.asList(2, 1, 3)), new ArrayList<>(Arrays.asList(2, 3, 1)));
    }
}
