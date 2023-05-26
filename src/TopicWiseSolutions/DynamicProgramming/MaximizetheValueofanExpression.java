package TopicWiseSolutions.DynamicProgramming;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.DynamicProgramming|MaximizetheValueofanExpression| on Sep,2020
 *  
 * Happy Coding :)
 *
 * Maximize the Value of an Expression
 * Given an array A, maximize value of the expression (A[s] – A[r] + A[q] – A[p]) where p, q, r and s are indices of the input array and s > r > q > p.
 *
 *
 *
 *
 * For example,
 *
 * Input:  A[] = [3, 9, 10, 1, 30, 40]
 *
 * Output: 46
 *
 * (40 – 1 + 10 – 3) will result in maximum value
 **/
public class MaximizetheValueofanExpression {
    public static int maximizeExpression(int[] arr) {
        int first[] = new int[arr.length];
        int second[] = new int[arr.length];
        int third[] = new int[arr.length - 1];
        int fourth[] = new int[arr.length - 2];
        first[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            first[i] = Math.max(arr[i], first[i + 1]);
        }
        second[second.length - 1] = Integer.MIN_VALUE;
        for (int i = second.length - 2; i >= 0; i--) {
            second[i] = Math.max(second[i + 1], first[i + 1] - arr[i]);
        }

        third[third.length - 1] = Integer.MIN_VALUE;
        for (int i = third.length - 2; i >= 0; i--) {
            third[i] = Math.max(third[i + 1], second[i + 1] + arr[i]);
        }
        fourth[fourth.length - 1] = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        for (int i = fourth.length - 2; i >= 0; i--) {
            fourth[i] = Math.max(fourth[i + 1], third[i + 1] - arr[i]);

        }
        return fourth[0];


    }
}
