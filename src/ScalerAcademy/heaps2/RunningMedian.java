package ScalerAcademy.heaps2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.heaps2
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 * Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
 * Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.
 *
 * Find and return the array C.
 *
 * NOTE:
 *
 * If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
 * If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return an integer array C, C[i] denotes the median of the first i elements.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 5, 4, 3]
 * Input 2:
 *
 *  A = [5, 17, 100, 11]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 1, 2, 2, 3]
 * Output 2:
 *
 *  [5, 5, 17, 11]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  stream          median
 *  [1]             1
 *  [1, 2]          1
 *  [1, 2, 5]       2
 *  [1, 2, 5, 4]    2
 *  [1, 2, 5, 4, 3] 3
 * Explanation 2:
 *
 *  stream          median
 *  [5]              5
 *  [5, 17]          5
 *  [5, 17, 100]     17
 *  [5, 17, 100, 11] 11
 */
public class RunningMedian {
    public ArrayList<Integer> solve(ArrayList<Integer> list) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> res = new ArrayList<>();
        for (int x : list) {
            if (maxHeap.size() > minHeap.size()) {
                if (x > maxHeap.peek()) {
                    minHeap.add(x);
                } else {
                    maxHeap.add(x);
                    minHeap.add(maxHeap.poll());
                }

            } else {
                if (maxHeap.isEmpty() || x < maxHeap.peek()) {
                    maxHeap.add(x);
                } else {
                    minHeap.add(x);
                    maxHeap.add(minHeap.poll());
                }
            }

            if (maxHeap.size() > minHeap.size()) {
                res.add(maxHeap.peek());
            } else {
                res.add(maxHeap.peek());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new RunningMedian().solve(new ArrayList<>(Arrays.asList(1, 2, 5, 4, 3))));
    }

}
