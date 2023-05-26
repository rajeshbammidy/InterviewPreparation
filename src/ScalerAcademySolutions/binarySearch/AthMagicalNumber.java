package ScalerAcademySolutions.binarySearch;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.binary_search / AthMagicalNumber
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * You are given three positive integers, A, B, and C.
 *
 * Any positive integer is magical if divisible by either B or C.
 *
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 109
 *
 * 2 <= B, C <= 40000
 *
 *
 *
 * Input Format
 * The first argument given is an integer A.
 *
 * The second argument given is an integer B.
 *
 * The third argument given is an integer C.
 *
 *
 *
 * Output Format
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 1
 * B = 2
 * C = 3
 * Input 2:
 *
 * A = 4
 * B = 2
 * C = 3
 *
 *
 * Example Output
 * Output 1:
 *
 * 2
 * Output 2:
 *
 * 6
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * 1st magical number is 2.
 * Explanation 2:
 *
 * First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
 **/
public class AthMagicalNumber {

    public int solve(int n, int a, int b) {
        long beg = 1;
        long end = (long) (1e18);
        long mod = (long) (1e18);
        int intMod = (int) (1e9 + 7);
        while (beg <= end) {
            long mid = beg + (end - beg) / 2;
            long lcm = ((a % mod * b % mod) % mod) / gcd(a, b);
            long numbersDivisible = (((mid / a) % mod) + ((mid / b) % mod)) % mod - ((mid / lcm) % mod);
            if (numbersDivisible < n) {
                beg = (mid + 1) % mod;
            } else {
                end = mid - 1;
            }

        }
        return (int) ((end + 1) % (intMod));
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int a = (int) 1e9;
        int b = (int) 1e9;
        int c = (int) 1e9;
        long l = (a * b);
        System.out.println(l);

        System.out.println();
    }
}
