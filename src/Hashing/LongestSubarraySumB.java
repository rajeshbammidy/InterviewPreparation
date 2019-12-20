package Hashing;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Hashing|null.java| on Dec,2019
 * Happy Coding :)
 * <p>
 * Longest Subarray Sum B
 * Given an array of integers A of size N and an integer B. Find the length of longest subarray having sum equal to B. If no such subarray exists then return -1.
 * Input Format
 * The First argument given is the integer array A.
 * The Second argument is an integer B.
 * Output Format
 * Return the length of longest subarray having sum equal to B if exists else return -1.
 * Constraints
 * 1 <= N <= 100000
 * -10^6 <= A[i] <= 10^6
 * -10^9 <= B <= 10^9
 * For Example
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = 10
 * <p>
 * Output 1:
 * 4
 * <p>
 * Input 2:
 * A = [1, -1, -1, 1]
 * B = 0
 * Output 2:
 * 4
 */
public class LongestSubarraySumB {
    public int solve(ArrayList<Integer> list, int k) {
        int max = -1;
        LinkedHashMap<Long, Integer> presum = new LinkedHashMap<Long, Integer>();
        long sum = 0;

        presum.put(new Long(0), -1);
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);

            if (presum.containsKey(sum - k)) {
                max = Math.max(max, i - presum.get(sum - k));
            }

            if (presum.get(sum) == null) {
                presum.put(sum, i);
            }


        }

        return max;

    }
}
