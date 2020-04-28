package Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Arrays|MaximumUnsortedSubarray| on Apr,2020
 *  
 * Happy Coding :)
 **/

import java.util.Arrays;

public class MaximumUnsortedSubarray {
    public static int[] subUnsort(int[] arr) {
        int dp[] = Arrays.copyOf(arr, arr.length);
        Arrays.sort(dp);
        boolean lastFound = false;
        int lastIndex = 0;
        int ans = -1;
        int left = -1;
        int n = arr.length;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (dp[i] != arr[i] && !lastFound) {
                lastIndex = i;
                lastFound = true;
            } else if (dp[i] == arr[i] && i + 1 < n && dp[i + 1] != arr[i + 1]) {

                left = i + 1;
            }
            if (i == 0 && arr[i] != dp[i] && lastFound) {
                left = 0;
            }

        }
        if (left == -1) return new int[]{-1};
        return new int[]{left, lastIndex};
    }
}
