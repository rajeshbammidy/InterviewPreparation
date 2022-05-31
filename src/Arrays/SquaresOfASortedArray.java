package Arrays;

/**
 * Project: InterviewPreparation
 * Package: Arrays / SquaresOfASortedArray
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

import java.util.ArrayList;

/**
 * Approach: Two pointers
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        ArrayList<Integer> negNumbers = new ArrayList<>();
        ArrayList<Integer> posNumbers = new ArrayList<>();
        int res[] = new int[nums.length];
        int i = 0;
        while ( i < nums.length && nums[i] < 0 ) {
            negNumbers.add(nums[i++]);
        }
        while ( i < nums.length && nums[i] >= 0) {
            posNumbers.add(nums[i++]);
        }

        i = 0;
        int posIter = 0;
        int negIter = negNumbers.size() - 1;
        while (posIter < posNumbers.size() && negIter >= 0) {
            int negSquare = (int) Math.pow(Math.abs(negNumbers.get(negIter)), 2);
            int posSquare = (int) Math.pow(posNumbers.get(posIter), 2);
            if (negSquare < posSquare) {
                res[i++] = negSquare;
                negIter--;
            } else {
                res[i++] = posSquare;
                posIter++;
            }

        }
        while (posIter < posNumbers.size()) {
            res[i++] = (int) Math.pow(posNumbers.get(posIter++), 2);
        }
        while (negIter >= 0) {
            res[i++] = (int) Math.pow(Math.abs(negNumbers.get(negIter--)), 2);
        }
        return res;
    }

    /**
     *
     *    public int[] sortedSquares(int[] A) {
     *         int n = A.length;
     *         int[] result = new int[n];
     *         int i = 0, j = n - 1;
     *         for (int p = n - 1; p >= 0; p--) {
     *             if (Math.abs(A[i]) > Math.abs(A[j])) {
     *                 result[p] = A[i] * A[i];
     *                 i++;
     *             } else {
     *                 result[p] = A[j] * A[j];
     *                 j--;
     *             }
     *         }
     *         return result;
     *     }
     */

}
