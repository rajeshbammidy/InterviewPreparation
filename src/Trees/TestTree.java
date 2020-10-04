package Trees;

import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|TestTree| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class TestTree {

    public int[] solve(TreeNode root, int cval) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (root.val == cval) return new int[0];
        queue.add(root);
        queue.add(null);
        boolean found = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if (cur != null) {
                int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
                if (cur.left != null) {
                    if (found) ans.add(cur.left.val);
                    a = cur.left.val;
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    if (found) ans.add(cur.right.val);
                    b = cur.right.val;
                    queue.add(cur.right);
                }

                if (a == cval || b == cval) found = true;

            } else if (cur == null) {
                if (found) {
                    int res[] = new int[ans.size()];
                    for (int i = 0; i < ans.size(); i++) {
                        res[i] = ans.get(i);
                    }
                    return res;
                }
                if (queue.size() > 0) queue.add(null);
            }

        }
        int res[] = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(new Integer[]{5, 6, 7, 8, 9}));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(new Integer[]{1, 11, 12, 13}));
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list1.toString());

    }
}
