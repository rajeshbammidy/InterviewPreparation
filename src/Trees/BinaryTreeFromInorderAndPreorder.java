package Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|BinaryTreeFromInorderAndPreorder| on Jul,2020
 *  
 * Happy Coding :)
 **/
public class BinaryTreeFromInorderAndPreorder {
    static int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        TreeNode root = build(preorder, inorder, 0, inorder.length - 1);
        return root;
    }

    private TreeNode build(int[] preorder, int[] inorder, int is, int ie) {
        if (is > ie) return null;
        int index = 0;

        TreeNode node = new TreeNode(preorder[preIndex++]);
        for (int i = is; i <= ie; i++) {

            if (inorder[i] == node.val) {
                index = i;
                break;
            }


        }

        node.left = build(preorder, inorder, is, index - 1);
        node.right = build(preorder, inorder, index + 1, ie);
        return node;

    }
}
