package LeetCode.MonthlyChallenges_23.Jan23;

import java.util.HashMap;

/**
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in s.
 *
 *
 * Example 1:
 *
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 *
 *
 * Example 3:
 *
 *
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= pattern.length <= 300
 * pattern contains only lower-case English letters.
 * 1 <= s.length <= 3000
 * s contains only lowercase English letters and spaces ' '.
 * s does not contain any leading or trailing spaces.
 * All the words in s are separated by a single space.
 *
 *
 * Related Topics Hash Table String 👍 5335 👎 600
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> stringCharacterHashMap = new HashMap<>();
        HashMap<Character, String> characterHashMap = new HashMap<>();
        String words[] = s.split("\\s");
        if (pattern.length() != words.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (stringCharacterHashMap.containsKey(words[i])) {
                if (stringCharacterHashMap.get(words[i]) != pattern.charAt(i)) return false;
            } else {
                if (characterHashMap.containsKey(pattern.charAt(i))) return false;
                stringCharacterHashMap.put(words[i], pattern.charAt(i));
                characterHashMap.put(pattern.charAt(i), words[i]);
            }

        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
