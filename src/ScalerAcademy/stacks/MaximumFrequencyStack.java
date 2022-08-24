package ScalerAcademy.stacks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.stacks
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 * Problem Description
 * You are given a matrix A of size N x 2 which represents different operations.
 * Assume initially you have a stack-like data structure you have to perform operations on it.
 *
 * Operations are of two types:
 *
 * 1 x: push an integer x onto the stack and return -1.
 *
 * 2 0: remove and return the most frequent element in the stack.
 *
 * If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.
 *
 * A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 100000
 *
 * 1 <= A[i][0] <= 2
 *
 * 0 <= A[i][1] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the array of integers denoting the answer to each operation.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [
 * [1, 5]
 * [1, 7]
 * [1, 5]
 * [1, 7]
 * [1, 4]
 * [1, 5]
 * [2, 0]
 * [2, 0]
 * [2, 0]
 * [2, 0]  ]
 * Input 2:
 *
 * A =  [
 * [1, 5]
 * [2, 0]
 * [1, 4]   ]
 *
 *
 * Example Output
 * Output 1:
 *
 * [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
 * Output 2:
 *
 * [-1, 5, -1]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Just simulate given operations.
 * Explanation 2:
 *
 * Just simulate given operations.
 */
public class MaximumFrequencyStack {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> list) {
        HashMap<Integer, Stack<Integer>> freqToStackMap = new HashMap<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int maxFreq = 0;
        for (int i = 0; i < list.size(); i++) {

            int type = list.get(i).get(0);
            if (type == 1) {//push
                int value = list.get(i).get(1);
                freqMap.put(value, freqMap.getOrDefault(value, 0) + 1);
                int freq = freqMap.get(value);
                if (freqToStackMap.get(freq) == null) {
                    Stack<Integer> st = new Stack<>();
                    st.push(value);
                    freqToStackMap.put(freq, st);
                } else {
                    freqToStackMap.get(freq).push(value);
                }
                maxFreq = Math.max(maxFreq, freq);
                ans.add(-1);

            } else {//pop

                int elementPopped = freqToStackMap.get(maxFreq).pop();
                freqMap.put(elementPopped, freqMap.get(elementPopped) - 1);
                if (freqToStackMap.get(maxFreq).isEmpty()) maxFreq--;
                ans.add(elementPopped);

            }
        }
        return ans;
    }

}
