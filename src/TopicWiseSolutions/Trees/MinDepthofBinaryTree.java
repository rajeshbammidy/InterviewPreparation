package TopicWiseSolutions.Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Trees|MinDepthofBinaryTree| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class MinDepthofBinaryTree {
    int ans = Integer.MAX_VALUE;
    static int currH = 0;

    public int minDepth(TreeNode root) {
        ans = Integer.MAX_VALUE;
        findMinDepth(root);
        return ans;
    }

    private void findMinDepth(TreeNode root) {
        if (root != null) {
            currH++;
            findMinDepth(root.left);
            findMinDepth(root.right);
            if (root.left == null && root.right == null) {
                ans = Math.min(ans, currH);
            }
            currH--;
        }
    }
}
