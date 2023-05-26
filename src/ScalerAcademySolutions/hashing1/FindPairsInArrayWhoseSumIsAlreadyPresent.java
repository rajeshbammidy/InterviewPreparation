package ScalerAcademySolutions.hashing1;

import java.util.HashSet;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.hashing1 / FindPairsInArrayWhoseSumIsAlreadyPresent
 * Date: Jul, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Given an array A of N distinct and positive elements, the task is to find number of unordered pairs whose sum already exists in given array.
 *
 * Expected Complexity : n^2
 *
 * CONSTRAINTS
 *
 * 1 <= N <= 1000
 * 1 <= A[i] <= 10^6 + 5
 * SAMPLE INPUT
 *
 * A : [ 3, 4, 2, 6 ,7]
 * SAMPLE OUTPUT
 *
 * 2
 * EXPLANATION
 *
 * The pairs following the conditions are :
 * (2,4) = 6,
 * (3,4) = 7
 **/
public class FindPairsInArrayWhoseSumIsAlreadyPresent {
    public int solve(int[] array) {
        HashSet<Integer> elementsSet = new HashSet<>();
        for (int x : array) {
            elementsSet.add(x);
        }
        int ans = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (elementsSet.contains(array[i] + array[j])) ans++;
            }
        }
        return ans;
    }
}
