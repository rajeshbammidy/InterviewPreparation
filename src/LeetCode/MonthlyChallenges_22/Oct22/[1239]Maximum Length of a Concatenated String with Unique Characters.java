package LeetCode.MonthlyChallenges_22.Oct22;//You are given an array of strings arr. A string s is formed by the
//concatenation of a subsequence of arr that has unique characters. 
//
// Return the maximum possible length of s. 
//
// A subsequence is an array that can be derived from another array by deleting 
//some or no elements without changing the order of the remaining elements. 
//
// 
// Example 1: 
//
// 
//Input: arr = ["un","iq","ue"]
//Output: 4
//Explanation: All the valid concatenations are:
//- ""
//- "un"
//- "iq"
//- "ue"
//- "uniq" ("un" + "iq")
//- "ique" ("iq" + "ue")
//Maximum length is 4.
// 
//
// Example 2: 
//
// 
//Input: arr = ["cha","r","act","ers"]
//Output: 6
//Explanation: Possible longest valid concatenations are "chaers" ("cha" + 
//"ers") and "acters" ("act" + "ers").
// 
//
// Example 3: 
//
// 
//Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
//Output: 26
//Explanation: The only string in arr has all 26 characters.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 16 
// 1 <= arr[i].length <= 26 
// arr[i] contains only lowercase English letters. 
// 
//
// Related Topics Array String TopicWiseSolutions.Strings.Backtracking Bit Manipulation 👍 3049 👎 217


import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1239 {
    static HashSet<Character> set;
    int maxLen = 0;

    public int maxLength(List<String> arr) {
        maxLen = 0;
        set = new HashSet<>();
        recurForMaxLen(arr, 0, new HashSet<Character>());
        return maxLen;
    }

    private void recurForMaxLen(List<String> arr, int start, HashSet<Character> characters) {
        maxLen = Math.max(maxLen, characters.size());
        for (int i = start; i < arr.size(); i++) {
            char car[] = arr.get(i).toCharArray();
            HashSet<Character> hashSet = new HashSet<>();
            boolean isUnique = true;
            if (isStringWithUniqChars(car)) {
                for (char ch : car) {
                    if (characters.contains(ch)) {
                        isUnique = false;
                        break;
                    }
                    hashSet.add(ch);
                }
                if (isUnique) {
                    characters.addAll(hashSet);
                }
            }
            if (isUnique) {
                recurForMaxLen(arr, i + 1, characters);
                for (char ch : hashSet) {
                    characters.remove(ch);
                }
            }

        }
    }

    private boolean isStringWithUniqChars(char[] car) {
        HashSet<Character> hashSet = new HashSet<>();
        for (char c : car) hashSet.add(c);
        return hashSet.size() == car.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
