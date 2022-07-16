package ScalerAcademy.twoPointers;

import java.util.Arrays;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.two_pointers / CountingTriangles
 * Date: Jul, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 *
 * You are given an array of N non-negative integers, A0, A1 ,…, AN-1. Considering each array element Ai as the edge length of some line segment, count the number of triangles which you can form using these array values.
 *
 * Notes:
 *
 * You can use any value only once while forming each triangle. Order of choosing the edge lengths doesn't matter. Any triangle formed should have a positive area.
 *
 * Return answer modulo 109 + 7.
 *
 * For example,
 *
 * A = [1, 1, 1, 2, 2]
 *
 * Return: 4
 *
 * Approach: if A<B<C then A+B>C then only it can form a triangle
 **/
public class CountingTriangles {
    public int nTriang(int[] sideLengths) {
        Arrays.sort(sideLengths);
        int mod = (int) (1e9 + 7);
        long count = 0;
        int lastSideC = sideLengths.length - 1;
        while (lastSideC > 1) {
            int start = 0;
            int end = lastSideC - 1;
            while (start < end) {
                if (0L + sideLengths[start] + sideLengths[end] > sideLengths[lastSideC]) {
                    count += (end - start);
                    end--;
                } else {
                    start++;
                }
            }
            lastSideC--;
        }
        return (int) (count % mod);


    }

    public static void main(String[] args) {
        System.out.println(new CountingTriangles().nTriang(new int[]{1, 1, 1, 2, 2}));
    }
}
