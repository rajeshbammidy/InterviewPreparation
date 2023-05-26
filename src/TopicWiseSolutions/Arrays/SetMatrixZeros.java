package TopicWiseSolutions.Arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Arrays|SetMatrixZeros| on Dec,2019
 * Happy Coding :)
 *
 * Set Matrix Zeros
 * Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0. Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.
 *  Input Format:
 * The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
 * Output Format:
 * Return a 2-d matrix that satisfies the given conditions.
 * Constraints:
 * 1 <= N, M <= 1000
 * 0 <= A[i][j] <= 1
 * Examples:
 * Input 1:
 *     [   [1, 0, 1],
 *         [1, 1, 1],
 *         [1, 1, 1]   ]
 *
 * Output 1:
 *     [   [0, 0, 0],
 *         [1, 0, 1],
 *         [1, 0, 1]   ]
 *
 * Input 2:
 *     [   [1, 0, 1],
 *         [1, 1, 1],
 *         [1, 0, 1]   ]
 *
 * Output 2:
 *     [   [0, 0, 0],
 *         [1, 0, 1],
 *         [0, 0, 0]   ]
 */
public class SetMatrixZeros {
    public void setZeroes(ArrayList<ArrayList<Integer>> list) {
        if (list.size() == 0) return;
        /**
         * Check if the first row and first col contains '0'
         */
        boolean fr = false, fc = false;
        int m = list.size();
        int n = list.get(0).size();
        for (int i = 0; i < n; i++) {
            if (list.get(0).get(i) == 0) {
                fr = true;//It means first row contains 0
                break;
            }
        }
        for (int j = 0; j < m; j++) {
            if (list.get(j).get(0) == 0) {
                fc = true;//It means first col contains zero
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                /*
                Now traverse the array from (1,1) and if the element is zero make its correspondig first row element and corresponding first col element as zero
                 */
                if (list.get(i).get(j) == 0) {
                    list.get(i).set(0, 0);
                    list.get(0).set(j, 0);
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (list.get(i).get(0) == 0 || list.get(0).get(j) == 0) list.get(i).set(j, 0);
            }
        }

        if (fr) {
            Collections.fill(list.get(0), 0);
        }
        if (fc) {

            for (int i = 0; i < m; i++) {
                list.get(i).set(0, 0);
            }
        }
    }
}
