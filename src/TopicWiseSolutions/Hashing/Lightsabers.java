package TopicWiseSolutions.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Hashing|null.java| on Dec,2019
 * Happy Coding :)
 * <p>
 * Given two array of integers A and B of size N and M respectively. The goal is to select some continuous interval in A such that there are exactly B[0] elements with value 1, B[1] elements with value 2 and so on ending with B[m-1] elements with value m. However, it is not always possible to select such an interval form the given array therefore it is allowed to remove some elements from A in order to achieve the goal. Find and return the minimum number of elements to be removed from A in order to achieve the goal. If it is not possible to achieve the goal return -1 instead.
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer array B.
 * Output Format
 * Return the minimum number of elements to be removed from A in order to achieve the goal and
 * if it is not possible to achieve the goal return -1 instead.
 * Constraints
 * 1 <= N, M <= 100000
 * 1 <= A[i] <= M
 * 0 <= B[i] <= N
 * For Example
 * Input 1:
 * A = [1, 2, 3, 4, 1]
 * B = [2, 1, 1, 0]
 * Output 1:
 * 1   (Reomve element 4 and consider all the remaining elements).
 * <p>
 * Input 2:
 * A = [1, 1, 2, 2, 2]
 * B = [1, 2, 1]
 * Output 2:
 * -1
 */
public class Lightsabers {
    public int solve(ArrayList<Integer> list, ArrayList<Integer> counts) {
        int pat = 0;
        for (int x : counts) pat += x;

        int arr[] = new int[100000];

        for (int i = 0; i < counts.size(); i++) {
            arr[i + 1] = counts.get(i);
        }
        int copy[] = arr.clone();
        int left = 0;
        int c = 0;
        int ans = 0;
        int flag = -1;
        int minlen = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        for (int right = 0; right < list.size(); right++) {

            if (--arr[list.get(right)] >= 0) c++;
            while (c == pat) {
                flag = 1;
                if (minlen > right - left + 1) {
                    minlen = right - left + 1;
                    start = left;
                    end = right;
                }
                if (++arr[list.get(left)] > 0) {
                    c--;
                }
                left++;

            }
        }
        if (flag == -1) return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int s = start;
        int e = end;
        while (s <= e) {
            int val = list.get(s++);

            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> x : map.entrySet()) {

            if (x.getKey() >= copy.length) {
                ans += x.getValue();
            } else if (copy[x.getKey()] == 0) {
                ans += x.getValue();
            } else if (copy[x.getKey()] < x.getValue()) {
                ans += x.getValue() - copy[x.getKey()];
            }
        }
        return ans;

    }
}
