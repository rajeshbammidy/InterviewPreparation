package ScalerAcademy.hashing1;

import java.util.HashMap;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.hashing1 / LongestSubarraySumB
 * Date: Jul, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Given an array of integers A of size N and an integer B. Find the length of longest subarray having sum equal to B.
 *
 * If no such subarray exists then return -1.
 *
 *
 * Input Format
 *
 * The First argument given is the integer array A.
 * The Second argument is an integer B.
 * Output Format
 *
 * Return the length of longest subarray having sum equal to B if exists else return -1.
 * Constraints
 *
 * 1 <= N <= 100000
 * -10^6 <= A[i] <= 10^6
 * -10^9 <= B <= 10^9
 * For Example
 *
 * Input 1:
 *     A = [1, 2, 3, 4, 5]
 *     B = 10
 *
 * Output 1:
 *     4
 *
 * Input 2:
 *     A = [1, -1, -1, 1]
 *     B = 0
 * Output 2:
 *     4
 **/
public class LongestSubarraySumB {
    public int solve(int[] array, int sum) {
        HashMap<Long, Integer> map = new HashMap<>();
        long pSum = 0;
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            pSum += array[i];
            if (pSum == sum) {
                res = Math.max(res, i+1);
            }
            if (!map.containsKey(pSum))
                map.put(pSum, i);

            long x = pSum - sum;
            if (!map.containsKey(x)) continue;
            res = Math.max(res, i - map.get(x));
        }

        return res == 0 ? -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubarraySumB().solve(new int[]{-4, 0, -3, -2, 3, 2, 5, 0, -2, 4}, 2));
    }
}
