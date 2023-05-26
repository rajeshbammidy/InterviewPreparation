package TopicWiseSolutions.DynamicProgramming;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.DynamicProgramming|JumpGameII| on Sep,2020
 *  
 * Happy Coding :)
 * <p>
 * 45. Jump Game II
 **/
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        int maxReach = nums[0];
        int steps = maxReach;
        int jumps = 0;

        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - 1) break;
            maxReach = Math.max(maxReach, nums[i] + i);
            steps -= 1;
            if (steps == 0) {
                jumps++;
                steps = maxReach - i;
            }

        }
        return jumps + 1;

    }

}
