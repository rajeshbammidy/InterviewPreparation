package LeetCode.Oct22;//You are given an array of strings words. Each element of words consists of
//two lowercase English letters. 
//
// Create the longest possible palindrome by selecting some elements from words 
//and concatenating them in any order. Each element can be selected at most once. 
//
//
// Return the length of the longest palindrome that you can create. If it is 
//impossible to create any palindrome, return 0. 
//
// A palindrome is a string that reads the same forward and backward. 
//
// 
// Example 1: 
//
// 
//Input: words = ["lc","cl","gg"]
//Output: 6
//Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of 
//length 6.
//Note that "clgglc" is another longest palindrome that can be created.
// 
//
// Example 2: 
//
// 
//Input: words = ["ab","ty","yt","lc","cl","ab"]
//Output: 8
//Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt",
// of length 8.
//Note that "lcyttycl" is another longest palindrome that can be created.
// 
//
// Example 3: 
//
// 
//Input: words = ["cc","ll","xx"]
//Output: 2
//Explanation: One longest palindrome is "cc", of length 2.
//Note that "ll" is another longest palindrome that can be created, and so is 
//"xx".
// 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 10⁵ 
// words[i].length == 2 
// words[i] consists of lowercase English letters. 
// 
//
// Related Topics Array Hash Table String Greedy Counting 👍 1887 👎 37


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2131 {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> orgNonPalinMap = new HashMap<>();
        HashMap<String, Integer> revNonPalinMap = new HashMap<>();
        HashMap<String, Integer> palinMap = new HashMap<>();
        for (String word : words) {
            if (isPalindrome(word)) {
                palinMap.put(word, palinMap.getOrDefault(word, 0) + 1);
            } else {
                String revStr = getReverse(word);
                if (orgNonPalinMap.containsKey(revStr)) {
                    revNonPalinMap.put(word, revNonPalinMap.getOrDefault(word, 0) + 1);
                } else {
                    orgNonPalinMap.put(word, orgNonPalinMap.getOrDefault(word, 0) + 1);
                }
            }
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : orgNonPalinMap.entrySet()) {
            String key = entry.getKey();
            String revKey = getReverse(key);
            if (revNonPalinMap.containsKey(revKey)) {
                count += (Math.min(orgNonPalinMap.get(key), revNonPalinMap.get(revKey)) * 2);
            }
        }
        boolean isOddFound = false;
        for (Map.Entry<String, Integer> entry : palinMap.entrySet()) {
            int value = entry.getValue();
            if ((value & 1) == 0) {
                count += value;
            } else {
                count += (value - 1);
                isOddFound = true;
            }

        }
        if (isOddFound) count += 1;
        return count * 2;

    }

    private String getReverse(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        int j = word.length() - 1;
        while (j >= 0) {
            stringBuilder.append(word.charAt(j));
            j--;
        }
        return stringBuilder.toString();
    }

    private boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length() - 1;
        char car[] = word.toCharArray();
        while (i <= j) {
            if (car[i] == car[j]) {
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
