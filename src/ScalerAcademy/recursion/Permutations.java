package ScalerAcademy.recursion;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.recursion / Permutations
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem Description
 * Given an integer array A of size N denoting collection of numbers , return all possible permutations.
 *
 * NOTE:
 *
 * No two entries in the permutation sequence should be the same.
 * For the purpose of this problem, assume that all the numbers in the collection are unique.
 * Return the answer in any order
 * WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 *
 *
 * Problem Constraints
 * 1 <= N <= 9
 *
 *
 *
 * Input Format
 * Only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return a 2-D array denoting all possible permutation of the array.
 *
 *
 *
 * Example Input
 * A = [1, 2, 3]
 *
 *
 * Example Output
 * [ [1, 2, 3]
 * [1, 3, 2]
 * [2, 1, 3]
 * [2, 3, 1]
 * [3, 1, 2]
 * [3, 2, 1] ]
 *
 *
 * Example Explanation
 * All the possible permutation of array [1, 2, 3].
 *
 * Approach: follow the backtracking template:https://leetcode.com/problems/permutations/discuss/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning
 */
public class Permutations {


    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> list) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(res, list, new ArrayList<Integer>(), new boolean[list.size()]);
        return res;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, ArrayList<Integer> aux, boolean[] used) {

        if (aux.size() == list.size()) {
            res.add(new ArrayList<>(aux));
            return;
        }
        for (int i = 0; i < list.size(); i++) {

            if (used[i]) {
                continue;
            }
            aux.add(list.get(i));
            used[i] = true;
            backtrack(res, list, aux, used);
            used[i] = false;
            aux.remove(aux.size() - 1);
        }
    }

}
