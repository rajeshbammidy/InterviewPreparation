package TopicWiseSolutions.Arrays;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Arrays|NextPermutation| on Dec,2019
 * Happy Coding :)
 *
 * Next Permutation
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N. If such arrangement is not possible, it must be rearranged as the lowest possible order i.e., sorted in an ascending order. Note:
 * 1. The replacement must be in-place, do **not** allocate extra memory.
 * 2. DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.
 * Input Format:
 * The first and the only argument of input has an array of integers, A.
 * Output Format:
 * Return an array of integers, representing the next permutation of the given array.
 * Constraints:
 * 1 <= N <= 5e5
 * 1 <= A[i] <= 1e9
 * Examples:
 * Input 1:
 *     A = [1, 2, 3]
 *
 * Output 1:
 *     [1, 3, 2]
 *
 * Input 2:
 *     A = [3, 2, 1]
 *
 * Output 2:
 *     [1, 2, 3]
 *
 * Input 3:
 *     A = [1, 1, 5]
 *
 * Output 3:
 *     [1, 5, 1]
 *
 * Input 4:
 *     A = [20, 50, 113]
 *
 * Output 4:
 *     [20, 113, 50]
 */
public class NextPermutation {
    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> list) {
        int pivot = list.size() - 2;//choose the pivot as the second last element from the list

        /**
         * Try finding the exact location of the pivot,decrement the pivot position if the element at pivot is greater than the element at i
         */
        for (int i = list.size() - 1; i >= 0 && pivot >= 0; i--) {
            if (list.get(pivot) < list.get(i)) break;
            pivot--;
        }

        /**
         * If pivot is -1 then the given list is strictly decreasing order so there is no possibility to get the next permutation
         */
        if (pivot == -1) {
            list.sort(null);
            return list;
        }

        /*
        Once you find the pivot location find the first highest number that is greater than element at pivot in the range (pivot+1,n) and swap them.
         */
        for (int i = list.size() - 1; i >= pivot + 1; i--) {
            if (list.get(i) > list.get(pivot)) {
                int t = list.get(i);
                list.set(i, list.get(pivot));
                list.set(pivot, t);
                break;
            }
        }

        /*
        Now that you have swapped the both elements now swap all the elements in the range pivot+1,n to get the elements in a strictly increasing order
         */
        pivot = pivot + 1;
        int n = list.size() - 1;
        while (pivot < n) {
            int t = list.get(n);
            list.set(n, list.get(pivot));
            list.set(pivot, t);
            pivot++;
            n--;
        }
        return list;
    }
}
