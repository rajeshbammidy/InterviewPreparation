package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Backtracking|LetterPhone| on May,2020
 *  
 * Happy Coding :)
 *
 * Letter Phone
 * Given a digit string, return all possible letter combinations that the number could represent. A mapping of digit to letters (just like on the telephone buttons) is given below.  The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
 * Input: Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Make sure the returned strings are lexicographically sorted.
 **/
public class LetterPhone {
    public List<String> letterCombinations(String inp) {
        List<String> res = new ArrayList<>();
        if(inp.equals(""))return res;
        String str[] = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        backtrackForStrings(res, 0, inp, "", str);
        return res;
    }

    private void backtrackForStrings(List<String> res, int i, String dig, String aux, String[] inp) {
        if (i == dig.length()) {
            res.add(aux);
            return;
        }
        String sample = inp[Integer.parseInt(dig.charAt(i) + "")];
        for (int j = 0; j < sample.length(); j++) {
            backtrackForStrings(res, i + 1, dig, aux + sample.charAt(j), inp);
        }
    }
}
