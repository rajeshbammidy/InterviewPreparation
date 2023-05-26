package ScalerAcademySolutions.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.stacks
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 * Problem Description
 * Given an array of integers A.
 *
 * A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
 *
 * Find the area of the largest rectangle formed by the histogram.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * 1 <= A[i] <= 1000000000
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the area of the largest rectangle in the histogram.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [2, 1, 5, 6, 2, 3]
 * Input 2:
 *
 * A = [2]
 *
 *
 * Example Output
 * Output 1:
 *
 * 10
 * Output 2:
 *
 * 2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
 * Explanation 2:
 *
 * Largest rectangle has area 2.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(ArrayList<Integer> list) {
        ArrayList<Integer> lSmall = getLeftSmallIndexArray(list);
        ArrayList<Integer> rSmall = getRightSmallIndexArray(list);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lSmall.size(); i++) {
            max = Math.max(max, (rSmall.get(i) - lSmall.get(i) - 1) * list.get(i));
        }
        return max;
    }

    private ArrayList<Integer> getRightSmallIndexArray(ArrayList<Integer> list) {
        Stack<Integer> indexStack = new Stack<>();
        ArrayList<Integer> rSmallIndex = new ArrayList<>(Arrays.asList(new Integer[list.size()]));
        Collections.fill(rSmallIndex, list.size());
        for (int i = 0; i < list.size(); i++) {

            while (!indexStack.isEmpty() && list.get(i) < list.get(indexStack.peek())) {
                rSmallIndex.set(indexStack.pop(), i);
            }
            indexStack.push(i);
        }

        return rSmallIndex;
    }

    private ArrayList<Integer> getLeftSmallIndexArray(ArrayList<Integer> list) {
        Stack<Integer> indexStack = new Stack<>();
        ArrayList<Integer> lSmallIndex = new ArrayList<>(Arrays.asList(new Integer[list.size()]));
        Collections.fill(lSmallIndex, -1);
        for (int i = list.size() - 1; i >= 0; i--) {

            while (!indexStack.isEmpty() && list.get(i) < list.get(indexStack.peek())) {
                lSmallIndex.set(indexStack.pop(), i);
            }
            indexStack.push(i);
        }

        return lSmallIndex;
    }

   /* private ArrayList<Integer> getRightSmallIndexArray(ArrayList<Integer> list) {
        Stack<Integer> indexStack = new Stack<>();
        ArrayList<Integer> rSmallIndex = new ArrayList<>();
        indexStack.push(list.size() - 1);
        rSmallIndex.add(list.size());
        for (int i = list.size() - 2; i >= 0; i--
        ) {

            if (list.get(i) > list.get(indexStack.peek())) {
                rSmallIndex.add(indexStack.peek());
                indexStack.push(i);
            } else {

                while (!indexStack.isEmpty() && list.get(indexStack.peek()) >= list.get(i)) {
                    indexStack.pop();
                }
                if (indexStack.isEmpty()) {
                    rSmallIndex.add(list.size());
                } else {
                    rSmallIndex.add(indexStack.peek());
                }
                indexStack.push(i);
            }
        }
        Collections.reverse(rSmallIndex);
        return rSmallIndex;
    }

    private ArrayList<Integer> getLeftSmallIndexArray(ArrayList<Integer> list) {
        Stack<Integer> indexStack = new Stack<>();
        ArrayList<Integer> lSmallIndex = new ArrayList<>();
        indexStack.push(0);
        lSmallIndex.add(-1);
        for (int i = 1; i < list.size(); i++) {

            if (list.get(i) > list.get(indexStack.peek())) {
                lSmallIndex.add(indexStack.peek());
                indexStack.push(i);
            } else {

                while (!indexStack.isEmpty() && list.get(indexStack.peek()) >= list.get(i)) {
                    indexStack.pop();
                }
                if (indexStack.isEmpty()) {
                    lSmallIndex.add(-1);
                } else {
                    lSmallIndex.add(indexStack.peek());
                }
                indexStack.push(i);
            }
        }
        return lSmallIndex;
    }*/

    public static void main(String[] args) {
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new ArrayList<>(Arrays.asList(1))));
    }
}
