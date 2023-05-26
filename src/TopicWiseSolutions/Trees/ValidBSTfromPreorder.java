package TopicWiseSolutions.Trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Trees|ValidBSTfromPreorder| on Sep,2020
 *  
 * Happy Coding :)
 *
 * Problem Description
 *
 * You are given a preorder traversal A, of a Binary Search Tree.
 *
 * Find if it is a valid preorder traversal of a TopicWiseSolutions.Strings.BST.
 *
 *
 *
 * Problem Constraints
 * 1 <= A[i] <= 106
 *
 * 1 <= |A| <= 105
 *
 *
 *
 * Input Format
 * First and only argument is an integer array A denoting the pre-order traversal.
 *
 *
 *
 * Output Format
 * Return an integer:
 *
 * 0 : Impossible preorder traversal of a TopicWiseSolutions.Strings.BST
 * 1 : Possible preorder traversal of a TopicWiseSolutions.Strings.BST
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [7, 7, 10, 10, 9, 5, 2, 8]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 **/
public class ValidBSTfromPreorder {
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
