package LeetCode.Oct22;//Given a string s, reverse only all the vowels in the string and return it.
//
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both 
//lower and upper cases, more than once. 
//
// 
// Example 1: 
// Input: s = "hello"
//Output: "holle"
// 
// Example 2: 
// Input: s = "leetcode"
//Output: "leotcede"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s consist of printable ASCII characters. 
// 
//
// Related Topics Two Pointers String 👍 2619 👎 2193


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution345 {
    public String reverseVowels(String s) {
        char car[] = s.toCharArray();
        int i = 0, j = s.length() - 1;
        Character vowels[] = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        while (i <= j) {
            if (!Arrays.asList(vowels).contains(car[i])) {
                i++;
            } else if (!Arrays.asList(vowels).contains(car[j])) {
                j--;
            } else {
                char temp = car[i];
                car[i] = car[j];
                car[j] = temp;
                i++;
                j--;
            }
        }
        return String.valueOf(car);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
