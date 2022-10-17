package LeetCode.Oct22.leetcode.editor.en;//A pangram is a sentence where every letter of the English alphabet appears at
//least once. 
//
// Given a string sentence containing only lowercase English letters, return 
//true if sentence is a pangram, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
//Output: true
//Explanation: sentence contains at least one of every letter of the English 
//alphabet.
// 
//
// Example 2: 
//
// 
//Input: sentence = "leetcode"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= sentence.length <= 1000 
// sentence consists of lowercase English letters. 
// 
//
// Related Topics Hash Table String 👍 1684 👎 40


import java.util.Arrays;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1832{
    public boolean checkIfPangram(String sentence) {
        int arr[] = new int[26];
        for (char ch : sentence.toCharArray()) {
            arr[ch - 'a'] = 1;
        }
        for (int x : arr) {
            if (x == 0) return false;
        }
        return true;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
