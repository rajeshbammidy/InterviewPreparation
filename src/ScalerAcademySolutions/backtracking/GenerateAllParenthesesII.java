package ScalerAcademySolutions.backtracking;

import java.util.ArrayList;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.backtracking / GenerateAllParenthesesII
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 *
 * Problem Description
 * Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 10
 *
 *
 *
 * Input Format
 * First and only argument is integer A.
 *
 *
 *
 * Output Format
 * Return a sorted list of all possible parenthesis.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 3
 * Input 2:
 *
 * A = 1
 *
 *
 * Example Output
 * Output 1:
 *
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * Output 2:
 *
 * [ "()" ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * All paranthesis are given in the output list.
 * Explanation 2:
 *
 * All paranthesis are given in the output list.
 *
 * Approach: Add the right parenthesis only when there exists left parenthesis
 **/
public class GenerateAllParenthesesII {

    public String[] generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        backtrack(n, 0, 0, "", res);
        return res.toArray(new String[]{});
    }

    private void backtrack(int n, int lp, int rp, String aux, ArrayList<String> res) {
        if (aux.length() == 2 * n) {
            res.add(aux);
        }

        if (lp < n) {
            backtrack(n, lp + 1, rp, aux + "(", res);
        }

        if (rp < lp && rp < n) {
            backtrack(n, lp, rp + 1, aux + ")", res);
        }
    }
}
