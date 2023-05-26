package TopicWiseSolutions;

import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings|FirstUniqueCharacterinaString| on May,2020
 *  
 * Happy Coding :)
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 **/
public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        int arr[] = new int[26];
        Arrays.fill(arr, -1);
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == -1) {
                arr[s.charAt(i) - 'a'] = i;
            } else {
                arr[s.charAt(i) - 'a'] = Integer.MAX_VALUE;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (arr[i] != -1)
                min = Math.min(min, arr[i]);
        }
        return min == Integer.MAX_VALUE ? -1 : min;

    }
}
