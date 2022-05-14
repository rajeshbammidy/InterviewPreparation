package ScalerAcademy.math_I;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.math_I / GreatestCommonDivisor
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/
public class GreatestCommonDivisor {
    public int gcd(int A, int B) {
        if(B==0)return A;
        return gcd(B,A%B);
    }
}
