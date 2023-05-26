package LeetCode.FEB23.leetcode.editor.en;

/**
 * Two strings X and Y are similar if we can swap two letters (in different
 * positions) of X, so that it equals Y. Also two strings X and Y are similar if they are
 * equal.
 *
 * For example, "tars" and "rats" are similar (swapping at positions 0 and 2),
 * and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or
 * "arts".
 *
 * Together, these form two connected groups by similarity: {"tars", "rats",
 * "arts"} and {"star"}. Notice that "tars" and "arts" are in the same group even
 * though they are not similar. Formally, each group is such that a word is in the group
 * if and only if it is similar to at least one other word in the group.
 *
 * We are given a list strs of strings where every string in strs is an anagram
 * of every other string in strs. How many groups are there?
 *
 *
 * Example 1:
 *
 *
 * Input: strs = ["tars","rats","arts","star"]
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: strs = ["omv","ovm"]
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= strs.length <= 300
 * 1 <= strs[i].length <= 300
 * strs[i] consists of lowercase letters only.
 * All words in strs have the same length and are anagrams of each other.
 *
 *
 * Related Topics Array String Depth-First Search Breadth-First Search Union Find
 * 👍 1833 👎 201
 */

import java.util.*;

class SimilarStringGroups {
    public static void main(String args[]) {
        Solution solution = new SimilarStringGroups().new Solution();
        System.out.println(solution.numSimilarGroups(new String[]{"abc", "abc"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSimilarGroups(String[] strs) {
            int n = strs.length;
            HashMap<String, Integer> map = new HashMap<>();
            int indexValue = 0;
            for (int i = 0; i < n; i++) {
                String curString = strs[i];
                int parentIndex = map.getOrDefault(curString, indexValue);
                for (int j = i + 1; j < n; j++) {
                    String newString = strs[j];
                    int count = 0;
                    for (int k = 0; k < newString.length(); k++) {
                        if (curString.charAt(k) != newString.charAt(k)) count++;
                        if (count > 2) break;
                    }

                    if (count <= 2) {
                        if (map.containsKey(newString) && !map.containsKey(curString)) {
                            map.put(curString, map.get(newString));
                        } else if (!map.containsKey(newString)){
                            map.put(newString, parentIndex);
                            if(newString.equals(curString))indexValue++;
                        }

                    }
                }
                if (!map.containsKey(curString)) {
                    map.put(curString, indexValue++);
                }
            }
            return indexValue;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
