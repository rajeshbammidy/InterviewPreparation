package Hashing;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Hashing|null.java| on Dec,2019
 * Happy Coding :)
 * <p>
 * Set Matrix Zeros
 * Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0. Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.
 * Input Format:
 * The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
 * Output Format:
 * Return a 2-d matrix that satisfies the given conditions.
 * Constraints:
 * 1 <= N, M <= 1000
 * 0 <= A[i][j] <= 1
 * Examples:
 * Input 1:
 * [   [1, 0, 1],
 * [1, 1, 1],
 * [1, 1, 1]   ]
 * <p>
 * Output 1:
 * [   [0, 0, 0],
 * [1, 0, 1],
 * [1, 0, 1]   ]
 * <p>
 * Input 2:
 * [   [1, 0, 1],
 * [1, 1, 1],
 * [1, 0, 1]   ]
 * <p>
 * Output 2:
 * [   [0, 0, 0],
 * [1, 0, 1],
 * [0, 0, 0]   ]
 */
public class SetMatrixZero {
    public void setZeroes(ArrayList<ArrayList<Integer>> list) {


        boolean firstRow = false, firstCol = false;

        for (int j = 0; j < list.get(0).size(); j++) {
            if (list.get(0).get(j) == 0) {
                firstRow = true;
                break;
            }

        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(0) == 0) {
                firstCol = true;
                break;
            }
        }

        for (int i = 1; i < list.size(); i++) {
            for (int j = 1; j < list.get(0).size(); j++) {

                if (list.get(i).get(j) == 0) {
                    list.get(0).set(j, 0);
                    list.get(i).set(0, 0);
                }
            }
        }

        for (int i = 1; i < list.size(); i++) {
            for (int j = 1; j < list.get(0).size(); j++) {

                if (list.get(0).get(j) == 0 || list.get(i).get(0) == 0) {
                    list.get(i).set(j, 0);
                }
            }
        }

        if (firstRow) {

            for (int j = 0; j < list.get(0).size(); j++) {
                list.get(0).set(j, 0);
            }
        }

        if (firstCol) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).set(0, 0);
            }
        }


    }
}
