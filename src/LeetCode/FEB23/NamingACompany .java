package LeetCode.FEB23;

/**
 * You are given an array of strings ideas that represents a list of names to be
 * used in the process of naming a company. The process of naming a company is as
 * follows:
 *
 *
 * Choose 2 distinct names from ideas, call them ideaA and ideaB.
 * Swap the first letters of ideaA and ideaB with each other.
 * If both of the new names are not found in the original ideas, then the name
 * ideaA ideaB (the concatenation of ideaA and ideaB, separated by a space) is a
 * valid company name.
 * Otherwise, it is not a valid name.
 *
 *
 * Return the number of distinct valid names for the company.
 *
 *
 * Example 1:
 *
 *
 * Input: ideas = ["coffee","donuts","time","toffee"]
 * Output: 6
 * Explanation: The following selections are valid:
 * - ("coffee", "donuts"): The company name created is "doffee conuts".
 * - ("donuts", "coffee"): The company name created is "conuts doffee".
 * - ("donuts", "time"): The company name created is "tonuts dime".
 * - ("donuts", "toffee"): The company name created is "tonuts doffee".
 * - ("time", "donuts"): The company name created is "dime tonuts".
 * - ("toffee", "donuts"): The company name created is "doffee tonuts".
 * Therefore, there are a total of 6 distinct company names.
 *
 * The following are some examples of invalid selections:
 * - ("coffee", "time"): The name "toffee" formed after swapping already exists in
 * the original array.
 * - ("time", "toffee"): Both names are still the same after swapping and exist in
 * the original array.
 * - ("coffee", "toffee"): Both names formed after swapping already exist in the
 * original array.
 *
 *
 * Example 2:
 *
 *
 * Input: ideas = ["lack","back"]
 * Output: 0
 * Explanation: There are no valid selections. Therefore, 0 is returned.
 *
 *
 *
 * Constraints:
 *
 *
 * 2 <= ideas.length <= 5 * 10⁴
 * 1 <= ideas[i].length <= 10
 * ideas[i] consists of lowercase English letters.
 * All the strings in ideas are unique.
 *
 *
 * Related Topics Array Hash Table String Bit Manipulation Enumeration 👍 1572 👎
 * 64
 */

import java.util.*;

class NamingACompany {
    public static void main(String args[]) {
        System.out.println(new StringBuilder("a").append("ra").toString());
        Solution solution = new NamingACompany().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long distinctNames(String[] ideas) {
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            HashSet<String> set = new HashSet<>();
            for (String str : ideas) {
                set.add(str);
                map.putIfAbsent(str.substring(1), new ArrayList<String>());
                map.get(str.substring(1)).add(str);
            }
            ArrayList<String> list = new ArrayList<>();
            for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
                list.add(entry.getKey());
            }
            int ans = 0;
            for (int i = 0; i < list.size(); i++) {
                for (String str : map.get(list.get(i))) {
                    for (int j = i + 1; j < list.size(); j++) {
                        for (String otherStr : map.get(list.get(j))) {
                            if (str.charAt(0) == otherStr.charAt(0)) continue;
                            String strA = new StringBuilder(str.substring(0, 1)).append(otherStr.substring(1)).toString();
                            String strB = new StringBuilder(otherStr.substring(0, 1)).append(str.substring(1)).toString();
                            if (!set.contains(strA) && !set.contains(strB)) ans += 2;
                        }

                    }
                }

            }

            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
