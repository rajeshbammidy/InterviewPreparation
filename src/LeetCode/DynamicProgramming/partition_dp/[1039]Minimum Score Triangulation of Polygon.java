package LeetCode.DynamicProgramming.partition_dp;

/**
You have a convex n-sided polygon where each vertex has an integer value. You 
are given an integer array values where values[i] is the value of the iᵗʰ vertex (
i.e., clockwise order). 

 You will triangulate the polygon into n - 2 triangles. For each triangle, the 
value of that triangle is the product of the values of its vertices, and the 
total score of the triangulation is the sum of these values over all n - 2 
triangles in the triangulation. 

 Return the smallest possible total score that you can achieve with some 
triangulation of the polygon. 

 
 Example 1: 
 
 
Input: values = [1,2,3]
Output: 6
Explanation: The polygon is already triangulated, and the score of the only 
triangle is 6.
 

 Example 2: 
 
 
Input: values = [3,7,4,5]
Output: 144
Explanation: There are two triangulations, with possible scores: 3*7*5 + 4*5*7 =
 245, or 3*4*5 + 3*4*7 = 144.
The minimum score is 144.
 

 Example 3: 
 
 
Input: values = [1,3,1,4,1,5]
Output: 13
Explanation: The minimum score triangulation has score 1*1*3 + 1*1*4 + 1*1*5 + 1
*1*1 = 13.
 

 
 Constraints: 

 
 n == values.length 
 3 <= n <= 50 
 1 <= values[i] <= 100 
 

 Related Topics Array Dynamic Programming 👍 1378 👎 136

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1039 {
    static Integer dp[][];

    public int minScoreTriangulation(int[] values) {
        dp = new Integer[values.length][values.length];
        return minScoreTriangles(values, 0, values.length - 1);

    }

    private int minScoreTriangles(int[] values, int i, int j) {
        /**
         * If there are only 1/2 elements return 0;
         */
        if (i + 1 == j || i == j) {
            return 0;
        }
        if (dp[i][j] != null) return dp[i][j];
        int min = Integer.MAX_VALUE;
        /**
         * Just to ensure the correct multiplication of three sides we are taking k=i+1 here
         * If we have [1,2,3] we just need to multiple 1*2*3;
         */
        for (int k = i + 1; k < j; k++) {
            int left = minScoreTriangles(values, i, k);
            int right = minScoreTriangles(values, k, j);
            /**
             * By observing the tc [3,7,4,5], a vertex can be shared by many triangles therefore we have written the following
             * recurrence relation.
             */
            min = Math.min(min, values[i] * values[k] * values[j] + left + right);

        }
        dp[i][j] = min;
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
