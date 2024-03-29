package ScalerAcademySolutions.twoPointers;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.two_pointers / AnotherCountRectangles
 * Date: Jul, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 *
 * Given a sorted array of distinct integers A and an integer B, find and return how many rectangles with distinct configurations can be created using elements of this array as length and breadth whose area is lesser than B.
 *
 * (Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 *
 * The first argument given is the integer array A.
 *
 * The second argument given is integer B.
 *
 *
 *
 * Output Format
 *
 * Return the number of rectangles with distinct configurations with area less than B modulo (109 + 7).
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [1, 2]
 * B = 5
 * Input 2:
 *
 * A = [1, 2]
 * B = 1
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * 4
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * All 1X1, 2X2, 1X2 and 2X1 have area less than 5.
 * Explanation 2:
 *
 * No Rectangle is valid
 **/
public class AnotherCountRectangles {
    public int solve(int[] nums, int area) {
        int beg = 0;
        int end = nums.length - 1;
        long count = 0;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < nums.length; i++) {
            long lnb = nums[i];
            if (lnb * lnb < area) {
                count += 1;
                count = count % mod;
            }
        }
        while (beg < end) {
            long a = nums[beg], b = nums[end];
            if (a * b < area) {
                count = (count % mod + ((end - beg) * 2L) % mod) % mod;
                beg++;
            } else {
                end--;
            }
        }
        return (int) (count % mod);
    }

    public static void main(String[] args) {
        System.out.println(new AnotherCountRectangles().solve(new int[]{1, 2, 3, 4, 5}, 5));
    }
}
