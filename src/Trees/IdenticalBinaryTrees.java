package Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|IdenticalBinaryTrees| on Oct,2020
 *  
 * Happy Coding :)
 **/
public class IdenticalBinaryTrees {
    public int isSameTree(TreeNode rootA, TreeNode rootB) {
       return isIdentical(rootA,rootB)?1:0;
    }

    private boolean isIdentical(TreeNode rootA, TreeNode rootB) {
        if(rootA==null && rootB==null)return true;
        if(rootA!=null && rootB!=null){
            return rootA.val==rootB.val && isIdentical(rootA.left,rootB.left) && isIdentical(rootA.right,rootB.right);
        }
        return false;
    }
}
