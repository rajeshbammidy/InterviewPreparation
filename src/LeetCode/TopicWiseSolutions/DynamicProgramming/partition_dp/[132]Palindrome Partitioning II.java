package LeetCode.TopicWiseSolutions.DynamicProgramming.partition_dp;

/**
Given a string s, partition s such that every substring of the partition is a 
palindrome. 

 Return the minimum cuts needed for a palindrome partitioning of s. 

 
 Example 1: 

 
Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 
cut.
 

 Example 2: 

 
Input: s = "a"
Output: 0
 

 Example 3: 

 
Input: s = "ab"
Output: 1
 

 
 Constraints: 

 
 1 <= s.length <= 2000 
 s consists of lowercase English letters only. 
 

 Related Topics String Dynamic Programming 👍 4367 👎 100

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer dp[][];
    static int MAX_VALUE = (int) 1e4;

    public int minCut(String s) {
        dp = new Integer[s.length()][s.length()];
        return minCount(s, 0, s.length() - 1);

    }

    private int minCount(String s, int i, int j) {
        if (i > j) return 0;
        if (isPalindrome(s, i, j)) {
            return 0;
        }
        if (dp[i][j] != null) return dp[i][j];
        int min = MAX_VALUE;
        /**
         * Recursively call the right part only when the left substring is a palindrome.
         * You might be thinking "If the left substring is not palindrome we can partition it further, to get the min partitions at i"
         * But those partitions can be taken care by the right recursive call we make,so we dont have make the left recursive call
         * again and again
         *
         */
        for (int k = i; k < j; k++) {
            if (isPalindrome(s, i, k)) {
                min = Math.min(1 + minCount(s, k + 1, j), min);
            }

        }
        dp[i][j] = min;
        return min;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
