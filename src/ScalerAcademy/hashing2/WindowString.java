package ScalerAcademy.hashing2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.hashing2 / WindowString
 * Date: Jul, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
 * Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.
 *
 * Note:
 *
 * If there is no such window in A that covers all characters in B, return the empty string.
 * If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )
 *
 *
 * Problem Constraints
 * 1 <= size(A), size(B) <= 106
 *
 *
 *
 * Input Format
 * The first argument is a string A.
 * The second argument is a string B.
 *
 *
 *
 * Output Format
 * Return a string denoting the minimum window.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = "ADOBECODEBANC"
 * B = "ABC"
 * Input 2:
 *
 * A = "Aa91b"
 * B = "ab"
 *
 *
 * Example Output
 * Output 1:
 *
 * "BANC"
 * Output 2:
 *
 * "a91b"
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * "BANC" is a substring of A which contains all characters of B.
 * Explanation 2:
 *
 * "a91b" is the substring of A which contains all characters of B.
 **/
public class WindowString {

    public String minWindow(String str1, String str2) {
        if(str2.isEmpty())return str1;
        HashMap<Character, Integer> bMap = new HashMap<>();
        LinkedHashMap<Character, Integer> aMap = new LinkedHashMap<>();
        int minLen = Integer.MAX_VALUE;
        int index = 0;
        char aArray[] = str1.toCharArray();
        for (char ch : str2.toCharArray()) {
            bMap.put(ch, bMap.getOrDefault(ch, 0) + 1);
        }
        int bMapSize = bMap.size();
        int count = 0;
        String ans = "";
        for (int i = 0; i < str1.length(); i++) {
            aMap.put(aArray[i], aMap.getOrDefault(aArray[i], 0) + 1);
            if (bMap.get(aArray[i]) != null && aMap.get(aArray[i]) == bMap.get(aArray[i])) {
                count++;
            }
            if (count == bMapSize) {

                for (int j = index; j <= i; j++) {
                    if (minLen > (i - j + 1)) {
                        minLen = i - j + 1;
                        ans = str1.substring(j, i + 1);
                    }
                    char ch = aArray[j];
                    int value = aMap.get(ch);
                    aMap.put(ch, value - 1);
                    if (bMap.get(ch) != null && aMap.get(ch) < bMap.get(ch)) {
                        count--;
                    }
                    if (aMap.get(ch) == 0) {
                        aMap.remove(ch);
                    }
                    if (count < bMapSize) {
                        index = j + 1;
                        break;
                    }
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new WindowString().minWindow("ab", ""));
    }
}
