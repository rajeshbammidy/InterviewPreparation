package LeetCode.Oct22.leetcode.editor.en;//Given a palindromic string of lowercase English letters palindrome, replace
//exactly one character with any lowercase English letter so that the resulting 
//string is not a palindrome and that it is the lexicographically smallest one 
//possible. 
//
// Return the resulting string. If there is no way to replace a character to 
//make it not a palindrome, return an empty string. 
//
// A string a is lexicographically smaller than a string b (of the same length) 
//if in the first position where a and b differ, a has a character strictly 
//smaller than the corresponding character in b. For example, "abcc" is 
//lexicographically smaller than "abcd" because the first position they differ is at the fourth 
//character, and 'c' is smaller than 'd'. 
//
// 
// Example 1: 
//
// 
//Input: palindrome = "abccba"
//Output: "aaccba"
//Explanation: There are many ways to make "abccba" not a palindrome, such as 
//"zbccba", "aaccba", and "abacba".
//Of all the ways, "aaccba" is the lexicographically smallest.
// 
//
// Example 2: 
//
// 
//Input: palindrome = "a"
//Output: ""
//Explanation: There is no way to replace a single character to make "a" not a 
//palindrome, so return an empty string.
// 
//
// 
// Constraints: 
//
// 
// 1 <= palindrome.length <= 1000 
// palindrome consists of only lowercase English letters. 
// 
//
// Related Topics String Greedy 👍 1773 👎 641


//leetcode submit region begin(Prohibit modification and deletion)
class Solution1327 {
    boolean isPalindrome(char arr[]) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) return "";
        char arr[] = palindrome.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > 97) {
                char c = arr[i];
                arr[i] = 'a';
                if (!isPalindrome(arr)) {
                    return new String(arr);
                }
                arr[i] = c;
            }
        }

        arr[arr.length - 1] = (char) (arr[arr.length - 1] + 1);
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1327().breakPalindrome("aba"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
