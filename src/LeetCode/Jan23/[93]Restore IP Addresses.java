package LeetCode.Jan23;

import java.util.ArrayList;
import java.util.List;

/**
 * A valid IP address consists of exactly four integers separated by single dots.
 * Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 *
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.2
 * 55.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 *
 *
 * Given a string s containing only digits, return all possible valid IP
 * addresses that can be formed by inserting dots into s. You are not allowed to reorder or
 * remove any digits in s. You may return the valid IP addresses in any order.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 *
 *
 * Example 2:
 *
 *
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 *
 *
 * Example 3:
 *
 *
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 20
 * s consists of digits only.
 *
 *
 * Related Topics String TopicWiseSolutions.Strings.Backtracking 👍 3482 👎 684
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution93 {
    private List<String> result;

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        getIpAddresses(0, s.toCharArray(), new ArrayList<String>());
        return result;
    }

    private void getIpAddresses(int index, char[] charArray, ArrayList<String> list) {
        String tempIp = "";
        /**
         * If three fragments were already added, the below code snippet will help us to add the last fragment
         * Ex: 192.168.121.___
         */
        if (list.size() == 3) {
            int i;
            /**
             * Add the remaining digits to tempIp
             */
            for (i = index; i < index + 3 && i < charArray.length; i++) {
                tempIp += charArray[i];
            }
            /**
             * If i == charArray length and all the digits were added to fragment, add the final ip to result.
             */
            if (i == charArray.length && tempIp.length() > 0) {
                if (!isValidIpFragment(tempIp)) return;
                String ans = "";
                for (String ip : list) ans += (ip + ".");
                ans += tempIp;
                result.add(ans);
            }
            return;
        }

        for (int i = index; i < index + 3 && i < charArray.length; i++) {
            tempIp += charArray[i];
            if (!isValidIpFragment(tempIp)) return;
            list.add(tempIp);
            getIpAddresses(i + 1, charArray, list);
            list.remove(list.size() - 1);
        }
    }

    /**
     * Check if the fragment is valid
     */
    boolean isValidIpFragment(String ipFrag) {
        /**
         * No fragment should have the start element as 0 if the len of the fragment is gte 2
         */
        if (ipFrag.length() > 1 && ipFrag.charAt(0) == '0') return false;
        int number = Integer.parseInt(ipFrag);
        /**
         * The fragment should be between 0 - 255
         */
        if (number < 0 || number > 255) return false;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
