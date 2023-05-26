package TopicWiseSolutions.BinarySearch;

import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.BinarySearch|MinimumDifference| on Apr,2020
 *  
 * Happy Coding :)
 *
 * Minimum Difference
 * Problem Description
 * You are given a 2-D matrix C of size A × B.
 * You need to build a new 1-D array of size A by taking one element from each row of the 2-D matrix in such a way that the cost of the newly build array is minimized. Cost of an array is the minimum possible value of the absolute difference between any two adjacent elements of the array. So if the newly built array is X, element picked from row 1 will become X[1], element picked from row 2 will become X[2], and so on. Determine the minimum cost of the newly build array.
 *
 *
 * Problem Constraints
 * 2 <= A <= 1000
 * 2 <= B <= 1000
 * 1 <= C[i][j] <= 106
 *
 *
 * Input Format
 * The first argument is an integer A denoting number of rows in the 2-D array.
 * The second argument is an integer B denoting number of columns in the 2-D array.
 * The third argument is a 2-D array C of size A x B.
 *
 *
 * Output Format
 * Return an integer denoting the minimum cost of the newly build array.
 *
 *
 * Example Input
 * Input 1:
 *  A = 2
 *  B = 2
 *  C = [ [8, 4]
 *       [6, 8] ]
 * Input 2:
 *  A = 3
 *  B = 2
 *  C = [ [7, 3]
 *        [2, 1]
 *        [4, 9] ]
 *
 *
 * Example Output
 * Output 1:
 *  0
 * Output 2:
 *  1
 *
 *
 * Example Explanation
 * Explanation 1:
 *  Newly build array : [8, 8]. The minimum cost will be 0 since the absolute difference will be 0(8-8).
 * Explanation 2:
 *  Newly build array : [3, 2, 4]. The minimum cost will be 1 since the minimum absolute difference will be 1(3 - 2).
 **/
public class MinimumDifference {
    private static int bsearch(int k, int[] arr) {
        int beg = 0;
        int end = arr.length - 1;
        int ans = 0;
        while (beg <= end) {
            int mid = (beg + end) / 2;

            if (arr[mid] == k) {
                ans = mid;
                break;

            }
            if (arr[mid] <= k) {
                ans = mid;
                beg = mid + 1;
            } else
                end = mid - 1;
        }
        return ans;
    }

    public int solve(int A, int B, int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        for (int i = 0; i < m; i++) Arrays.sort(arr[i]);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m - 1; i++) {

            for (int j = 0; j < n; j++) {

                int p = bsearch(arr[i][j], arr[i + 1]);

                ans = Math.min(ans, Math.abs(arr[i][j] - arr[i + 1][p]));
                if (p < arr.length - 1) {
                    ans = Math.min(ans, Math.abs(arr[i][j] - arr[i + 1][p + 1]));
                }


            }
        }
        return ans;
    }
}
