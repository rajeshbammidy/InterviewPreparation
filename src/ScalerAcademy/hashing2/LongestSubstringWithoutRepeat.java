package ScalerAcademy.hashing2;

import java.util.*;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.hashing2 / LongestSubstringWithoutRepeat
 * Date: Jul, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Given a string A, find the length of the longest substring without repeating characters.
 *
 * Note: Users are expected to solve in O(N) time complexity.
 *
 *
 *
 * Problem Constraints
 * 1 <= size(A) <= 106
 *
 * String consists of lowerCase,upperCase characters and digits are also present in the string A.
 *
 *
 *
 * Input Format
 * Single Argument representing string A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the maximum possible length of substring without repeating characters.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = "abcabcbb"
 * Input 2:
 *
 * A = "AaaA"
 *
 *
 * Example Output
 * Output 1:
 *
 * 3
 * Output 2:
 *
 * 2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Substring "abc" is the longest substring without repeating characters in string A.
 * Explanation 2:
 *
 * Substring "Aa" or "aA" is the longest substring without repeating characters in string A.
 **/
public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String str) {
        char car[] = str.toCharArray();
        LinkedHashSet<Character> seqSet = new LinkedHashSet<>();
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < car.length; i++) {
            if (!seqSet.contains(car[i])) {
                seqSet.add(car[i]);
            } else {
                maxLen = Math.max(maxLen, seqSet.size());
                Iterator<Character> itr = seqSet.iterator();
                while (itr.hasNext()) {
                    char ch = itr.next();
                    if (ch == car[i]) break;
                    itr.remove();
                }
                seqSet.remove(car[i]);
                seqSet.add(car[i]);
            }

        }
        maxLen = Math.max(maxLen, seqSet.size());
        return maxLen;
    }

    public static void main(String[] args) {



    }
}
