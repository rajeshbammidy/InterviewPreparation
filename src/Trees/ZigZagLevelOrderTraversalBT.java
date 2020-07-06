package Trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|ZigZagLevelOrderTraversalBT| on Jul,2020
 *  
 * Happy Coding :)
 **/
public class ZigZagLevelOrderTraversalBT {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if (root != null) s1.push(root);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode node = s1.pop();
                int t = node.val;
                temp.add(t);
                if (node.left != null) s2.add(node.left);
                if (node.right != null) s2.add(node.right);
            }
            if (!temp.isEmpty()) {
                list.add(new ArrayList<>(temp));
                temp.clear();
            }

            while (!s2.isEmpty()) {
                TreeNode node = s2.pop();
                int t = node.val;
                temp.add(t);
                if (node.right != null) s1.add(node.right);
                if (node.left != null) s1.add(node.left);

            }
            if (!temp.isEmpty()) {
                list.add(new ArrayList<>(temp));
                temp.clear();
            }

        }
        return list;
    }
}
