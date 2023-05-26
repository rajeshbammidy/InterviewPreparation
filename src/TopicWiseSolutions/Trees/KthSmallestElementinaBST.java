package TopicWiseSolutions.Trees;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Trees|KthSmallestElementinaBST| on May,2020
 *  
 * Happy Coding :)
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ TopicWiseSolutions.Strings.BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the TopicWiseSolutions.Strings.BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 **/
public class KthSmallestElementinaBST {
    static int kth = 0;
    static int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        ans = 0;
        kth = 0;
        preOrder(root, k);
        return ans;

    }

    private void preOrder(TreeNode root, int k) {
        if (root != null) {
            preOrder(root.left, k);
            kth += 1;
            if (kth == k) ans = root.val;
            preOrder(root.right, k);

        }

    }
}
