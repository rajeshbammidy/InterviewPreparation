package TopicWiseSolutions.Backtracking;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Backtracking|SubsetsII| on May,2020
 *  
 * Happy Coding :)
 *
 * Subsets II
 * Problem Description
 * Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets. NOTE:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * The subsets must be sorted lexicographically.
 *
 *
 *
 * Problem Constraints
 * 0 <= N <= 16
 *
 *
 * Input Format
 * Only argument is an integer array A of size N.
 *
 *
 * Output Format
 * Return a 2-D vector denoting all the possible subsets.
 *
 *
 * Example Input
 * A = [1, 2, 2]
 *
 *
 * Example Output
 * [
 *     [],
 *     [1],
 *     [1, 2],
 *     [1, 2, 2],
 *     [2],
 *     [2, 2]
 * ]
 *
 *
 * Example Explanation
 * All the subsets of the array [1, 2, 2] in lexicographically sorted order.
 **/
public class SubsetsII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        arr.sort(null);
        ArrayList<Integer> temp = new ArrayList<>();
        generate(arr, 0, temp, res, new boolean[arr.size()]);
        return res;

    }

    private void generate(ArrayList<Integer> arr, int start, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res, boolean vis
            []) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < arr.size(); i++) {

            if (i > 0 && arr.get(i - 1) == arr.get(i) && !vis[i - 1]) continue;
            vis[i] = true;
            temp.add(arr.get(i));
            generate(arr, i + 1, temp, res, vis);
            vis[i] = false;
            temp.remove(temp.size() - 1);

        }

    }

    /**
     * Another Soln:
     * public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> arr) {
     *         ArrayList<ArrayList<Integer>> res = new ArrayList<>();
     *         arr.sort(null);
     *         ArrayList<Integer> temp = new ArrayList<>();
     *         generate(arr, 0, temp, res);
     *         return res;
     *
     *     }
     *
     *     private void generate(ArrayList<Integer> arr, int start, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {
     *         res.add(new ArrayList<>(temp));
     *         for (int i = start; i < arr.size(); i++) {
     *
     *  //This if statment is what we need to concentrate on
     *             if (i > start && arr.get(i) == arr.get(i - 1)) continue;
     *             temp.add(arr.get(i));
     *             generate(arr, i + 1, temp, res);
     *             temp.remove(temp.size() - 1);
     *
     *         }
     *
     *     }
     */
}
