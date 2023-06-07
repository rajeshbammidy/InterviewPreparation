package LeetCode.MonthlyChallenges_21.Aug21;

/**
 * Created by RajeshAatrayan|InterviewPreparation|LeetCode.Aug_LeetCode|ValidPalindrome| on Aug,2020
 *  
 * Happy Coding :)
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 *
 *
 * Constraints:
 *
 * s consists only of printable ASCII characters.
 **/
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.isEmpty() || s.length() == 0) return true;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if (ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122 || ch >= 48 && ch <= 57) res = res + s.charAt(i);


        }

        int i = 0;
        int j = res.length() - 1;
        while (i < j) {
            char beg = res.charAt(i);
            char end = res.charAt(j);
            if (Character.toLowerCase(beg) != Character.toLowerCase(end)) return false;
            i++;
            j--;
        }
        return true;

    }
}
