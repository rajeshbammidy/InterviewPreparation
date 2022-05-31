package ScalerAcademy.recursion;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.recursion / CombinationSumII
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

/**
 * Problem Description
 * Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.
 *
 * Each number in A may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * Warning:
 *
 * DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
 *
 * Example : itertools.combinations in python. If you do, we will disqualify your submission and give you penalty points.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 20
 *
 *
 *
 * Input Format
 * First argument is an integer array A denoting the collection of candidate numbers.
 * Second argument is an integer which represents the target number.
 *
 *
 *
 * Output Format
 * Return all unique combinations in A where the candidate numbers sums to B.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [10, 1, 2, 7, 6, 1, 5]
 *  B = 8
 * Input 2:
 *
 *  A = [2, 1, 3]
 *  B = 3
 *
 *
 * Example Output
 * Output 1:
 *
 *  [
 *   [1, 1, 6 ],
 *   [1, 2, 5 ],
 *   [1, 7 ],
 *   [2, 6 ]
 *  ]
 * Output 2:
 *
 *  [
 *   [1, 2 ],
 *   [3 ]
 *  ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  1 + 1 + 6 = 8
 *  1 + 2 + 5 = 8
 *  1 + 7 = 8
 *  2 + 6 = 8
 *  All the above combinations sum to 8 and are arranged in ascending order.
 * Explanation 2:
 *
 *  1 + 2 = 3
 *  3 = 3
 *  All the above combinations sum to 3 and are arranged in ascending order.
 *
 */
public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> list, int sum) {
        Collections.sort(list);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(res, list, new ArrayList<Integer>(), new boolean[list.size()], sum, 0);
        return res;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, ArrayList<Integer> aux, boolean[] used, int sum, int start) {
        if (sum < 0) return;
        else if (sum == 0) {
            res.add(new ArrayList<>(aux));
            return;
        }

        for (int i = start; i < list.size(); i++) {
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;
            used[i] = true;
            sum -= list.get(i);
            aux.add(list.get(i));
            backtrack(res, list, aux, used, sum, i + 1);
            sum += list.get(i);
            used[i] = false;
            aux.remove(aux.size() - 1);

        }
    }
}
