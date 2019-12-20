package Hashing;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Hashing|null.java| on Dec,2019
 * Happy Coding :)
 * <p>
 * Window String
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity. Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N. Example :
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC"
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string ''.
 * If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).
 */
public class WindowString {
    public String minWindow(String org, String pat) {
        int arr[] = new int[128];
        String res = "";
        int min = Integer.MAX_VALUE;
        for (char ch : pat.toCharArray()) {
            ++arr[ch];
        }
        int c = 0, left = 0;
        for (int right = 0; right < org.length(); right++) {
            if (--arr[org.charAt(right)] >= 0) c++;

            while (c == pat.length()) {
                if (min > right - left + 1) {
                    min = right - left + 1;
                    res = org.substring(left, right + 1);
                }
                if (++arr[org.charAt(left)] > 0) {
                    c--;
                }
                left++;
            }
        }
        return res;
    }
}
