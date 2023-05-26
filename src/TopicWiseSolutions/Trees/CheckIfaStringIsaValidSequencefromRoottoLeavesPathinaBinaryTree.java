package TopicWiseSolutions.Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Trees|CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree| on May,2020
 *  
 * Happy Coding :)
 **/

/**
 * Class definition
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree {
    static String obt = "";
    static boolean res = false;

    public boolean isValidSequence(TreeNode root, int[] arr) {
        String given = "";
        obt = "";
        res = false;
        for (int x : arr) given += x;
        preorder(root, given);
        return res;

    }

    private void preorder(TreeNode root, String given) {
        if (root != null) {
            obt += root.val;
            preorder(root.left, given);
            preorder(root.right, given);
            //If the current node is a leaf node
            if (root.left == null && root.right == null) {
                if (obt.equals(given)) {
                    res = true;
                }
            }
            //delete the appended character
            if (obt.length() != 0) ;
            obt = obt.substring(0, obt.length() - 1);


        }


    }

}
