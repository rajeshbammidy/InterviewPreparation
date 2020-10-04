package Trees;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|SortedArrayToBalancedBST| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class SortedArrayToBalancedBST {
    private TreeNode toBST(ArrayList<Integer> nums, int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = (start + end)/2;
        TreeNode root =  new TreeNode(nums.get(mid));
        root.left = toBST(nums, start, mid - 1);
        root.right = toBST(nums, mid + 1, end);

        return root;
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(ArrayList<Integer> A) {
        if(A.size() == 0) {
            return null;
        }
        return toBST(A, 0, A.size() - 1);
    }
}
