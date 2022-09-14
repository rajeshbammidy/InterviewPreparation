package ScalerAcademy.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.trees
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 */
public class ZigzagLevelOrderTraversalBt {
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

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean isRightTurn = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            System.out.println(isRightTurn);
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (isRightTurn) {
                Collections.reverse(list);
            }
            res.add(list);
            isRightTurn = !isRightTurn;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(4);

        TreeNode right = new TreeNode(3);
        right.right = new TreeNode(5);

        TreeNode root = new TreeNode(1);
        root.left = left;
        root.right = right;

        System.out.println(new ZigzagLevelOrderTraversalBt().zigzagLevelOrder(root));
        ;
    }
}
