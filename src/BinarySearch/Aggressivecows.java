package BinarySearch;

import com.sun.deploy.panel.ExceptionListDialog;

import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|BinarySearch|Aggressivecows| on Apr,2020
 *  
 * Happy Coding :)
 *
 * Aggressive cows
 * Problem Description
 * Farmer John has built a new long barn, with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall, and an integer B which represent the number of cows. His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
 *
 *
 * Problem Constraints
 * 2 <= N <= 100000
 * 0 <= A[i] <= 109
 * 2 <= B <= N
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 *
 * Output Format
 * Return the largest minimum distance possible among the cows.
 *
 *
 * Example Input
 *  A = [1, 2, 3, 4, 5]
 *  B = 3
 *
 *
 * Example Output
 *  2
 *
 *
 * Example Explanation
 *  John can assign the stalls at location 1,3 and 5 to the 3 cows respectively.
 *  So the minimum distance will be 2.
 **/
public class Aggressivecows {
    public int solve(int[] arr, int cows) {
        Arrays.sort(arr);
        int beg = 1;
        int end = arr[arr.length - 1];
        int max = Integer.MIN_VALUE;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            int minDistance = verify(arr, cows, mid);
            if (minDistance == -1) {
                end = mid - 1;
            } else {
                max = Math.max(max, minDistance);
                beg = mid + 1;
            }

        }
        return max;
    }

    private int verify(int[] arr, int cows, int dis) {
        int prevCowAt = 0;
        cows--;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length && cows > 0; i++) {

            if (arr[i] - arr[prevCowAt] >= dis) {
                if (min > arr[i] - arr[prevCowAt]) min = arr[i] - arr[prevCowAt];
                prevCowAt = i;
                cows--;
            }
        }
        if (cows == 0) {
            return min;

        } else return -1;
    }
}
