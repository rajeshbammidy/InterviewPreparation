package ScalerAcademy.binarySearch;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.binary_search / SmallestGoodBase
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
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
 * A = "13"
 * Output 1:
 * "3"     (13 in base 3 is 111)
 *
 * Input 2:
 * A = "4681"
 * Output 2:
 * "8"     (4681 in base 8 is 11111).
 **/
public class SmallestGoodBase {
    public String solve(String str) {
        long l = Long.parseLong(str);
        int maxNumberOfBits = (int) (Math.log(l) / Math.log(2) + 1);
        for (int i = maxNumberOfBits; i >= 2; i--) {
            long base = bSearchBase(i, l);
            if (base != -1) {
                return "" + base;
            }
        }
        return "-1";
    }

    private long bSearchBase(int noBits, long l) {
        long beg = 2, end = l - 1;
        while (beg <= end) {
            long mid = beg + (end - beg) / 2;
            long num = (long) (Math.pow(mid, noBits) - 1);
            long den = mid - 1;
            long output = (num / den);
            if (l == output) return mid;
            if (output > l) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SmallestGoodBase().solve("4681"));
    }
}
