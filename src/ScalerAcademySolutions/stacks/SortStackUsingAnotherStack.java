package ScalerAcademySolutions.stacks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.stacks
 * Date:08, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 *
 * Problem Description
 * Given a stack of integers A, sort it using another stack.
 *
 * Return the array of integers after sorting the stack using another stack.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 5000
 *
 * 0 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument is a stack given as an integer array A.
 *
 *
 *
 * Output Format
 * Return the array of integers after sorting the stack using another stack.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [5, 4, 3, 2, 1]
 * Input 2:
 *
 * A = [5, 17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 * [1, 2, 3, 4, 5]
 * Output 2:
 *
 * [5, 11, 17, 100]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Just sort the given numbers.
 * Explanation 2:
 *
 * Just sort the given numbers.
 */
public class SortStackUsingAnotherStack {
    public ArrayList<Integer> solve(ArrayList<Integer> list) {
        ArrayDeque<Integer> ans = new ArrayDeque<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (ans.isEmpty()) {
                ans.push(list.get(i));
                continue;
            }
            if (ans.peek() < list.get(i)) {
                ans.push(list.get(i));
                continue;
            }
            ArrayDeque<Integer> temp = new ArrayDeque<>();
            while (!ans.isEmpty() && ans.peek() > list.get(i)) {
                temp.push(ans.pop());
            }
            ans.push(list.get(i));
            while (!temp.isEmpty()) {
                ans.push(temp.pop());
            }
        }
        ArrayList<Integer> res = new ArrayList<>(ans);
        Collections.reverse(res);
        return res;
    }
}
