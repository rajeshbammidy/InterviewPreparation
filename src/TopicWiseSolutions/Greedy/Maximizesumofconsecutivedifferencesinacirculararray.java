package TopicWiseSolutions.Greedy;

import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Greedy|Maximizesumofconsecutivedifferencesinacirculararray| on Oct,2020
 *  
 * Happy Coding :)
 *
 * Given an array of n elements. Consider array as circular array i.e element after an is a1. The task is to find maximum sum of the difference between consecutive elements with rearrangement of array element allowed i.e after rearrangement of element find |a1 – a2| + |a2 – a3| + …… + |an – 1 – an| + |an – a1|.
 *
 * Examples:
 *
 * Input : arr[] = { 4, 2, 1, 8 }
 * Output : 18
 * Rearrange given array as : { 1, 8, 2, 4 }
 * Sum of difference between consecutive element
 * = |1 - 8| + |8 - 2| + |2 - 4| + |4 - 1|
 * = 7 + 6 + 2 + 3
 * = 18.
 *
 * Input : arr[] = { 10, 12, 15 }
 * Output : 10
 **/
public class Maximizesumofconsecutivedifferencesinacirculararray {
    static int maxSum(int arr[], int n) {
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < n / 2; i++) {
            sum += (arr[n - i - 1] - arr[i]);
        }
        return sum * 2;
    }
}
