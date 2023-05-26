package ScalerAcademySolutions.recursion;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.recursion / SubsetsII
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem Description
 * Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.
 *
 * NOTE:
 *
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * The subsets must be sorted lexicographically.
 *
 *
 * Problem Constraints
 * 0 <= N <= 16
 *
 *
 *
 * Input Format
 * Only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return a 2-D vector denoting all the possible subsets.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 2]
 * Input 2:
 *
 * A = [1, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 * [
 * [],
 * [1],
 * [1, 2],
 * [1, 2, 2],
 * [2],
 * [2, 2]
 * ]
 * Output 2:
 *
 * [
 * [],
 * [1],
 * [1, 1]
 * ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * All the subsets of the array [1, 2, 2] in lexicographically sorted order.
 */
public class SubsetsII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> list) {
        Collections.sort(list);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(res, list, new ArrayList<Integer>(), new boolean[list.size()], 0);
        return res;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, ArrayList<Integer> aux, boolean[] used, int start) {
        res.add(new ArrayList<>(aux));
        for (int i = start; i < list.size(); i++) {
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;
            used[i] = true;
            aux.add(list.get(i));
            backtrack(res, list, aux, used, i + 1);
            aux.remove(aux.size() - 1);
            used[i] = false;
        }
    }
}
