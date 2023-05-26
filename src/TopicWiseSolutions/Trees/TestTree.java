package TopicWiseSolutions.Trees;

import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Trees|TestTree| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class TestTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            if (cur.val == val) return root;
            else if (cur.val > val) {
                prev = cur;
                cur = cur.left;
            } else {
                prev = cur;
                cur = cur.right;
            }
        }
        if (prev != null) {
            if (prev.val > val) {
                prev.left = new TreeNode(val);
            } else {
                prev.right = new TreeNode(val);
            }
        }
        return root;


    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(new Integer[]{5, 6, 7, 8, 9}));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(new Integer[]{1, 11, 12, 13}));
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list1.toString());

    }
}
