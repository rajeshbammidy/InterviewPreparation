package TopicWiseSolutions.Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Trees|FoldableBinaryTree| on Jul,2020
 *  
 * Happy Coding :)
 *
 * Given a binary tree, check if the tree can be folded or not. A tree can be folded if left and right subtrees of the tree are structure wise same. An empty tree is considered as foldable.
 * Consider the below trees:
 * (a) and (b) can be folded.
 * (c) and (d) cannot be folded.
 *
 *
 * (a)
 *        10
 *      /    \
 *     7      15
 *      \    /
 *       9  11
 * (b)
 *         10
 *        /  \
 *       7    15
 *      /      \
 *     9       11
 * (c)
 *         10
 *        /  \
 *       7   15
 *      /    /
 *     5   11
 * (d)
 *          10
 *        /   \
 *       7     15
 *     /  \    /
 *    9   10  12
 * Input:
 * First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below:
 * The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL child.
 *
 * For example:
 *
 * For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N
 *
 * Output:
 * Print "Yes" (without quotes) if the tree is foldable and "No" ( without quotes) if it is unfoldable.
 *
 * Your Task:
 * The task is to complete the function isFoldable() that takes root of the tree as input and returns true or false depending upon whether the tree is foldable or not.
 *
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(Height of the Tree).
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= n <= 103
 * 1 <= data of node <= 104
 *
 * Example:
 * Input:
 * 2
 * 10 7 15 N 9 11 N
 * 10 7 15 5 N 11 N
 * Output:
 * Yes
 * No
 *
 * Explanation:
 * Testcase 1: Given tree is
 *                               10
 *                            /         \
 *                          7          15
 *                       /      \      /      \
 *                     N      9    11     N
 * Hence, above tree is structure wise same so it is foldable.
 * Testcase 2: Given tree is
 *                                 10
 *                             /           \
 *                           7            15
 *                        /       \       /       \
 *                      5        N    11      N
 * Hence, above tree is not structure wise same so it is not foldable.
 *
 *
 *
 **/

public class FoldableBinaryTree {
    boolean IsFoldable(Node node) {
        if (node == null) return true;
        return foldable(node.left, node.right);
    }

    private boolean foldable(Node s, Node t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        boolean ans = true;
        if (s.left != null && t.right == null || s.left== null && t.right != null) return false;
        if (s.right != null && t.left == null || s.right == null && t.left != null) return false;

        return foldable(s.left, t.right) && foldable(s.right,t.left);

    }
}
