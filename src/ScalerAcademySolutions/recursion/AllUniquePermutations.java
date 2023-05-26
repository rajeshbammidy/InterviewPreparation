package ScalerAcademySolutions.recursion;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.recursion / AllUniquePermutations
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem Description
 * Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * NOTE: No 2 entries in the permutation sequence should be the same.
 *
 * WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 9
 *
 * 0 <= A[i] <= 10
 *
 *
 *
 * Input Format
 * Only argument is an integer array A of size N.
 *
 *
 *
 * Output Format
 * Return a 2-D array denoting all possible unique permutation of the array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 1, 2]
 * Input 2:
 *
 * A = [1, 2]
 *
 *
 * Example Output
 * Output 1:
 *
 * [ [1,1,2]
 * [1,2,1]
 * [2,1,1] ]
 * Output 2:
 *
 * [ [1, 2]
 * [2, 1] ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * All the possible unique permutation of array [1, 1, 2].
 * Explanation 2:
 *
 * All the possible unique permutation of array [1, 2].
 *
 * Approach: follow the template
 */
public class AllUniquePermutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> list) {
        Collections.sort(list); // sort the array to check adjacent duplicates
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

            // if the element is already used don't included in the aux
            // if the element is same as of the previous element then it should come along with previous element not alone

            if (used[i] || i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) {
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
