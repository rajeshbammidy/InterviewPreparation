package Backtracking;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Backtracking|Subsets| on May,2020
 *  
 * Happy Coding :)
 *
 * Subset
 * Problem Description
 * Given a set of distinct integers, S, return all possible subsets. NOTE:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The list is not necessarily sorted.
 *
 *
 * Problem Constraints
 * 1 <= |S| <= 16
 * INTMIN <= S[i] <= INTMAX
 *
 *
 * Input Format
 * First and only argument of input contains a single integer array S.
 *
 *
 * Output Format
 * Return a vector of vectors denoting the answer.
 *
 *
 * Example Input
 *  S = [1, 2, 3]
 *
 *
 * Example Output
 * [
 *  []
 *  [1]
 *  [1, 2]
 *  [1, 2, 3]
 *  [1, 3]
 *  [2]
 *  [2, 3]
 *  [3]
 * ]
 *
 *
 * Example Explanation
 *  You can see that these are all possible subsets.
 **/
public class Subsets {
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> list) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        list.sort(null);
        backtrack(list, new ArrayList<Integer>(), res, 0);
        return res;
    }


    private static void backtrack(ArrayList<Integer> list, ArrayList<Integer> aux, ArrayList<ArrayList<Integer>> res, int start) {
        res.add(new ArrayList<>(aux));

        for (int i = start; i < list.size(); i++) {
            int element = list.get(i);
            aux.add(element);

            backtrack(list, aux, res, i + 1);

            aux.remove(aux.size() - 1);
        }


    }

}
