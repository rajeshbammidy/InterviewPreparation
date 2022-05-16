package ScalerAcademy.arrays;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.arrays / MaxChunksToMakeSortedII
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/


/**
 * Approach: Since the elements are not distinct, moving through the array if the element is greater than prev insert it else pop the elements till the curr
 * element finds it right place
 */
public class MaxChunksToMakeSortedII {

    public int solve(ArrayList<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        stack.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            int peekElement = stack.peek();
            int curElement = list.get(i);
            if (curElement >= peekElement) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > curElement) {
                stack.pop();
            }
            stack.push(peekElement);

        }
        return stack.size();
    }
}
