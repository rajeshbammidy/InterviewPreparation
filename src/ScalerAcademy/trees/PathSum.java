package ScalerAcademy.trees;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.trees
 * Date:Sep, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 */
public class PathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public int hasPathSum(TreeNode root, int sum) {
        return isRootToPathSum(root, 0, sum);
    }

    private int isRootToPathSum(TreeNode root, int curSum, int sum) {
        if (root != null) {
            curSum += root.val;
            int lsExist = isRootToPathSum(root.left, curSum, sum);
            if (lsExist == 1) return lsExist;
            int rsExist = isRootToPathSum(root.right, curSum, sum);
            if (rsExist == 1) return rsExist;
            if (curSum == sum && root.left == null && root.right == null) return 1;
            return 0;

        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(1000);
        treeNode.right = new TreeNode(200);
        System.out.println(new PathSum().hasPathSum(treeNode, 1000));
        ;
    }
}
