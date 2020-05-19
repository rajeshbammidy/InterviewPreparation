package Sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Sorting|Countofsmallernumbersafterself| on May,2020
 *  
 * Happy Coding :)
 *
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 * Example:
 *
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 **/
public class Countofsmallernumbersafterself {
    int count[];
    int index[];

    public List<Integer> countSmaller(int[] arr) {
        count = new int[arr.length];
        index = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            index[i] = i;
        }
        mergeSort(arr, 0, arr.length - 1);
        List<Integer> list=new ArrayList<>();
        for(int x:count)list.add(x);
        return list;

    }

    private void mergeSort(int[] arr, int i, int l) {
        if (i < l) {
            int mid = (i + l) / 2;
            mergeSort(arr, i, mid);
            mergeSort(arr, mid + 1, l);
            merge(arr, i, mid, l);
        }
    }

    private void merge(int[] arr, int s, int mid, int l) {
        int i = s;
        int n1 = mid;
        int j = mid + 1;
        int n2 = l;
        int temp[] = new int[n2 + 1];
        for (int m = s; m <= l; m++) temp[m] = index[m];
        int k = s;
        int rc = 0;
        while (i <= n1 || j <= n2) {
            if (j<=n2 && arr[temp[i]] > arr[temp[j]]) {
                rc++;
                index[k++] = temp[j++];
            } else {
                count[temp[i]] += rc;
                index[k++] = temp[i++];
            }

        }

    }
}
