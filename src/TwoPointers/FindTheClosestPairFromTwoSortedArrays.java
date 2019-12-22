package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TwoPointers|null.java| on Dec,2019
 * Happy Coding :)
 * <p>
 * Find the closest pair from two sorted arrays
 * Given two sorted arrays of distinct integers, A and B, and an integer C, find and return the pair whose sum is closest to C and the pair has one element from each array. More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value. If there are multiple solutions find the one with minimum i and even if there are multiple values of j for the same i then return the one with minimum j. Note: Return an array with two elements {A[i], B[j]}.
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer array B.
 * The third argument given is integer C.
 * Output Format
 * Return the pair which has sum closest to C.
 * Constraints
 * 1 <= length of both the arrays <= 100000
 * 1 <= A[i], B[i] <= 10^9
 * 1 <= C <= 10^9
 * For Example
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = [2, 4, 6, 8]
 * C = 9
 * Output 1:
 * [1, 8]
 * <p>
 * Input 2:
 * A = [5, 10, 20]
 * B = [1, 2, 30]
 * C = 13
 * Output 2:
 * [10, 2]
 */
public class FindTheClosestPairFromTwoSortedArrays {
    public ArrayList<Integer> solve(ArrayList<Integer> listA, ArrayList<Integer> listB, int sum) {

        int ans = Integer.MAX_VALUE;
        int m = listA.size();
        int n = listB.size();
        int i = 0;
        int j = n - 1;
        int c = 0, d = 0;
        int prevj = Integer.MAX_VALUE;
        int previ = Integer.MAX_VALUE;
        /**
         * Put i at starting of the first sorted array and j at end index of the second sorted array and check if the sum if greater than the given sum,if yes, reduce j else increment i and find the abs difference during the process
         *
         * we maintain the previ and prevj to find the elements with min i
         */
        while (i < m && j >= 0) {
            int a = listA.get(i);
            int b = listB.get(j);
            int dif = Math.abs(listA.get(i) + listB.get(j) - sum);
            if (dif < ans || (dif == ans && j < prevj && i < previ)) {

                ans = dif;
                c = listA.get(i);
                d = listB.get(j);
            }

            if (a + b > sum) {

                prevj = j;//store the prev j
                j--;
            } else {
                previ = i;//store the prev i
                i++;
            }

        }

        ArrayList<Integer> res = new ArrayList<>(Arrays.asList(new Integer[]{c, d}));
        return res;

    }
}
