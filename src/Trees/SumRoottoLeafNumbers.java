package Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|SumRoottoLeafNumbers| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class SumRoottoLeafNumbers {
    private static final int mod = 1003;
    long ans = 0;
    private static int sum = 0;

    public int sumNumbers(TreeNode root) {
        sum=0;
        ans=0;
        findSum(root,0);
        return (int) ans;

    }

    private void findSum(TreeNode root,int prev) {
        if (root != null) {
            sum = sum * 10 + root.val;
            sum = sum % mod;
            findSum(root.left,sum);
            findSum(root.right,sum);
            if (root.left == null && root.right == null) {
                ans = (ans % mod + sum % mod) % mod;
            }
            sum = prev;
        }
    }
}
