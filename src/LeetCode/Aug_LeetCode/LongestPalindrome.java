package LeetCode.Aug_LeetCode;

/**
 * Created by RajeshAatrayan|InterviewPreparation|LeetCode.Aug_LeetCode|LongestPalindrome| on Aug,2020
 *  
 * Happy Coding :)
 *
 * 409. Longest Palindrome
 **/
public class LongestPalindrome {
    public int longestPalindrome(String str) {
        int arr[] = new int[128];
        for (int x : str.toCharArray()) arr[x]++;


        int ans = 0;
        for (int x : arr) {
            ans = ans + (x / 2 * 2);
            if (ans % 2 == 0 && x % 2 == 1) ans++;

        }
        return ans;


    }
}
