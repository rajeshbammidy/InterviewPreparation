package ScalerAcademySolutions.recursion;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.recursion / CombinationSum
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem Description
 * Given an array of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.
 *
 * The same repeated number may be chosen from A unlimited number of times.
 *
 * Note:
 *
 * 1) All numbers (including target) will be positive integers.
 *
 * 2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 *
 * 3) The combinations themselves must be sorted in ascending order.
 *
 * 4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)
 *
 * 5) The solution set must not contain duplicate combinations.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 20
 *
 * 1 <= A[i] <= 50
 *
 * 1 <= B <= 500
 *
 *
 *
 * Input Format
 * The first argument is an integer array A.
 *
 * The second argument is integer B.
 *
 *
 *
 * Output Format
 * Return a vector of all combinations that sum up to B.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [2, 3]
 * B = 2
 * Input 2:
 *
 * A = [2, 3, 6, 7]
 * B = 7
 *
 *
 * Example Output
 * Output 1:
 *
 * [ [2] ]
 * Output 2:
 *
 * [ [2, 2, 3] , [7] ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * All possible combinations are listed.
 * Explanation 2:
 *
 * All possible combinations are listed.
 */
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> list, int sum) {
        Collections.sort(list);// to skip the duplicates
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(res, list, new ArrayList<Integer>(), sum, 0, new boolean[list.size()]);
        return res;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, ArrayList<Integer> aux, int sum, int start, boolean[] used) {
        if (sum < 0) {
            return;
        } else if (sum == 0) {
            res.add(new ArrayList<>(aux));
            return;
        }

        for (int i = start; i < list.size(); i++) {
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;
            sum -= list.get(i);
            aux.add(list.get(i));
            used[i] = true;
            backtrack(res, list, aux, sum, i, new boolean[list.size()]);
            sum += list.get(i);
            used[i] = false;
            aux.remove(aux.size() - 1);
        }
    }
}
