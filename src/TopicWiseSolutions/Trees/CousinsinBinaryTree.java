package TopicWiseSolutions.Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Trees|CousinsinBinaryTree| on May,2020
 *  
 * Happy Coding :)
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 *
 *
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * Example 3:
 *
 *
 *
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 *
 *
 * Note:
 *
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 *
 **/


public class CousinsinBinaryTree {
    int parent1;
    int parent2;
    int d1;
    int d2;
    int curDepth;

    public boolean isCousins(TreeNode root, int x, int y) {
        parent1 = -1;
        parent2 = -1;
        d1 = 0;
        d2 = 0;
        curDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        int found = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                curDepth++;
                if (queue.size() > 0)
                    queue.add(null);
                continue;
            }

            if (temp.left != null) {
                queue.add(temp.left);
                if (match(temp.left, x, y, temp.val)) found++;

            }
            if (temp.right != null) {
                queue.add(temp.right);
                if (match(temp.right, x, y, temp.val)) found++;
            }

            if (found == 2) break;
        }

        if (found == 2) {

            if (d1 == d2 && parent1 != parent2) return true;

        }
        return false;


    }

    private boolean match(TreeNode temp, int x, int y, int parent) {
        if (temp.val == x) {
            parent1 = parent;
            d1 = curDepth + 1;
            return true;
        } else if (temp.val == y) {
            parent2 = parent;
            d2 = curDepth + 1;
            return true;
        }
        return false;
    }
}
