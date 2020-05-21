package DynamicProgramming;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by RajeshAatrayan|InterviewPreparation|DynamicProgramming|CountSquareSubmatriceswithAllOnes| on May,2020
 *  
 * Happy Coding :)
 *
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 * Example 2:
 *
 * Input: matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * Output: 7
 * Explanation:
 * There are 6 squares of side 1.
 * There is 1 square of side 2.
 * Total number of squares = 6 + 1 = 7.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 **/
public class CountSquareSubmatriceswithAllOnes {
    public int countSquares(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int dp[][] = new int[matrix.length + 1][matrix[0].length + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 1; i < dp.length; i++) {

            for (int j = 1; j < dp[0].length; j++) {

                if (matrix[i - 1][j - 1] == 1) {
                    int min = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
                    dp[i][j] = min + 1;
                    map.put(dp[i][j], map.getOrDefault(dp[i][j], 0) + 1);
                }

            }

        }
        int arr[] = new int[map.size()];
        int i = arr.length - 1;
        int sum = 0;
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {

            if ((i + 1) < arr.length) {
                arr[i] = arr[i + 1] + x.getValue();
            } else {
                arr[i] = x.getValue();
            }
            i--;
        }

        for (int x : arr) sum += x;
        return sum;


    }
}
