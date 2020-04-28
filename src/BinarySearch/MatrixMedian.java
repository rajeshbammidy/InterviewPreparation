package BinarySearch;

import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|BinarySearch|MatrixMedian| on Apr,2020
 *  
 * Happy Coding :)
 **/
public class MatrixMedian {
    public int findMedian(int[][] arr) {
        int maxElement = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;
        int r = arr.length;
        int c = arr[0].length;
        int desiredElements = (r * c) / 2;
        for (int i = 0; i < r; i++) {
            minElement = Math.min(minElement, arr[i][0]);
            maxElement = Math.max(maxElement, arr[i][c - 1]);

        }

        while (minElement <= maxElement) {
            int mid = minElement + (maxElement - minElement) / 2;
            int place = 0;
            int get = 0;
            for (int i = 0; i < r; i++) {
                get = Arrays.binarySearch(arr[i], mid);
                if (get < 0) get = Math.abs(get) - 1;
                else {

                    while (get < arr.length && arr[i][get] == mid) get++;
                }
                place += get;
            }

            if (place <= desiredElements) minElement = mid + 1;
            else maxElement = mid - 1;
        }
        return minElement;


    }
}
