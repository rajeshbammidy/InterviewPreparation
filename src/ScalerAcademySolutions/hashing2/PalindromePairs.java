package ScalerAcademySolutions.hashing2;

import java.util.*;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.hashing2 / PalindromePairs
 * Date: Jul, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 *
 * Given a list of unique words A, find all pairs of distinct indices (i, j) in the given list such that concatenation of the two words, i.e. A[i] + A[j] is a palindrome.
 *
 * Note: A string is a palindrome if it reads the same backward as forward.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= length of the list A <= 1000
 *
 * 1 <= lenght of words in list A <= 100
 *
 *
 *
 * Input Format
 *
 * The only argument given is the string array A.
 *
 *
 *
 * Output Format
 *
 * Return the list of all pairs of distinct indices such that concatenation of the two words, i.e. A[i] + A[j] is a palindrome.
 *
 * You can return the list in any order.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = ["abcd", "dcba", "lls", "s", "sssll"]
 * Input 2:
 *
 * A =  ["bat", "tab", "cat"]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * [ [0,1], [1,0], [3,2], [2,4] ]
 * Output 2:
 *
 * [[0,1],[1,0]]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Explanation 2:
 *
 * The palindromes are ["battab","tabbat"]
 **/
public class PalindromePairs {
    static public int[][] solve(String[] strings) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        LinkedHashMap<Integer, LinkedList<Integer>> ans = new LinkedHashMap<>();
        for (int i = 0; i < strings.length; i++) {
            map.put(strings[i], i);
        }
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            for (int j = 0; j < str.length(); j++) {
                String sp = str.substring(j, str.length());
                String pp = str.substring(0, j);

                String sufp = new StringBuilder(sp).reverse().toString();
                String prep = new StringBuilder(pp).reverse().toString();
                if (!prep.isEmpty() && map.containsKey(prep)) {
                    if (map.get(prep) != i && isPalindrome(sp)) {
                        if (ans.get(i) == null) {
                            ans.put(i, new LinkedList<>());
                        }
                        ans.get(i).add(map.get(prep));
                        count++;
                    }

                }
                if (map.containsKey(sufp)) {
                    if (map.get(sufp) != i && isPalindrome(pp)) {
                        if (ans.get(map.get(sufp)) == null) {
                            ans.put(map.get(sufp), new LinkedList<>());
                        }
                        ans.get(map.get(sufp)).add(i);
                        count++;
                    }

                }
            }
        }
        int size = ans.size();
        if (size == 0) {
            return new int[][]{{}};
        }

        int res[][] = new int[count][2];
        int row = 0;
        for (Map.Entry<Integer, LinkedList<Integer>> entry : ans.entrySet()
        ) {
            for (int x : entry.getValue()) {
                res[row++] = new int[]{entry.getKey(), x};
            }

        }
        return res;

    }

    private static boolean isPalindrome(String str) {
        return str.equals(
                new StringBuilder(str).reverse().toString()
        );
    }

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(new PalindromePairs().solve(new String[]{"cba", "bc", "abc"})));


    }
}
