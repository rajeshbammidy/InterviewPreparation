package ScalerAcademy.trees;

import java.util.*;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.trees
 * Date:Sep, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 */
public class NodeDistanceCInBinaryTree {
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

    HashMap<TreeNode, TreeNode> map;
    HashSet<TreeNode> visited;
    ArrayList<Integer> res;

    public ArrayList<Integer> solve(TreeNode root, int target, int dist) {
        map = new HashMap<>();
        res = new ArrayList<>();
        visited = new HashSet<>();
        TreeNode targetNode = findTargetNode(root, target);
        populateParent(root, null);
        findNodeAtKDistance(targetNode, dist);
        return res;

    }

    private void findNodeAtKDistance(TreeNode targetNode, int dist) {
        if (targetNode == null) return;
        if (dist == 0) {
            res.add(targetNode.val);
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(targetNode);
        visited.add(targetNode);
        int level = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode parentTreeNode = map.get(node);
                if (level == dist) res.add(node.val);

                if (parentTreeNode != null && !visited.contains(parentTreeNode)) {
                    queue.add(parentTreeNode);
                    visited.add(parentTreeNode);
                }
                if (node.left != null && !visited.contains(node.left)) {
                    queue.add(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    queue.add(node.right);
                    visited.add(node.right);
                }


            }
            if (level == dist) return;
            level++;


        }
    }

    private void populateParent(TreeNode root, TreeNode parent) {
        if (root != null) {
            map.put(root, parent);
            populateParent(root.left, root);
            populateParent(root.right, root);
        }
    }

    private TreeNode findTargetNode(TreeNode root, int target) {
        if (root != null) {
            if (root.val == target) return root;
            TreeNode left = findTargetNode(root.left, target);
            if (left != null) return left;
            TreeNode right = findTargetNode(root.right, target);
            if (right != null) return right;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode obj = new TreeNode(12);
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(obj, 1);
        System.out.println(map.get(obj));
    }
}
