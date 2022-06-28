package ScalerAcademy.sorting;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.sorting / Inversions
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 *
 * Given an array A, count the number of inversions in the array.
 *
 * Formally speaking, two elements A[i] and A[j] form an inversion if A[i] > A[j] and i < j
 *
 * Example:
 *
 * A : [2, 4, 1, 3, 5]
 * Output : 3
 * as the 3 inversions are (2, 1), (4, 1), (4, 3).
 **/
public class Inversions {
    public int countInversions(ArrayList<Integer> list) {
        return mergeSort(list, 0, list.size() - 1);
    }

    private int mergeSort(ArrayList<Integer> list, int beg, int end) {
        int count = 0;
        if (beg < end) { // at least two elements are required
            int mid = beg + (end - beg) / 2;
            count += mergeSort(list, beg, mid);
            count += mergeSort(list, mid + 1, end);
            count += merge(list, beg, mid, end);
        }


        return count;
    }

    private int merge(ArrayList<Integer> list, int beg, int mid, int end) {

        ArrayList<Integer> aux = new ArrayList<>();
        int i = beg;
        int j = mid + 1;
        int count = 0;
        while (i <= mid && j <= end) {
            if (list.get(i) <= list.get(j)) {
                aux.add(list.get(i));
                i++;
            } else {
                count += (mid - i + 1); // find the length of the inversions
                aux.add(list.get(j));
                j++;
            }
        }

        while (i <= mid) {
            aux.add(list.get(i++));
        }
        while (j <= end) {
            aux.add(list.get(j++));
        }
        for (int k = 0; k < aux.size(); k++) {
            list.set(beg + k, aux.get(k));
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
