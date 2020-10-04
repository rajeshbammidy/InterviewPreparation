package Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|InorderTraversalofCartesianTree| on Sep,2020
 *  
 * Happy Coding :)
 **/
public class InorderTraversalofCartesianTree {
    public TreeNode buildTree(int[] arr) {
        return buildCatesianTree(arr, 0, arr.length - 1);
    }

    private TreeNode buildCatesianTree(int[] arr, int i, int j) {
        if (i > j) return null;
        int index = findMax(arr, i, j);
        TreeNode root=new TreeNode(arr[index]);
        root.left=buildCatesianTree(arr,i,index-1);
        root.right=buildCatesianTree(arr,index+1,j);
        return root;


    }

    private int findMax(int[] arr, int i, int j) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int k = i; k <= j; k++) {
            if (max < arr[k]) {
                max = arr[k];
                index = k;
            }
        }
        return index;
    }
}
