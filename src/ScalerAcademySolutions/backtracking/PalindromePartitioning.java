package ScalerAcademySolutions.backtracking;

import java.util.ArrayList;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.backtracking / PalindromePartitioning
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Question:
 * Problem Description
 * Given a string A, partition A such that every string of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of A.
 *
 * Ordering the results in the answer : Entry i will come before Entry j if :
 * len(Entryi[0]) < len(Entryj[0]) OR
 * (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
 * (len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))
 *
 *
 * Problem Constraints
 * 1 <= len(A) <= 15
 *
 *
 *
 * Input Format
 * First argument is a string A of lowercase characters.
 *
 *
 *
 * Output Format
 * Return a list of all possible palindrome partitioning of s.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = "aab"
 * Input 2:
 *
 * A = "a"
 *
 *
 * Example Output
 * Output 1:
 *
 * [
 * ["a","a","b"]
 * ["aa","b"],
 * ]
 * Output 2:
 *
 * [
 * ["a"]
 * ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * In the given example, ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa").
 * Explanation 2:
 *
 * In the given example, only partition possible is "a" .
 **/
public class PalindromePartitioning {

    public ArrayList<ArrayList<String>> partition(String str) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        ArrayList<String> aux = new ArrayList<>();
        backtrack(str, 0, aux, res);
        return res;
    }

    private void backtrack(String str, int start, ArrayList<String> aux, ArrayList<ArrayList<String>> res) {
        if (start == str.length()) {
            res.add(new ArrayList<>(aux));
            return;
        }
        for (int i = start; i < str.length(); i++) {
            String partitionString = str.substring(0, i + 1);
            if (isPalindrome(partitionString)) {
                aux.add(partitionString);
                backtrack(str, i + 1, aux, res);
                aux.remove(aux.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String partitionString) {
        return partitionString.equals(new StringBuilder(partitionString).reverse().toString());
    }
}
