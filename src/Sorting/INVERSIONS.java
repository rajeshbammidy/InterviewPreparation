package Sorting;

import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Sorting|INVERSIONS| on May,2020
 *  
 * Happy Coding :)
 *
 * INVERSIONS
 * Given an array A, count the number of inversions in the array. Formally speaking, two elements A[i] and A[j] form an inversion if A[i] > A[j] and i < j Example:
 * A : [2, 4, 1, 3, 5]
 * Output : 3
 * as the 3 inversions are (2, 1), (4, 1), (4, 3).
 **/
public class INVERSIONS {
    public int countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);

    }

    private int mergeSort(int[] arr, int beg, int end) {
        int c = 0;
        if (beg < end) {
            int mid = beg + (end - beg) / 2;
            c += mergeSort(arr, beg, mid);
            c += mergeSort(arr, mid + 1, end);
            c += merge(arr, beg, mid, end);
        }
        return c;
    }

    private int merge(int[] arr, int beg, int mid, int end) {

        int temp[] = new int[end + 1];
        int i = beg;
        int j = mid + 1;
        int c = 0;
        int index = i;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[index++] = arr[i];
                i++;
            } else {
                temp[index++] = arr[j];
                c += (mid - i + 1);
                j++;
            }
        }

        if (i > mid) {
            while (j <= end) {
                temp[index++] = arr[j];
                j++;
            }
        }
        if (j > end) {
            while (i <= mid) {
                temp[index++] = arr[i];
                i++;
            }
        }
        for (i = beg; i <= end; i++) arr[i] = temp[i];
        return c;
    }


}

