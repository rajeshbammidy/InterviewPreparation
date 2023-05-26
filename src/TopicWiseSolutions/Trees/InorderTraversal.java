package TopicWiseSolutions.Trees;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Trees|InorderTraversal| on Jul,2020
 *  
 * Happy Coding :)
 *
 * Inorder Traversal
 * Problem Description
 *
 * Given a binary tree, return the inorder traversal of its nodes values.
 *
 * NOTE: Using recursion is not allowed.
 *
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 *
 *
 * Input Format
 * First and only argument is root node of the binary tree, A.
 *
 *
 *
 * Output Format
 * Return an integer array denoting the inorder traversal of the given binary tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *    1
 *     \
 *      2
 *     /
 *    3
 * Input 2:
 *
 *    1
 *   / \
 *  6   2
 *     /
 *    3
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 3, 2]
 * Output 2:
 *
 *  [6, 1, 3, 2]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The Inorder Traversal of the given tree is [1, 3, 2].
 * Explanation 2:
 *
 *  The Inorder Traversal of the given tree is [6, 1, 3, 2].
 **/
public class InorderTraversal {
    public int[] inorderTraversal(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        inorder(root,list);
        int arr[]=new int[list.size()];
        int i=0;
        for(int x:list)arr[i++]=x;
        return arr;

    }

    private void inorder(TreeNode root, ArrayList<Integer> list) {
        if(root!=null){
            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);

        }
    }
}
