package ScalerAcademySolutions.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.backtracking / LetterPhone
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Given a digit string A, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 *
 *
 * The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
 *
 * NOTE: Make sure the returned strings are lexicographically sorted.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 10
 *
 *
 *
 * Input Format
 * The only argument is a digit string A.
 *
 *
 *
 * Output Format
 * Return a string array denoting the possible letter combinations.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "23"
 * Input 2:
 *
 *  A = "012"
 *
 *
 * Example Output
 * Output 1:
 *
 *  ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 * Output 2:
 *
 *  ["01a", "01b", "01c"]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  There are 9 possible letter combinations.
 * Explanation 2:
 *
 *  Only 3 possible letter combinations.
 **/
public class LetterPhone {
    HashMap<Character, String> numberToStringMap = new HashMap<>();

    public String[] letterCombinations(String str) {
        numberToStringMap.put('0', "0");
        numberToStringMap.put('1', "1");
        numberToStringMap.put('2', "abc");
        numberToStringMap.put('3', "def");
        numberToStringMap.put('4', "ghi");
        numberToStringMap.put('5', "jkl");
        numberToStringMap.put('6', "mno");
        numberToStringMap.put('7', "pqrs");
        numberToStringMap.put('8', "tuv");
        numberToStringMap.put('9', "wxyz");
        ArrayList<String> res = new ArrayList<>();
        backtrack(0, str, "", res);
        return res.toArray(new String[]{});

    }

    private void backtrack(int start, String str, String aux, ArrayList<String> res) {
        if (start == str.length()) {
            res.add(aux);
            return;
        }
        char letters[] = numberToStringMap.get(str.charAt(start)).toCharArray();
        for (int i = 0; i < letters.length; i++) {
            backtrack(start + 1, str, aux + letters[i], res);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LetterPhone().letterCombinations("8")));
    }
}
