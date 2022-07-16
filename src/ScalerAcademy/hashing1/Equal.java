package ScalerAcademy.hashing1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.hashing1 / Equal
 * Date: Jul, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Given an array A of N integers, find the index of values that satisfy P + Q = R + S, where P, Q, R & S are integers values in the array
 *
 * Expected time complexity O(N2)
 *
 * NOTE:
 *
 * 1) Return the indices `A1 B1 C1 D1`, so that
 * A[A1] + A[B1] = A[C1] + A[D1]
 * A1 < B1, C1 < D1
 * A1 < C1, B1 != D1, B1 != C1
 *
 * 2) If there are more than one solutions,
 * then return the tuple of values which are lexicographical smallest.
 *
 * Assume we have two solutions
 * S1 : A1 B1 C1 D1 ( these are values of indices in the array )
 * S2 : A2 B2 C2 D2
 *
 * S1 is lexicographically smaller than S2 if:
 * A1 < A2 OR
 * A1 = A2 AND B1 < B2 OR
 * A1 = A2 AND B1 = B2 AND C1 < C2 OR
 * A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
 * If no solution is possible, return an empty list.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 1000
 *
 * 0 <= A[i] <= 1000
 *
 *
 *
 * Input Format
 * First and only argument is an integer array A of length N.
 *
 *
 *
 * Output Format
 * Return an array of size four which contains indices of values P, Q, R, and S.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [3, 4, 7, 1, 2, 9, 8]
 * Input 2:
 *
 * A = [2, 5, 1, 6]
 *
 *
 * Example Output
 * Output 1:
 *
 * [0, 2, 3, 5]
 * Output 2:
 *
 * [0, 1, 2, 3]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * A[0] + A[2] = A[3] + A[5]
 * Note: indexes returned should be 0-based.
 * Explanation 2:
 *
 * A[0] + A[1] = A[2] + A[3]
 **/
public class Equal {
    static class Node {
        int i, j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[] equal(int[] array) {
        HashMap<Integer, LinkedList<Node>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int sum = array[i] + array[j];
                if (map.containsKey(sum)) {
                    map.get(sum).add(new Node(i, j));
                } else {
                    map.put(sum, new LinkedList<Node>());
                    map.get(sum).add(new Node(i, j));
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int sum = array[i] + array[j];
                LinkedList<Node> list = map.get(sum);
                if (list.size() < 2) {
                    continue;
                }
                for (Node node : list) {
                    if (!isValid(new Node(i, j), node)) {
                        continue;
                    }
                    return new int[]{i, j, node.i, node.j};
                }

            }
        }
        return new int[]{};
    }

    private boolean isValid(Node node1, Node node2) {
        return node1.i < node1.j && node2.i < node2.j && node1.i < node2.i && node1.j != node2.j && node1.j != node2.i;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Equal().equal(new int[]{2, 5, 1, 6})));
    }
}
