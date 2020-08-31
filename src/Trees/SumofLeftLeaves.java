package Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|SumofLeftLeaves| on Aug,2020
 *  
 * Happy Coding :)
 **/
public class SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {

        if (root != null) {
            int sum = 0;
            if (root.left != null) {
                sum = root.left.left == null && root.left.right == null ? root.left.val : 0;
            }
            return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
        return 0;

    }
}
