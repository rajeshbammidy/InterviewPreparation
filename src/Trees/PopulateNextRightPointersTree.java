package Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Trees|PopulateNextRightPointersTree| on Jul,2020
 *  
 * Happy Coding :)
 *
 * Populate Next Right Pointers Tree
 * Given a binary tree
 *
 *     struct TreeLinkNode {
 *       TreeLinkNode *left;
 *       TreeLinkNode *right;
 *       TreeLinkNode *next;
 *     }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 *  Note:
 * You may only use constant extra space.
 * Example :
 *
 * Given the following binary tree,
 *
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 * After calling your function, the tree should look like:
 *
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 **/

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class PopulateNextRightPointersTree {
    public void connect(TreeLinkNode root) {
        TreeLinkNode parent = root;
        TreeLinkNode childHead = null, curChild = null;
        while (parent != null) {


            while (parent != null) {


                if (parent.left != null) {
                    if (childHead == null) {
                        childHead = parent.left;
                    } else {
                        curChild.next = parent.left;
                    }
                    curChild = parent.left;
                }
                if (parent.right != null) {
                    if (childHead == null) {
                        childHead = parent.right;
                    } else {
                        curChild.next = parent.right;
                    }
                    curChild = parent.right;
                }
                parent = parent.next;


            }
            parent = childHead;
            childHead = null;
            curChild = null;


        }


    }
}
