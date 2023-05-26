package TopicWiseSolutions.Arrays;

import java.util.TreeSet;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Arrays|MaximumConsecutiveGap| on Dec,2019
 * Happy Coding :)
 * <p>
 * Maximum Consecutive Gap
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form. Try to solve it in linear time/space. Example :
 * Input : [1, 10, 5]
 * Output : 5
 * Return 0 if the array contains less than 2 elements.
 * You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * You may also assume that the difference will not overflow.
 */
public class MaximumConsecutiveGap {
    public int maximumGap(final int[] arr) {
        if (arr.length < 2) return 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int x : arr) set.add(x);
        if (set.size() == 1) return 0;//If all the elements are same we reach here
        Integer res[] = new Integer[set.size()];
        res = set.toArray(res);//converts the given set into an array of type Integer
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < res.length; i++) {
            if (res[i] - res[i - 1] > max) max = res[i] - res[i - 1];
        }
        return max;
    }
}
