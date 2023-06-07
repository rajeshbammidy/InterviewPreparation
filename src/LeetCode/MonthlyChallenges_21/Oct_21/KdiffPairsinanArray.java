package LeetCode.MonthlyChallenges_21.Oct_21;

/**
 * Created by RajeshAatrayan|InterviewPreparation|LeetCode.Oct_LeetCode|KdiffPairsinanArray| on Oct,2020
 *  
 * Happy Coding :)
 **/

import java.util.*;

public class KdiffPairsinanArray {
    public int findPairs(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            set.add(x);
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int ans = 0;
        for (int x : set) {
            if (k == 0) {
                if (map.get(x - k) != null && map.get(x - k) > 1) ans++;
                continue;
            }
            if (set.contains(x - k)) ans++;
        }
        return ans;

    }
}
