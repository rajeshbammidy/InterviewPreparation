package Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|CountNumberofSubTreeshavinggivenSum| on Jul,2020
 *  
 * Happy Coding :)
 * <p>
 * Given a binary tree and an integer X. Your task is to complete the function countSubtreesWithSumX() that returns the count of the number of subtress having total node’s data sum equal to the value X.
 * Example: For the tree given below:
 * <p>
 * 5
 * /    \
 * -10     3
 * /    \    /  \
 * 9     8  -4 7
 * <p>
 * Subtree with sum 7:
 * -10
 * /      \
 * 9        8
 * <p>
 * and one node 7.
 * <p>
 * Input:
 * First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below:
 * <p>
 * The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL child.
 * <p>
 * For example:
 * <p>
 * For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N
 * <p>
 * Output:
 * For each test case count the number of subtrees with given sum.
 * <p>
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function countSubtreesWithSumX() which takes the root node and an integer X as inputs and returns the number of subtrees of the given Binary Tree having sum exactly equal to X.
 * <p>
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(Height of the Tree).
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 103
 * -103 <= Node Value <= 103
 * <p>
 * Example:
 * Input:
 * 2
 * 5 -10 3 9 8 -4 7
 * 7
 * 1 2 3
 * 5
 * Output:
 * 2
 * 0
 * <p>
 * Explanation:
 * Testcase 1: Subtrees with sum 7 are [9, 8, -10] and [7] (refer the example in the problem description).
 * Testcase 2: No subtree has sum equal to 5.
 **/
public class CountNumberofSubTreeshavinggivenSum {
    static TreeNode head, prev;

    public TreeNode flatten(TreeNode root) {
        head = null;
        prev = null;
        flatIt(root);
        return head;
    }

    private void flatIt(TreeNode root) {
        if (root != null) {
            TreeNode tempL = root.left;
            TreeNode tempR = root.right;
            if (head == null) {
                head = root;
                prev = root;
            } else {
                root.left = null;
                root.right = null;
                prev.right = root;
                prev = root;
            }
            flatIt(tempL);
            flatIt(tempR);


        }
    }

    static int count;

    int countSubtreesWithSumX(Node root, int k) {
        count = 0;
        countSubtree(root, k);
        return count;
    }

    private int countSubtree(Node root, int k) {
        if (root != null) {

            int lc = countSubtree(root.left, k);
            int rc = countSubtree(root.right, k);
            int tc = root.data + lc + rc;
            if (tc == k) count++;
            return tc;

        }
        return 0;
    }


}
