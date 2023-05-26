package ScalerAcademySolutions.math1;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.math_I / ExcelColumnNumber
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 *
 * Question:
 * Problem Description
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the column title <= 5
 *
 *
 *
 * Input Format
 * The only argument is a string that represents the column title in the excel sheet.
 *
 *
 *
 * Output Format
 * Return a single integer that represents the corresponding column number.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  AB
 * Input 2:
 *
 *  ABCD
 *
 *
 * Example Output
 * Output 1:
 *
 *  28
 * Output 2:
 *
 *  19010
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  A -> 1
 *  B -> 2
 *  C -> 3
 *  ...
 *  Z -> 26
 *  AA -> 27
 *  AB -> 28
 **/
public class ExcelColumnNumber {
    public int titleToNumber(String str) {
        String lscToMsc = new StringBuilder(str).reverse().toString();
        int sum = 0;
        for (int i = 0; i < lscToMsc.length(); i++) {
            sum += ((int) Math.pow(26, i) * (lscToMsc.charAt(i) - 'A' + 1));
        }
        return sum;

    }
}
