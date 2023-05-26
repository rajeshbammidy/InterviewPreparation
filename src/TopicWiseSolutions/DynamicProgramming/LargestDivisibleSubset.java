package TopicWiseSolutions.DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.DynamicProgramming|LargestDivisibleSubset| on Jun,2020
 *  
 * Happy Coding :)
 **/
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();
        if (nums.length == 0) return list;

        if (nums.length == 1) {
            list.add(nums[0]);
            return list;
        }
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int in = -1;
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {

                if ((nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;

                    if (max < dp[i]) {
                        max = dp[i];
                        in = i;
                    }
                }
            }
        }


        if (in == -1) {
            list.add(nums[0]);
            return list;
        }
        int prev = max;
        int prevj = in;

        list.add(nums[in]);
        in--;
        while (in >= 0) {
            max = dp[in];
            if (max + 1 == prev && (nums[in] % nums[prevj] == 0 || nums[prevj] % nums[in] == 0)) {
                list.add(nums[in]);
                prev = max;
                prevj = in;
            }
            in--;
        }
        Collections.reverse(list);
        return list;


    }
}
