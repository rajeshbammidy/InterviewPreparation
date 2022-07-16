package ScalerAcademy.hashing1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.hashing1 / LargestContinuousSequenceZeroSum
 * Date: Jul, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Given an array A of N integers.
 *
 * Find the largest continuous sequence in a array which sums to zero.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 106
 *
 * -107 <= A[i] <= 107
 *
 *
 *
 * Input Format
 * Single argument which is an integer array A.
 *
 *
 *
 * Output Format
 * Return an array denoting the longest continuous sequence with total sum of zero.
 *
 * NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
 *
 *
 *
 * Example Input
 * A = [1,2,-2,4,-4]
 *
 *
 * Example Output
 * [2,-2,4,-4]
 *
 *
 * Example Explanation
 * [2,-2,4,-4] is the longest sequence with total sum of zero.
 **/
public class LargestContinuousSequenceZeroSum {

    public int[] lszero(int[] array) {
        HashMap<Integer, Integer> prefixSumToIndexMap = new HashMap<>();
        int sum = 0;
        int sIndex = 0, lIndex = 0;
        int res = -1;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum == 0) {
                res = i + 1;
                sIndex = 0;
                lIndex = i;

            }
            if (prefixSumToIndexMap.containsKey(sum)) {
                if (i - prefixSumToIndexMap.get(sum) > res) {
                    res = i - prefixSumToIndexMap.get(sum);
                    sIndex = prefixSumToIndexMap.get(sum) + 1;
                    lIndex = i;
                }
            } else {
                prefixSumToIndexMap.put(sum, i);
            }

        }
        if (res == -1) {
            return new int[]{};
        }
        int ans[] = new int[lIndex - sIndex + 1];
        for (int i = sIndex; i <= lIndex; i++) {
            ans[i - sIndex] = array[i];
        }
        return ans;

    }

}
