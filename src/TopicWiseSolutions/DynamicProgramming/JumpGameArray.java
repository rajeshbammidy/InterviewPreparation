package TopicWiseSolutions.DynamicProgramming;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.DynamicProgramming|JumpGameArray| on Jul,2020
 *  
 * Happy Coding :)
 *
 * Jump Game Array
 * Asked in:
 * Amazon
 * Ebay
 * Given an array of non-negative integers, A, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 *
 * Input Format:
 *
 * The first and the only argument of input will be an integer array A.
 * Output Format:
 *
 * Return an integer, representing the answer as described in the problem statement.
 *     => 0 : If you cannot reach the last index.
 *     => 1 : If you can reach the last index.
 * Constraints:
 * 1 <= len(A) <= 1e6
 * 0 <= A[i] <= 30
 *
 * Examples:
 *
 * Input 1:
 *     A = [2,3,1,1,4]
 *
 * Output 1:
 *     1
 *
 * Explanation 1:
 *     Index 0 -> Index 2 -> Index 3 -> Index 4 -> Index 5
 *
 * Input 2:
 *     A = [3,2,1,0,4]
 *
 * Output 2:
 *     0
 *
 * Explanation 2:
 *     There is no possible path to reach the last index.
 **/
public class JumpGameArray {
    public static int canJump(int[] arr) {
        int lastIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > lastIndex) return 0;
            if (arr[i] + i >= lastIndex) {
                lastIndex = arr[i] + i;
            }
        }
        return 1;

    }
}
