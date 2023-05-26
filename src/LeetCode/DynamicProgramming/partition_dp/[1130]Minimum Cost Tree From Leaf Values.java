package LeetCode.DynamicProgramming.partition_dp;

/**
 * Given an array arr of positive integers, consider all binary trees such that:
 *
 *
 * Each node has either 0 or 2 children;
 * The values of arr correspond to the values of each leaf in an in-order
 * traversal of the tree.
 * The value of each non-leaf node is equal to the product of the largest leaf
 * value in its left and right subtree, respectively.
 *
 *
 * Among all possible binary trees considered, return the smallest possible sum
 * of the values of each non-leaf node. It is guaranteed this sum fits into a 32-bit
 * integer.
 *
 * A node is a leaf if and only if it has zero children.
 *
 *
 * Example 1:
 *
 *
 * Input: arr = [6,2,4]
 * Output: 32
 * Explanation: There are two possible trees shown.
 * The first has a non-leaf node sum 36, and the second has non-leaf node sum 32.
 *
 *
 * Example 2:
 *
 *
 * Input: arr = [4,11]
 * Output: 44
 *
 *
 *
 * Constraints:
 *
 *
 * 2 <= arr.length <= 40
 * 1 <= arr[i] <= 15
 * It is guaranteed that the answer fits into a 32-bit signed integer (i.e., it
 * is less than 2³¹).
 *
 *
 * Related Topics Dynamic Programming Stack TopicWiseSolutions.Greedy Monotonic Stack 👍 3697 👎 246
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1130 {
    static Node dp[][];

    static class Node {
        int maxValue;
        int nonLeafNodesCost;

        public Node(int maxValue, int nonLeafNodesCost) {
            this.maxValue = maxValue;
            this.nonLeafNodesCost = nonLeafNodesCost;
        }
    }

    public int mctFromLeafValues(int[] arr) {

        dp = new Node[arr.length][arr.length];
        Node node = findMinCostTree(arr, 0, arr.length - 1);
        return node.nonLeafNodesCost;

    }

    private Node findMinCostTree(int[] arr, int i, int j) {
        if (i > j) {
            return new Node((int) 1e4, (int) 1e4);
        }
        if (i == j) {
            return new Node(arr[i], 0);
        }
        if (dp[i][j] != null) return dp[i][j];

        int minNonLeafValue = Integer.MAX_VALUE;
        int maxLeafValue = Integer.MIN_VALUE;


        for (int k = i; k < j; k++) {

            Node leftNode = findMinCostTree(arr, i, k);
            Node rightNode = findMinCostTree(arr, k + 1, j);

            int value = leftNode.maxValue * rightNode.maxValue + leftNode.nonLeafNodesCost + rightNode.nonLeafNodesCost;
            minNonLeafValue = Math.min(value, minNonLeafValue);
            maxLeafValue = Math.max(maxLeafValue, Math.max(leftNode.maxValue, rightNode.maxValue));


        }
        dp[i][j] = new Node(maxLeafValue, minNonLeafValue);
        return dp[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
