package ScalerAcademySolutions.twoPointers;

import java.util.Arrays;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.two_pointers / SubarrayWithGivenSum
 * Date: Jul, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
 *
 * If the answer does not exist return an array with a single element "-1".
 *
 * First sub-array means the sub-array for which starting index in minimum.
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 109
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is integer B.
 *
 *
 *
 * Output Format
 * Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 *  B = 5
 * Input 2:
 *
 *  A = [5, 10, 20, 100, 105]
 *  B = 110
 *
 *
 * Example Output
 * Output 1:
 *
 *  [2, 3]
 * Output 2:
 *
 *  -1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  [2, 3] sums up to 5.
 * Explanation 2:
 *
 *  No subarray sums up to required number.
 **/
public class SubarrayWithGivenSum {
    public int[] solve(int[] array, int sum) {
        int startIndex = 0, it = 0;
        long curSum = 0;
        while (it < array.length) {
            curSum += array[it];
            while (curSum > sum) {
                curSum -= array[startIndex++];
            }
            if (curSum == sum) {
                int ans[] = new int[it - startIndex + 1];
                for (int i = startIndex; i <= it; i++) {
                    ans[i - startIndex] = array[i];
                }
                return ans;
            }
            it++;
        }
        return new int[]{-1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SubarrayWithGivenSum().solve(new int[]{1, 2, 3, 4, 5}, 5)));
    }
}
