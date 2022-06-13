package ScalerAcademy.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.backtracking / NumberOfSquarefulArrays
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 *
 * Problem Description
 * Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.
 *
 * Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 12
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the number of permutations of A that are squareful.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [2, 2, 2]
 * Input 2:
 *
 * A = [1, 17, 8]
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Only permutation is [2, 2, 2], the sum of adjacent element is 4 and 4 and both are perfect square.
 * Explanation 2:
 *
 * Permutation are [1, 8, 17] and [17, 8, 1].
 **/
public class NumberOfSquarefulArrays {

    public int solve(int[] array) {
        Arrays.sort(array);
        return backtrack(array, new ArrayList<Integer>(), new boolean[array.length]);

    }

    private int backtrack(int[] array, ArrayList<Integer> aux, boolean[] used) {
        if (aux.size() == array.length && aux.size() != 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < array.length; i++) {
            if (used[i] || i > 0 && array[i] == array[i - 1] && !used[i - 1]) continue;
            if (aux.isEmpty() || isPerfectSquare(aux.get(aux.size() - 1), array[i])) {
                used[i] = true;
                aux.add(array[i]);
                ans += backtrack(array, aux, used);
                used[i] = false;
                aux.remove(aux.size() - 1);
            }
        }
        return ans;
    }

    private boolean isPerfectSquare(int a, int b) {
        return Math.floor(Math.sqrt(a + b)) == Math.ceil(Math.sqrt(a + b));
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfSquarefulArrays().solve(new int[]{1, 17, 8}));
        ;
    }
}
