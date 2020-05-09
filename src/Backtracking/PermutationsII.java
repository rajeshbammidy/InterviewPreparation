package Backtracking;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Backtracking|PermutationsII| on May,2020
 *  
 * Happy Coding :)
 * All Unique Permutations
 * Problem Description
 * Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations. NOTE: No 2 entries in the permutation sequence should be the same.
 * WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 9
 * <p>
 * <p>
 * Input Format
 * Only argument is an integer array A of size N.
 * <p>
 * <p>
 * Output Format
 * Return a 2-D array denoting all possible unique permutation of the array.
 * <p>
 * <p>
 * Example Input
 * A = [1, 1, 2]
 * <p>
 * <p>
 * Example Output
 * [ [1,1,2]
 * [1,2,1]
 * [2,1,1] ]
 * <p>
 * <p>
 * Example Explanation
 * All the possible unique permutation of array [1, 1, 2].
 **/
public class PermutationsII {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> list) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        /**
         * Sort the array
         */
        list.sort(null);
        backtrack(list, new ArrayList<Integer>(), res, new boolean[list.size()]);
        return res;
    }

    private void backtrack(ArrayList<Integer> list, ArrayList<Integer> aux, ArrayList<ArrayList<Integer>> res, boolean[] visited) {
        /**
         * If the auxiliary array size equals to give list size then add into res
         */
        if (aux.size() == list.size()) {
            res.add(new ArrayList<>(aux));
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
            /**
             * If the element is already visited
             *
             * or
             *
             * if the element is equal to the prev element and the prev element is not visited then we are making it duplicate so continue
             */
            if (visited[i] || i > 0 && list.get(i) == list.get(i - 1) && !visited[i - 1]) continue;
            aux.add(element);
            visited[i] = true;
            backtrack(list, aux, res, visited);
            visited[i] = false;
            aux.remove(aux.size() - 1);
        }


    }


}
