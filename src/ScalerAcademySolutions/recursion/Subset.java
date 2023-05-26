package ScalerAcademySolutions.recursion;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.recursion / Subset
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem Description
 * Given a set of distinct integers A, return all possible subsets.
 *
 * NOTE:
 *
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The list is not necessarily sorted.
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 16
 * INTMIN <= A[i] <= INTMAX
 *
 *
 * Input Format
 * First and only argument of input contains a single integer array A.
 *
 *
 *
 * Output Format
 * Return a vector of vectors denoting the answer.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1]
 * Input 2:
 *
 * A = [1, 2, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 * [
 * []
 * [1]
 * ]
 * Output 2:
 *
 * [
 * []
 * [1]
 * [1, 2]
 * [1, 2, 3]
 * [1, 3]
 * [2]
 * [2, 3]
 * [3]
 * ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * You can see that these are all possible subsets.
 * Explanation 2:
 *
 * You can see that these are all possible subsets.
 */
public class Subset {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> list) {
        Collections.sort(list);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(res, list, new ArrayList<Integer>(), 0);
        return res;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, ArrayList<Integer> aux, int start) {
        res.add(new ArrayList<>(aux));
        for (int i = start; i < list.size(); i++) {
            aux.add(list.get(i));
            backtrack(res, list, aux, i + 1);
            aux.remove(aux.size() - 1);

        }
    }
}
