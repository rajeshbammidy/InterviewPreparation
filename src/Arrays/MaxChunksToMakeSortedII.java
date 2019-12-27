package Arrays;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Arrays|MaxChunksToMakeSortedII| on Dec,2019
 * Happy Coding :)
 *
 * Max Chunks To Make Sorted II
 * Given an array of integers (not necessarily distinct) A, if we split the array into some number of "chunks" (partitions), and individually sort each chunk. After concatenating them, the result equals the sorted array. What is the most number of chunks we could have made?
 * Input Format
 * The only argument given is the integer array A.
 * Output Format
 * Return the maximum number of chunks that we could have made.
 * Constraints
 * 1 <= N <= 100000
 * -10^9 <= A[i] <= 10^9
 * For Example
 * Input 1:
 *     A = [3, 2, 3, 4, 0]
 * Output 1:
 *     1
 *
 * Input 2:
 *     A = [2, 0, 1, 2]
 * Output 2:
 *     2
 */
public class MaxChunksToMakeSortedII {
    public int solve(ArrayList<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> expected = new ArrayList<>(list);
        //sort the array to get the expected output
        expected.sort(null);
        int ans = 0, nz = 0;
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i);
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) == 1) nz++;
            if (map.get(x) == 0) nz--;

            int y = expected.get(i);
            map.put(y, map.getOrDefault(y, 0) - 1);
            if (map.get(y) == 0) nz--;
            if (map.get(y) == -1) nz++;

            //If nz==0 that means number of elements in the expected segment equals to the number of traversed elements then nz will be 0
            if (nz == 0) ans++;
        }
        return ans;
    }
}
