package ScalerAcademySolutions.trees;

import java.util.ArrayList;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.trees
 * Date:Sep, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 */
public class RootToLeafPathsWithSum {
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

    ArrayList<ArrayList<Integer>> list;

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int target) {
        list = new ArrayList<>();
        findLeafSumPaths(root, target, new ArrayList<>(), 0);
        return list;
    }

    private void findLeafSumPaths(TreeNode root, int target, ArrayList<Integer> curList, int curSum) {
        if (root != null) {
            curSum += root.val;
            curList.add(root.val);
            findLeafSumPaths(root.left, target, curList, curSum);
            findLeafSumPaths(root.right, target, curList, curSum);
            if (curSum == target && root.left == null && root.right == null) {
                list.add(new ArrayList<>(curList));
            }
            curList.remove(curList.size() - 1);
        }
    }
}
