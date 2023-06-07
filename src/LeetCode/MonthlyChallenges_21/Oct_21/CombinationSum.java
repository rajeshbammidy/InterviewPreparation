package LeetCode.MonthlyChallenges_21.Oct_21;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by RajeshAatrayan|InterviewPreparation|LeetCode.Oct_LeetCode|CombinationSum| on Oct,2020
 *  
 * Happy Coding :)
 **/
public class CombinationSum {
    HashSet<String> set = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        set = new HashSet<>();
        backtrack(candidates, target, new ArrayList<>(), ans, 0);
        return ans;

    }

    private void backtrack(int[] arr, int target, ArrayList<Integer> aux, List<List<Integer>> ans, int sum) {

        if (sum == target) {
            ArrayList<Integer> list = new ArrayList<>(aux);
            list.sort(null);
            if (!set.contains(list.toString())) {
                ans.add(new ArrayList<>(aux));
                String str = list.toString();
                set.add(str);
                return;
            }

        }
        if (sum > target) return;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= target) {
                sum += arr[i];
                aux.add(arr[i]);
                backtrack(arr, target, aux, ans, sum);
                sum -= arr[i];
                aux.remove(aux.size() - 1);
            }

        }


    }


}
