package ScalerAcademySolutions.hashing2;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.hashing2 / FindRectangleInBinaryMatrix
 * Date: Jul, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 *
 * Given a binary matrix of integers A of size N x M consisting of only 0 or 1. you need to check whether there exists a square or rectangle in a square whose all four corners are 1. All four corners need to be distinct.
 *
 * If there exists such rectangle or square return 1, else return 0.
 *
 * Input Format
 *
 * The first argument given is the integer matrix A.
 * Output Format
 *
 * Return 1 if there exists such rectangle/square whose all four corners are 1 else return 0.
 * Constraints
 *
 * 1 <= N, M <= 200
 * 0 <= A[i] <= 1
 * For Example
 *
 * Input 1:
 * A = [   [0, 1, 1]
 * [0, 1, 1]
 * [0, 1, 0]   ]
 *
 * Output 1: 1
 *
 * Explanation 1:
 * [ [1, 1]
 * [1, 1] ]
 * There exists a square whose all corners are 1.
 *
 *
 * Input 2:
 * A = [   [0, 1, 1]
 * [0, 0, 1]
 * [0, 1, 0]   ]
 *
 * Output 2: 0
 **/
public class FindRectangleInBinaryMatrix {
    public int solve(final int[][] matrix) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            ArrayList<Integer> onesPlace = new ArrayList<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) onesPlace.add(j);
            }

            for (int j = 0; j < onesPlace.size(); j++) {
                for (int k = j + 1; k < onesPlace.size(); k++) {
                    if (set.contains(onesPlace.get(j) + "-" + onesPlace.get(k))) return 1;
                    set.add(onesPlace.get(j) + "-" + onesPlace.get(k));
                }
            }

        }
        return 0;

    }
}
