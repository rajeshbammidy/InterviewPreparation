package TopicWiseSolutions.TwoPointers;

/**
 * Project: InterviewPreparation
 * Package: TopicWiseSolutions.Strings.Arrays / MergeThreeSortedArrays
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

import java.util.HashSet;
import java.util.Set;

/**
 * Given three arrays sorted in non-decreasing order, print all common elements in these arrays.
 *
 * Examples:
 *
 * Input:
 * ar1[] = {1, 5, 10, 20, 40, 80}
 * ar2[] = {6, 7, 20, 80, 100}
 * ar3[] = {3, 4, 15, 20, 30, 70, 80, 120}
 * Output: 20, 80
 *
 * Input:
 * ar1[] = {1, 5, 5}
 * ar2[] = {3, 4, 5, 5, 10}
 * ar3[] = {5, 5, 10, 20}
 * Output: 5, 5
 *
 * Appraoch:Use three pointer technique
 */
public class IntersectionOfThreeSortedArrays {
    public Integer[] findInterSection(int a[], int b[], int c[]) {
        Set<Integer> list = new HashSet<Integer>();
        int p = a.length;
        int q = b.length;
        int r = c.length;
        for (int i = 0, j = 0, k = 0; i < p && j < q && k < r; ) {

            if (a[i] == b[j] && b[j] == c[k]) {
                list.add(a[i]);
                i++;
                j++;
                k++;
                continue;
            }

            if (a[i] <= b[j] && a[i] <= c[k]) {
                i++;
            } else if (b[j] <= a[i] && b[j] < c[k]) {
                j++;
            } else {
                k++;
            }
        }
        return list.toArray(new Integer[0]);
    }
}
