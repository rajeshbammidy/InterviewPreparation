package ScalerAcademy.two_pointers;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.two_pointers / MinimizeTheAbsoluteDifference
 * Date: Jul, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Given three sorted arrays A, B and Cof not necessarily same sizes.
 *
 * Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively. i.e. minimize | max(a,b,c) - min(a,b,c) |.
 *
 * Example :
 *
 * Input:
 *
 * A : [ 1, 4, 5, 8, 10 ]
 * B : [ 6, 9, 15 ]
 * C : [ 2, 3, 6, 6 ]
 * Output:
 *
 * 1
 * Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
 **/
public class MinimizeTheAbsoluteDifference {
    public int solve(int[] a, int[] b, int[] c) {
        int i = 0, j = 0, k = 0;
        int res = Integer.MAX_VALUE;
        while (i < a.length && j < b.length && k < c.length) {
            int max = Math.max(a[i], Math.max(b[j], c[k]));
            int min = Math.min(a[i], Math.min(b[j], c[k]));
            res = Math.min(res, Math.abs(max - min));
            if (min == a[i]) i++;
            if (min == b[j]) j++;
            if (min == c[k]) k++;
        }
        return res;

    }
}
