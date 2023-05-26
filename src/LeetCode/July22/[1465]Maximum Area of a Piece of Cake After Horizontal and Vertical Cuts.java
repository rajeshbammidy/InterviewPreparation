package LeetCode.July22;//You are given a rectangular cake of size h x w and two arrays of integers
//horizontalCuts and verticalCuts where: 
//
// 
// horizontalCuts[i] is the distance from the top of the rectangular cake to 
//the iᵗʰ horizontal cut and similarly, and 
// verticalCuts[j] is the distance from the left of the rectangular cake to the 
//jᵗʰ vertical cut. 
// 
//
// Return the maximum area of a piece of cake after you cut at each horizontal 
//and vertical position provided in the arrays horizontalCuts and verticalCuts. 
//Since the answer can be a large number, return this modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
//Output: 4 
//Explanation: The figure above represents the given rectangular cake. Red 
//lines are the horizontal and vertical cuts. After you cut the cake, the green piece 
//of cake has the maximum area.
// 
//
// Example 2: 
//
// 
//Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
//Output: 6
//Explanation: The figure above represents the given rectangular cake. Red 
//lines are the horizontal and vertical cuts. After you cut the cake, the green and 
//yellow pieces of cake have the maximum area.
// 
//
// Example 3: 
//
// 
//Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 2 <= h, w <= 10⁹ 
// 1 <= horizontalCuts.length <= min(h - 1, 10⁵) 
// 1 <= verticalCuts.length <= min(w - 1, 10⁵) 
// 1 <= horizontalCuts[i] < h 
// 1 <= verticalCuts[i] < w 
// All the elements in horizontalCuts are distinct. 
// All the elements in verticalCuts are distinct. 
// 
// Related Topics Array TopicWiseSolutions.Greedy TopicWiseSolutions.Strings.Sorting 👍 1718 👎 281


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = (int) (1e9 + 7);
        int[] horizontalCutsIncludingBorders = Arrays.copyOf(horizontalCuts, horizontalCuts.length + 2);
        int[] verticalCutsIncludingBorders = Arrays.copyOf(verticalCuts, verticalCuts.length + 2);
        int m = horizontalCutsIncludingBorders.length;
        int n = verticalCutsIncludingBorders.length;
        horizontalCutsIncludingBorders[m - 2] = 0;
        horizontalCutsIncludingBorders[m - 1] = h;
        verticalCutsIncludingBorders[n - 2] = 0;
        verticalCutsIncludingBorders[n - 1] = w;
        Arrays.sort(horizontalCutsIncludingBorders);
        Arrays.sort(verticalCutsIncludingBorders);
        int maxH = Integer.MIN_VALUE;
        int maxW = Integer.MIN_VALUE;
        for (int i = 1; i < horizontalCutsIncludingBorders.length; i++) {
            maxH = Math.max(maxH, horizontalCutsIncludingBorders[i] - horizontalCutsIncludingBorders[i - 1]);
        }
        for (int i = 1; i < verticalCutsIncludingBorders.length; i++) {
            maxW = Math.max(maxW, verticalCutsIncludingBorders[i] - verticalCutsIncludingBorders[i - 1]);
        }
        long ans = 1L * maxH * maxW;
        return (int) (ans % mod);

    }

    public static void main(String[] args) {
        System.out.println(new Solution1465().maxArea(1000000000, 1000000000, new int[]{2}, new int[]{2}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
