package TopicWiseSolutions.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Arrays|SingleNumberII| on Jun,2020
 *  
 * Happy Coding :)
 **/
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {

            int mask = (1 << i);
            int numZeroes = 0;
            int numOnes = 0;
            for (int j = 0; j < nums.length; j++) {

                if ((nums[j] & mask) == 0) {
                    numZeroes++;
                } else {
                    numOnes++;
                }

            }
            if (numOnes % 3 != 0) {
                ans = (ans | mask);
            }

        }
        return ans;

    }
}
