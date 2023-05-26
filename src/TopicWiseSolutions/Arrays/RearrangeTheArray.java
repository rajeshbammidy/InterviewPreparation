package TopicWiseSolutions.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Arrays|RearrangeTheArray| on Dec,2019
 * Happy Coding :)
 *
 * Rearrange the array
 * Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)]. Rearrange the array such that A[i] = j is changed to A[j] = i for all i and j form 0 to N-1. Note: Try solving this with O(1) extra space.
 * Input Format
 * The only argument given is the integer array A.
 * Output Format
 * Return the rearranged array A.
 * Constraints
 * 1 <= N <= 100000
 * 0 <= A[i] < N
 * For Example
 * Input 1:
 *     A = [1, 2, 3, 4, 0]
 * Output 1:
 *     [4, 0, 1, 2, 3]
 *
 * Input 2:
 *     A = [2, 0, 1, 3]
 * Output 2:
 *     [1, 2, 0, 3]
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
