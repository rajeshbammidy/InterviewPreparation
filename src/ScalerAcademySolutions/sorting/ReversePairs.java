package ScalerAcademySolutions.sorting;

import java.util.ArrayList;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.sorting / ReversePairs
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/
public class ReversePairs {
    public int solve(int[] array) {
        return mergeSort(array, 0, array.length - 1);
    }

    private int mergeSort(int[] array, int beg, int end) {
        int count = 0;
        if (beg < end) { // at least two elements are required
            int mid = beg + (end - beg) / 2;
            count += mergeSort(array, beg, mid);
            count += mergeSort(array, mid + 1, end);
            count += merge(array, beg, mid, end);
        }


        return count;
    }

    private int merge(int[] array, int beg, int mid, int end) {
        ArrayList<Integer> aux = new ArrayList<>();
        int i = beg;
        int j = mid + 1;
        int count = 0;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                aux.add(array[i]);
                i++;
            } else {
                int t = i;
                while (t <= mid) {
                    long pf = array[t++];
                    long lt = array[j];
                    if (pf > 2 * lt) count++; // we have to check for each element cuz it includes -ve elements
                }
                aux.add(array[j]);
                j++;
            }
        }

        while (i <= mid) {
            aux.add(array[i++]);
        }
        while (j <= end) {
            aux.add(array[j++]);
        }
        for (int k = 0; k < aux.size(); k++) {
            array[beg + k] = aux.get(k);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(-1 > -2);
    }
}
