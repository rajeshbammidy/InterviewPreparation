package Arrays_GFG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Arrays_GFG|MergeTwoSortedArrays.java| on Jul,2019
 * Happy Coding :)
 */

/**
 * Merging two sorted array with O(1) auxiliar space complexity so,it will take o(m*n) not less than that
 */
public class MergeTwoSortedArrays {

    public static void main(String[] args) throws Exception {
        int arr[] = {1, 5, 9, 10, 15, 20};
        int bar[] = {2, 3, 8, 13};

        sortArrays(arr, bar);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(bar));
    }

    private static void sortArrays(int[] arr, int[] bar) {
        int i, ix = arr.length;
        int j, jx = bar.length;


        for (j = jx - 1; j >= 0; j--) {//for the second array we are starting from the last element
            int last = arr[ix - 1];

            for (i = ix - 2; i >= 0 && arr[i] > bar[j]; i--) {
                arr[i + 1] = arr[i];
            }

            if (i != ix - 2 || last > bar[j]) {
                arr[i + 1] = bar[j];
                bar[j] = last;
            }


        }


    }
}
