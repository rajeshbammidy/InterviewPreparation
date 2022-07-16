package ScalerAcademy.hashing1;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.hashing1 / SetMatrixZeros
 * Date: Jul, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 *
 * Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.
 * Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.
 *
 * Input Format:
 *
 * The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
 * Output Format:
 *
 * Return a 2-d matrix that satisfies the given conditions.
 * Constraints:
 *
 * 1 <= N, M <= 1000
 * 0 <= A[i][j] <= 1
 * Examples:
 *
 * Input 1:
 * [   [1, 0, 1],
 * [1, 1, 1],
 * [1, 1, 1]   ]
 *
 * Output 1:
 * [   [0, 0, 0],
 * [1, 0, 1],
 * [1, 0, 1]   ]
 *
 * Input 2:
 * [   [1, 0, 1],
 * [1, 1, 1],
 * [1, 0, 1]   ]
 *
 * Output 2:
 * [   [0, 0, 0],
 * [1, 0, 1],
 * [0, 0, 0]   ]
 **/
public class SetMatrixZeros {
    public void setZeroes(ArrayList<ArrayList<Integer>> list) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if (list.get(i).get(j) == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    list.get(i).set(j, 0);
                }
            }
        }
    }
}
