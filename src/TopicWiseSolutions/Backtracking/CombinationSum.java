package TopicWiseSolutions.Backtracking;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Backtracking|CombinationSum| on May,2020
 *  
 * Happy Coding :)
 **/
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> list, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        list.sort(null);
        backtrack(list, new ArrayList<Integer>(), res, 0, 0, sum);
        return res;
    }


    private static void backtrack(ArrayList<Integer> list, ArrayList<Integer> aux, ArrayList<ArrayList<Integer>> res, int start, int curSum, int sum) {

        if (curSum == sum) {
            res.add(new ArrayList<>(aux));
            return;
        }
        if (curSum > sum) return;
        for (int i = start; i < list.size(); i++) {
            /*
            Here i>0 because we are including the same element many times
             */
            if (i > 0 && list.get(i) == list.get(i - 1)) continue;
            curSum += list.get(i);
            aux.add(list.get(i));
            backtrack(list, aux, res, i, curSum, sum);
            curSum -= aux.get(i);
            aux.remove(aux.size() - 1);
        }
    }
}
