package ScalerAcademy.math1;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.math_I / RepeatedSubtraction
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/
public class RepeatedSubtraction {
    public int getFinal(int A, int B) {
        return gcd(A, B);
    }

    private int gcd(int a, int b) {
        while (a != b) {
            if (a == 0 || b == 0) break;
            if (a > b) a -= b;
            else b -= a;
        }
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedSubtraction().getFinal(5,10));
    }
}
