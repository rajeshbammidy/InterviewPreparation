package ScalerAcademy.math1;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.math_I / ExcelColumnTitle
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

/**
 * Problem Description
 * Given a positive integer A, return its corresponding column title as it appears in an Excel sheet.
 *
 * For example:
 *
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 *
 *
 * Problem Constraints
 * 1 <= A <= 109
 *
 *
 *
 * Input Format
 * First and only argument of input contains single integer A
 *
 *
 *
 * Output Format
 * Return a string denoting the corresponding title.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 3
 * Input 2:
 *
 *
 * A = 27
 *
 *
 * Example Output
 * Output 1:
 *
 * "C"
 * Output 2:
 *
 * "AA"
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *
 * 3 corrseponds to C.
 * Explanation 2:
 *
 * 1 -> A,
 * 2 -> B,
 * 3 -> C,
 * ...
 * 26 -> Z,
 * 27 -> AA,
 * 28 -> AB
 *
 *
 * Appraoch: divide n till it becomes zero, with an extra handling where r=0;
 */
public class ExcelColumnTitle {
    public String convertToTitle(int n) {
        char carray[] = new char[26];
        for (int i = 0; i < 26; i++) {
            carray[i] = (char) (65 + i);
        }

        String str = "";
        while (n > 0) {
            int r = n % 26;
            if (r == 0) {
                r = 26;
                n = (n / 26) - 1;
            } else n = n / 26;
            str += carray[r - 1];
        }
        return new StringBuilder(str).reverse().toString();
    }


}
