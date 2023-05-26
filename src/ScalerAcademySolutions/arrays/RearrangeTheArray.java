package ScalerAcademySolutions.arrays;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.arrays / RearrangeTheArray
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

/**
 * Idea:
 * Since the numbers are from 0 to n-1 we can make use of n to store the extra information.
 * at every arr[i]+=(n*j) where j is the value which should be there in arr[i]
 */
public class RearrangeTheArray {
    public int[] solve(int[] arr) {
        long n = arr.length;
        long res[] = new long[(int) n];
        int k = 0;
        /**
         * We are copying into long to avoid the overflow issues
         */
        for (int x : arr) res[k++] = x;

        for (int i = 0; i < n; i++) {
            /*
            Here are we are modifying the array elements by multiplying it with the n(len of array)
             */
            res[(int) (res[i] % n)] += (i * n);
        }
        for (int i = 0; i < n; i++) {
            res[i] = res[i] / n;//this will give us the desired output
        }
        k = 0;
        for (long x : res) arr[k++] = (int) (x);
        return arr;

    }
}
