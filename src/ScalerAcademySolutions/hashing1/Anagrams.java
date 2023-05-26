package ScalerAcademySolutions.hashing1;

import java.util.*;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.hashing1 / Anagrams
 * Date: Jul, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Given an array A of N strings, return all groups of strings that are anagrams.
 *
 * Represent a group by a list of integers representing the index(1-based) in the original list. Look at the sample case for clarification.
 *
 * NOTE: Anagram is a word, phrase, or name formed by rearranging the letters, such as 'spar', formed from 'rasp'.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 104
 *
 * 1 <= |A[i]| <= 104
 *
 * Each string consists only of lowercase characters.
 *
 * The sum of the length of all the strings doesn't exceed 107
 *
 *
 *
 * Input Format
 * The first and only argument is an integer array A.
 *
 *
 *
 * Output Format
 * Return a two-dimensional array where each row describes a group.
 *
 * Note:
 *
 * Ordering of the result :
 * You should not change the relative ordering of the strings within the group suppose within a group containing A[i] and A[j], A[i] comes before A[j] if i < j.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [cat, dog, god, tca]
 * Input 2:
 *
 * A = [rat, tar, art]
 *
 *
 * Example Output
 * Output 1:
 *
 * [ [1, 4],
 * [2, 3] ]
 * Output 2:
 *
 * [ [1, 2, 3] ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * "cat" and "tca" are anagrams which correspond to index 1 and 4 and "dog" and "god" are another set of anagrams which correspond to index 2 and 3.
 * The indices are 1 based ( the first element has index 1 instead of index 0).
 * Explanation 2:
 *
 * All three strings are anagrams.
 **/
public class Anagrams {
    public int[][] anagrams(final String[] str) {
        LinkedHashMap<String, LinkedList<Integer>> map = new LinkedHashMap<>();
        int rowsRequired = 0;
        for (int i = 0; i < str.length; i++) {
            char car[] = str[i].toCharArray();
            Arrays.sort(car);
            String temp = String.valueOf(car);
            if (!map.containsKey(temp)) {
                map.put(temp, new LinkedList<Integer>());
            }
            map.get(temp).add(i + 1);
        }
        rowsRequired = map.size();
        if (rowsRequired == 0) return new int[][]{{}};
        int ans[][] = new int[rowsRequired][];
        int rows = 0;
        for (Map.Entry<String, LinkedList<Integer>> entry : map.entrySet()) {
            ans[rows++] = entry.getValue().stream().mapToInt(i -> i).toArray();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Anagrams().anagrams(new String[]{"rat", "tar", "art"})));
    }
}
