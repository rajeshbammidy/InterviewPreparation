package TopicWiseSolutions.Trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Trees|FindDiffBwnNodes| on Jul,2020
 *  
 * Happy Coding :)
 *
 *
 * K DISTANCE
 * Problem Description
 *
 * Given a balanced binary tree of integers and an integer B, count the number of pairs (a, b) where:
 *
 * a is ancestor of b.
 * Absolute difference between value of node a and value of node b <= B
 *
 *
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 105
 * 0 <= node values <= 105
 * 1 <= B <= 105
 *
 *
 *
 * Input Format
 * First argument is the root of the binary tree.
 * Second argument is an integer B.
 *
 *
 *
 * Output Format
 * Return an integer denoting the number of pairs satisfying the condition.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *         1
 *       /   \
 *      2    3
 *     / \  / \
 *    4   5 6  7
 *   /
 *  8
 *  B = 1
 * Input 2:
 *
 *     1
 *   /   \
 *  2     3
 *   \
 *    4
 *  B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Only possible pair is (1, 2).
 * Explanation 2:
 *
 *  3 possible pair exists: {(1, 2), (2, 4), (1, 3)}.
 **/
public class FindDiffBwnNodes {
    static Stack<Integer> stack;
    static int c = 0;

    public int solve(TreeNode root, int k) {
        c = 0;
        stack = new Stack<>();
        inorderFind(root, k);
        return c;
    }

    private void inorderFind(TreeNode root, int k) {

        if (root != null) {
            stack.push(root.val);
            inorderFind(root.left, k);
            inorderFind(root.right, k);
            int b = stack.pop();
            if (!stack.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>(stack);
                for (int x : list) {
                    if (Math.abs(x - b) <= k) c++;
                }
            }
        }
    }
}
