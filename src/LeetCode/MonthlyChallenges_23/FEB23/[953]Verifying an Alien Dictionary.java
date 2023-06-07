package LeetCode.MonthlyChallenges_23.FEB23;

/**
 * In an alien language, surprisingly, they also use English lowercase letters,
 * but possibly in a different order. The order of the alphabet is some permutation
 * of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the
 * alphabet, return true if and only if the given words are sorted
 * lexicographically in this alien language.
 *
 *
 * Example 1:
 *
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is
 * sorted.
 *
 *
 * Example 2:
 *
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1],
 * hence the sequence is unsorted.
 *
 *
 * Example 3:
 *
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is
 * shorter (in size.) According to lexicographical rules "apple" > "app", because
 * 'l' > '∅', where '∅' is defined as the blank character which is less than any
 * other character (More info).
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 *
 *
 * Related Topics Array Hash Table String 👍 4277 👎 1373
 */

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

class Solution953 {
    public boolean isAlienSorted(String[] words, String order) {

        ArrayList<Character> list = new ArrayList<Character>();
        for (char ch : order.toCharArray()) {
            list.add(ch);
        }
        for (int i = 1; i < words.length; i++) {
            if (!compare(words[i - 1], words[i], list)) {
                return false;
            }
        }
        return true;

    }

    private boolean compare(String word, String word1, ArrayList<Character> list) {
        int i = 0;
        while (i < word.length() && i < word1.length()) {
            if (word.charAt(i) == word1.charAt(i)) i++;
            else if (list.indexOf(word.charAt(i)) > list.indexOf(word1.charAt(i))) return false;
            else return true;

        }
        if (word.length() > word1.length()) return false;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
