package TopicWiseSolutions.Arrays;

import java.util.Arrays;

/**
 * Project: InterviewPreparation
 * Package: TopicWiseSolutions.Strings.Arrays / SmallestRangeII
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Approach:
 * Y > X => (Y-K)- (B+K) => Y-B-2K less difference as possible
 **/
public class SmallestRangeII {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = nums[nums.length - 1] - nums[0];
        int max = nums[nums.length - 1] - k;
        int min = nums[0] + k;

        for (int i = 1; i < nums.length; i++) {
            int maxi = Math.max(max, nums[i - 1] + k);
            int mini = Math.min(min, nums[i] - k);
            ans = Math.min(ans, maxi - mini);
        }
        return ans;
    }
}
