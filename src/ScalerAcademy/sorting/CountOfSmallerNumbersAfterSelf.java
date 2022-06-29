package ScalerAcademy.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.sorting / CountOfSmallerNumbersAfterSelf
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Approach: Sort the indexes instead
 **/
public class CountOfSmallerNumbersAfterSelf {
    int count[];
    int index[];

    public int[] solve(int[] array) {
        count = new int[array.length];
        index = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            index[i] = i;
        }
        mergeSort(array, 0, array.length - 1);
        return count;
    }

    private void mergeSort(int[] array, int beg, int end) {
        if (beg < end) {
            int mid = beg + (end - beg) / 2;
            mergeSort(array, beg, mid);
            mergeSort(array, mid + 1, end);
            merge(array, beg, mid, end);
        }
    }

    private void merge(int[] array, int beg, int mid, int end) {
        int temp[] = new int[end - beg + 1];
        int tempIndex = 0;
        int i = beg;
        int j = mid + 1;
        int numberOfSmallElements = 0;
        while (i <= mid && j <= end) {
            if (array[index[i]] <= array[index[j]]) {
                temp[tempIndex++] = index[i];
                count[index[i]] += numberOfSmallElements;
                i++;
            } else {
                temp[tempIndex++] = index[j++];
                numberOfSmallElements++;
            }
        }

        while (i <= mid) {
            temp[tempIndex++] = index[i];
            count[index[i]] += numberOfSmallElements;
            i++;
        }

        while (j <= end) {
            temp[tempIndex++] = index[j++];
        }

        for (int k = 0; k < temp.length; k++) {
            index[beg + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Arrays.sort(arr, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
        });
        System.out.println(Arrays.deepToString(arr));
    }
}
