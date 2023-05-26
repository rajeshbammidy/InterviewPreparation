package TopicWiseSolutions.Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Trees|ChildrenSumParent| on Jul,2020
 *  
 * Happy Coding :)
 *
 * Given a Binary Tree. Check whether all of its nodes have the value equal to the sum of their child nodes.
 *
 * Input:
 * First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below:
 *
 * The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL child.
 *
 * For example:
 *
 *
 * For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N
 *
 * Output:
 * Return 1 if the given tree satisfies the given property else return 0.
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function isSumProperty() that takes the root Node of the Binary Tree as input and returns 1 if all the nodes in the tree satisfy the following properties. Else, it returns 0.
 * For every node, data value must be equal to the sum of data values in left and right children. Consider data value as 0 for NULL child.  Also, leaves are considered to follow the property.
 *
 * Expected Time Complexiy: O(N).
 * Expected Auxiliary Space: O(Height of the Tree).
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 100
 * 1 <= Data on nodes <= 1000
 *
 * Example:
 * Input:
 * 2
 * 10 10
 * 1 4 3 5 N
 * Output:
 * 1
 * 0
 *
 * Explanation:
 * Testcase 1: Tree is like:
 *             10
 *            /
 *         10
 *
 * Here, every node is sum of its left and right child.
 * Testcase 2: Here, 1 is the root node and 4, 3 are its child nodes. 4 + 3 = 7 which is not equal to the value of root node. Hence, this tree does not satisfy the given conditions.
 **/

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

public class ChildrenSumParent {
    public static int isSumProperty(Node root) {
        // add your code here
        return childSum(root) ? 1 : 0;


    }

    private static boolean childSum(Node root) {
        if (root != null) {

            if (root.left == null && root.right == null) return true;
            int sum = 0;
            if (root.left != null) sum += root.left.data;
            if (root.right != null) sum += root.right.data;

            return sum == root.data && childSum(root.left) && childSum(root.right);

        }
        return true;
    }
}
