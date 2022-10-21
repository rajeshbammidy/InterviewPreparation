package LeetCode.Oct22.leetcode.editor.en;//The count-and-say sequence is a sequence of digit strings defined by the
//recursive formula: 
//
// 
// countAndSay(1) = "1" 
// countAndSay(n) is the way you would "say" the digit string from countAndSay(
//n-1), which is then converted into a different digit string. 
// 
//
// To determine how you "say" a digit string, split it into the minimal number 
//of substrings such that each substring contains exactly one unique digit. Then 
//for each substring, say the number of digits, then say the digit. Finally, 
//concatenate every said digit. 
//
// For example, the saying and conversion for digit string "3322251": 
// 
// Given a positive integer n, return the nᵗʰ term of the count-and-say 
//sequence. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: "1"
//Explanation: This is the base case.
// 
//
// Example 2: 
//
// 
//Input: n = 4
//Output: "1211"
//Explanation:
//countAndSay(1) = "1"
//countAndSay(2) = say "1" = one 1 = "11"
//countAndSay(3) = say "11" = two 1's = "21"
//countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 30 
// 
//
// Related Topics String 👍 2629 👎 5563


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution38 {
    public String countAndSay(int n) {

        return countedStrings(n);

    }

    private String countedStrings(int n) {
        if (n == 1) return "1";
        String str = countedStrings(n - 1);
        String cStr = countNumberStrings(str);
        return cStr;
    }

    private String countNumberStrings(String str) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        char car[] = str.toCharArray();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < car.length - 1) {
            int count = 1;
            while (i + 1 < car.length && car[i] == car[i + 1]) {
                i++;
                count++;
            }
            sb.append(count);
            sb.append(car[i]);
            i++;
        }
        if (i == car.length - 1) {
            sb.append(1);
            sb.append(car[i]);
        }
        return sb.toString();

    }


    public static void main(String[] args) {
        System.out.println(new Solution38().countAndSay(7));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
