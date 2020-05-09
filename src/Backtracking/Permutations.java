package Backtracking;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Backtracking|Permutations| on May,2020
 *  
 * Happy Coding :)
 * <p>
 * Problem Description
 * Given an integer array A of size N denoting collection of numbers , return all possible permutations. NOTE:
 * No two entries in the permutation sequence should be the same.
 * For the purpose of this problem, assume that all the numbers in the collection are unique.
 * WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 * <p>
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
 * Return a 2-D array denoting all possible permutation of the array.
 * <p>
 * <p>
 * Example Input
 * A = [1, 2, 3]
 * <p>
 * <p>
 * Example Output
 * [ [1, 2, 3]
 * [1, 3, 2]
 * [2, 1, 3]
 * [2, 3, 1]
 * [3, 1, 2]
 * [3, 2, 1] ]
 * <p>
 * <p>
 * Example Explanation
 * All the possible permutation of array [1, 2, 3].
 **/
public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> list) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        list.sort(null);
        backtrack(list, new ArrayList<Integer>(), res, new boolean[list.size()]);
        return res;
    }

    private void backtrack(ArrayList<Integer> list, ArrayList<Integer> aux, ArrayList<ArrayList<Integer>> res, boolean[] visited) {
        if (aux.size() == list.size()) {
            res.add(new ArrayList<>(aux));
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
            if (visited[i]) continue;
            aux.add(element);
            visited[i] = true;
            backtrack(list, aux, res, visited);
            visited[i] = false;
            aux.remove(aux.size() - 1);
        }


    }
}
