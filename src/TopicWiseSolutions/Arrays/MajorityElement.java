package TopicWiseSolutions.Arrays;

import java.util.Stack;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Arrays|MajorityElement| on May,2020
 *  
 * Happy Coding :)
 * <p>
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 **/
public class MajorityElement {
    /**
     * Approach:For every two different elements: pop those two element,and finally you will be left with element that repeats more than n/2
     */
    public int majorityElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int x : nums) {

            if (stack.isEmpty()) {
                stack.add(x);
                continue;
            }
            if (stack.peek() == x) {
                stack.add(x);
            } else
                stack.pop();
        }
        return stack.peek();

    }
}
