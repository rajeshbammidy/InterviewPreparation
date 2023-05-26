package TopicWiseSolutions.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Arrays|MaximumAbsoluteDifference| on Dec,2019
 * Happy Coding :)
 * <p>
 * Maximum Absolute Difference
 * You are given an array of N integers, A1, A2 ,..., AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x. For example,
 * A=[1, 3, -1]
 * <p>
 * f(1, 1) = f(2, 2) = f(3, 3) = 0
 * f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 * f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 * f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
 * <p>
 * So, we return 5.
 * <p>
 * Approach:
 * If you solve the equation |A[i] - A[j]| + |i - j| you will get the resultant equations of type as follows
 * <p>
 * (a+b)-(c+d)
 * (a-b)-(c-d)
 */
public class MaximumAbsoluteDifference {
    public int maxArr(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        int maxj = Integer.MIN_VALUE;
        int minj = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i] + i);
            mini = Math.min(mini, arr[i] + i);

            maxj = Math.max(maxj, arr[i] - i);
            minj = Math.min(minj, arr[i] - i);
        }

        return Math.max(maxi - mini, maxj - minj);


    }
}
