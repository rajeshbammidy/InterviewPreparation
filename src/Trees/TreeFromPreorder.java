package Trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|TreeFromPreorder| on Apr,2020
 *  
 * Happy Coding :)
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 *
 *
 *
 * Example 1:
 *
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 *
 *
 * Note:
 *
 * 1 <= preorder.length <= 100
 * The values of preorder are distinct.
 **/
public class TreeFromPreorder {


    public int solve(ArrayList<Integer> list) {
        Stack<Integer> stack = new Stack<>();

        int root = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {

            if (root > list.get(i)) return 0;

            while (!stack.isEmpty() && stack.peek() < list.get(i)) {
                root = stack.pop();
            }
            stack.push(list.get(i));
        }
        return 1;


    }


}
