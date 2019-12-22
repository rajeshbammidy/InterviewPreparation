package TwoPointers;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TwoPointers|null.java| on Dec,2019
 * Happy Coding :)
 * <p>
 * Counting Triangles
 * You are given an array of N non-negative integers, A0, A1 ,..., AN-1. Considering each array element Ai as the edge length of some line segment, count the number of triangles which you can form using these array values. Notes:
 * You can use any value only once while forming each triangle. Order of choosing the edge lengths doesn't matter. Any triangle formed should have a positive area.
 * Return answer modulo 109 + 7.
 * For example,
 * A = [1, 1, 1, 2, 2]
 * <p>
 * Return: 4
 */
public class CountingTriangles {
    public int nTriang(ArrayList<Integer> list) {
        list.sort(null);//sort the given list in non-dec order
        /*
        Here 'i' will fix the c and we will look for a and b
         */
        int mod = (int) (1e9 + 7);
        long ans = 0;
        for (int i = list.size() - 1; i >= 1; i--) {
            int left = 0;
            int right = i - 1;

            while (left < right) {
                int a = list.get(left);
                int b = list.get(right);
                int c = list.get(i);
                if (a + b > c) {
                    /**
                     * If a+b>c then it will satisfy all the number that are between a and b
                     * so therefore we get those number by right-left
                     * and we decrement the right to check if it satisfies the condition
                     */
                    ans = (ans % mod + (right - left) % mod) % mod;
                    right--;
                } else {
                    /*
                    If a+b!>c that means a must be smaller so we increment the left pointer
                     */
                    left++;
                }
            }

        }
        return (int) (ans);

    }
}
