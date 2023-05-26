package TopicWiseSolutions.Trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Trees|RoottoLeafPathsWithSum| on Jul,2020
 *  
 * Happy Coding :)
 *
 * Root to Leaf Paths With Sum
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * For example: Given the below binary tree and sum = 22,
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 **/
public class RoottoLeafPathsWithSum {
    private void findSum(TreeNode root, int tsum) {
        if (root != null) {

            sum += root.val;
            stack.push(root.val);
            if (sum == tsum && root.left == null && root.right == null) {
                found = true;
                res.add(new ArrayList<Integer>(stack));
            }

            findSum(root.left, tsum);
            findSum(root.right, tsum);
            sum -= stack.pop(); }

    }

    static ArrayList<ArrayList<Integer>> res;
    static int sum = 0;
    static boolean found = false;
    static Stack<Integer> stack ;
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int tsum) {
        res = new ArrayList<>();
        sum = 0;
        found = false;
        stack = new Stack<>();
        findSum(root, tsum);
        return res;

    }
}
