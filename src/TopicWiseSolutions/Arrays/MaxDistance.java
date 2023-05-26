package TopicWiseSolutions.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Arrays|MaxDistance| on Apr,2020
 *  
 * Happy Coding :)
 **/
public class MaxDistance {
    public int maximumGap(final int[] arr) {
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        left[0] = arr[0];
        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.min(left[i - 1], arr[i]);
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }
        int i = 0;
        int j = 0;
        int n = arr.length;
        int maxDiff = Integer.MIN_VALUE;
        while (i < n && j < n) {
            if (left[i] <= right[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;

            } else {
                i++;
            }
        }
        return maxDiff;
    }
}
