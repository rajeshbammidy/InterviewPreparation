package LeetCode.July22;//There are n children standing in a line. Each child is assigned a rating
//value given in the integer array ratings. 
//
// You are giving candies to these children subjected to the following 
//requirements: 
//
// 
// Each child must have at least one candy. 
// Children with a higher rating get more candies than their neighbors. 
// 
//
// Return the minimum number of candies you need to have to distribute the 
//candies to the children. 
//
// 
// Example 1: 
//
// 
//Input: ratings = [1,0,2]
//Output: 5
//Explanation: You can allocate to the first, second and third child with 2, 1, 
//2 candies respectively.
// 
//
// Example 2: 
//
// 
//Input: ratings = [1,2,2]
//Output: 4
//Explanation: You can allocate to the first, second and third child with 1, 2, 
//1 candies respectively.
//The third child gets 1 candy because it satisfies the above two conditions.
// 
//
// 
// Constraints: 
//
// 
// n == ratings.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= ratings[i] <= 2 * 10⁴ 
// 
// Related Topics Array Greedy 👍 3766 👎 284


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution135 {
    public int candy(int[] ratings) {
        int candies[] = new int[ratings.length];
        Arrays.fill(candies, 1);
        int sum = candies.length;
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                sum -= candies[i];
                sum += (candies[i - 1] + 1);
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = candies.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i]) {
                sum -= candies[i - 1];
                sum += (candies[i] + 1);
                candies[i - 1] = (candies[i] + 1);
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        System.out.println(new Solution135().candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
        ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
