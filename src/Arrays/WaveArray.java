package Arrays;

import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Arrays|WaveArray| on Dec,2019
 * Happy Coding :)
 *
 * Wave Array
 * Given an array of integers, sort the array into a wave like array and return it, In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5..... Example
 * Given [1, 2, 3, 4]
 *
 * One possible answer : [2, 1, 4, 3]
 * Another possible answer : [4, 1, 3, 2]
 */
public class WaveArray {
    public int[] wave(int[] arr) {
        Arrays.sort(arr);//Sort the array
        int n = arr.length;
        if (n == 1) return arr;
        if (n % 2 == 0) {//even

            for (int i = n - 1; i >= 1; i -= 2) {
                int t = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = t;
            }

        } else {//odd

            for (int i = n - 2; i >= 1; i -= 2) {
                int t = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = t;
            }

        }
        return arr;
    }
}
