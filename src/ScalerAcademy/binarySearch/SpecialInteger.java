package ScalerAcademy.binarySearch;

import java.math.BigInteger;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.binary_search / SpecialInteger
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 *
 * Given an integer A, we call k >= 2 a good base of A, if all digits of A base k are 1. Now given a string representing A, you should return the smallest good base of A in string format.
 *
 *
 * Input Format
 *
 * The only argument given is the string representing A.
 * Output Format
 *
 * Return the smallest good base of A in string format.
 * Constraints
 *
 * 3 <= A <= 10^18
 * For Example
 *
 * Input 1:
 *     A = "13"
 * Output 1:
 *     "3"     (13 in base 3 is 111)
 *
 * Input 2:
 *     A = "4681"
 * Output 2:
 *     "8"     (4681 in base 8 is 11111).
 **/
public class SpecialInteger {
    public String solve(String A) {
        long x = Long.parseLong(A);
        long nobits = (long) (Math.log(x) / Math.log(2)) + 1;
        BigInteger target = new BigInteger(A);
        for (long i = nobits; i >= 2; i--) {
            BigInteger low = new BigInteger("2");
            BigInteger high = new BigInteger((x - 1) + "");

            while (low.compareTo(high) == -1 || low.compareTo(high) == 0) {
                BigInteger k = low.add(high).divide(new BigInteger("2"));
                BigInteger num = k.pow((int) (i)).subtract(new BigInteger(1 + ""));
                BigInteger den = k.subtract(new BigInteger(1 + ""));
                BigInteger pow = num.divide(den);
                if (pow.compareTo(target) == 0)
                    return k.toString();
                else if (pow.compareTo(target) == -1) {
                    low = k.add(new BigInteger(1 + ""));
                } else {
                    high = k.subtract(new BigInteger(1 + ""));
                }
            }

        }
        return "";
    }
}
