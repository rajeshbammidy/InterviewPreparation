package ScalerAcademy.binarySearch;

import java.util.Arrays;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.binary_search / AggressiveCows
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.
 *
 * His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
 *
 *
 *
 * Problem Constraints
 * 2 <= N <= 100000
 * 0 <= A[i] <= 10^9
 * 2 <= B <= N
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 * Return the largest minimum distance possible among the cows.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4, 5]
 * B = 3
 * Input 2:
 *
 * A = [1, 2]
 * B = 2
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.
 * Explanation 2:
 *
 *  The minimum distance will be 1.
 **/
public class AggressiveCows {
    public int solve(int[] stalls, int nCows) {
        Arrays.sort(stalls);
        long beg = 1;
        long end = stalls[stalls.length - 1];
        long maxMinDistance = Integer.MIN_VALUE;
        while (beg <= end) {
            long mid = beg + (end - beg) / 2;
            if (isPossibleMinDistance(stalls, mid, nCows)) {
                beg = mid + 1;
            } else {
                end = mid - 1;

            }
        }
        return (int) (beg - 1);
    }

    private boolean isPossibleMinDistance(int[] stalls, long distance, int nCows) {
        int currentCowsCount = 1;
        int prevCowAt = 0;
        long minDistance = Long.MAX_VALUE;
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - stalls[prevCowAt] >= distance) {
                minDistance = Math.min(minDistance, stalls[i] - stalls[prevCowAt]);
                prevCowAt = i;
                currentCowsCount++;
                if (currentCowsCount == nCows) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new AggressiveCows().solve(new int[]{1, 2}, 2));
    }
}
