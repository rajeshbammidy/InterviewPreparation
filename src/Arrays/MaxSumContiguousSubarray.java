package Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Arrays|MaxSumContiguousSubarray| on Dec,2019
 * Happy Coding :)
 */
public class MaxSumContiguousSubarray {
    /**
     * Approach:Kadanes Algo
     */
    public int maxSubArray(final int[] arr) {
        if (arr.length == 1) return arr[0];
        int cursum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            cursum += arr[i];
            if (cursum > maxSum) maxSum = cursum;
            /**
             * if cursum<0 then there is no use of utlizing -ve elements so we make cursum=0 again
             */
            if (cursum < 0) cursum = 0;
        }
        return maxSum;
    }
}
