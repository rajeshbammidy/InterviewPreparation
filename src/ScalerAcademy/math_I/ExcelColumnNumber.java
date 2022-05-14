package ScalerAcademy.math_I;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.math_I / ExcelColumnNumber
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
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
