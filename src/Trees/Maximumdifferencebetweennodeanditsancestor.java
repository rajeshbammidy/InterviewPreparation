package Trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|Maximumdifferencebetweennodeanditsancestor| on Jul,2020
 *  
 * Happy Coding :)
 **/
public class Maximumdifferencebetweennodeanditsancestor {


    static int ans;
    static Stack<Integer> stack;

    int maxDiff(Node root) {
        ans = Integer.MIN_VALUE;
        stack = new Stack<>();
        if (root.left == null && root.right == null) return root.data;
        preOrder(root);
        return ans;
    }

    private void preOrder(Node root) {
        if (root != null) {
            stack.push(root.data);
            preOrder(root.left);
            preOrder(root.right);
            if (!stack.isEmpty()) {
                int b = stack.pop();
                ArrayList<Integer> list = new ArrayList<>(stack);
                for (int x : stack) {
                    ans = Math.max(ans, x - b);
                }
            }

        }

    }
}
