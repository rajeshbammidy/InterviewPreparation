package LeetCode.Oct22.leetcode.editor.en;//You are given two images, img1 and img2, represented as binary, square
//matrices of size n x n. A binary matrix has only 0s and 1s as values. 
//
// We translate one image however we choose by sliding all the 1 bits left, 
//right, up, and/or down any number of units. We then place it on top of the other 
//image. We can then calculate the overlap by counting the number of positions that 
//have a 1 in both images. 
//
// Note also that a translation does not include any kind of rotation. Any 1 
//bits that are translated outside of the matrix borders are erased. 
//
// Return the largest possible overlap. 
//
// 
// Example 1: 
// 
// 
//Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
//Output: 3
//Explanation: We translate img1 to right by 1 unit and down by 1 unit.
//
//The number of positions that have a 1 in both images is 3 (shown in red).
//
// 
//
// Example 2: 
//
// 
//Input: img1 = [[1]], img2 = [[1]]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: img1 = [[0]], img2 = [[0]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// n == img1.length == img1[i].length 
// n == img2.length == img2[i].length 
// 1 <= n <= 30 
// img1[i][j] is either 0 or 1. 
// img2[i][j] is either 0 or 1. 
// 
//
// Related Topics Array Matrix 👍 940 👎 329


import java.util.ArrayList;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution835 {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        ArrayList<Pair> list1 = new ArrayList<>();
        ArrayList<Pair> list2 = new ArrayList<>();
        for (int i = 0; i < img1.length; i++) {
            for (int j = 0; j < img1[0].length; j++) {
                if (img1[i][j] == 1) {
                    list1.add(new Pair(i, j));
                }
                if (img2[i][j] == 1) {
                    list2.add(new Pair(i, j));
                }
            }
        }

        HashMap<String, Integer> map = new HashMap<>();
        int ans = 0;
        for (Pair listOnePair : list1) {
            for (Pair listTwoPair : list2) {
                int x = listOnePair.x - listTwoPair.x;
                int y = listOnePair.y - listTwoPair.y;
                map.put(x + "-" + y, map.getOrDefault(x + "-" + y, 0) + 1);
                ans = Math.max(map.get(x + "-" + y), ans);
            }
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
