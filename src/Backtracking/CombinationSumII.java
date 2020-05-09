package Backtracking;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Backtracking|CombinationSumII| on May,2020
 *  
 * Happy Coding :)
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. The same repeated number may be chosen from C unlimited number of times.
 *  Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The combinations themselves must be sorted in ascending order.
 * CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)
 * The solution set must not contain duplicate combinations.
 * Example, Given candidate set 2,3,6,7 and target 7, A solution set is:
 * [2, 2, 3]
 * [7]
 *  Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS. Example : itertools.combinations in python. If you do, we will disqualify your submission retroactively and give you penalty points.
 **/
public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int s) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        arr.sort(null);
        ArrayList<Integer> temp = new ArrayList<>();
        int cursum = 0;
        generate(arr, 0, temp, res, cursum, s);
        //System.out.println(res);
        return res;

    }

    private void generate(ArrayList<Integer> arr, int start, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res, int cursum, int sum) {
        if (cursum > sum) return;
        if (cursum == sum) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < arr.size(); i++) {

            /**
             * Here it has to be i>start but not i>0 because we have to include each element only once
             */
            if (i > start && arr.get(i) == arr.get(i - 1)) continue;
            temp.add(arr.get(i));
            cursum += arr.get(i);
            generate(arr, i, temp, res, cursum, sum);
            cursum -= arr.get(i);
            temp.remove(temp.size() - 1);

        }

    }
}
