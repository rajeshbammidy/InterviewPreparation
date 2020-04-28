package BinarySearch;

import java.util.List;

/**
 * Created by RajeshAatrayan|InterviewPreparation|BinarySearch|RotatedSortedArraySearch| on Apr,2020
 *  
 * Happy Coding :)
 * <p>
 * Rotated Sorted Array Search
 * Given an array of integers A of size N and an integer B. array A is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ). You are given a target value B to search. If found in the array, return its index, otherwise return -1. You may assume no duplicate exists in the array. NOTE:- Array A was sorted in non-decreasing order before rotation.
 * NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * Output Format
 * Return index of B in array A, otherwise return -1
 * Constraints
 * 1 <= N <= 1000000
 * 1 <= A[i] <= 10^9
 * all elements in A are disitinct.
 * For Example
 * Input 1:
 * A = [4, 5, 6, 7, 0, 1, 2, 3]
 * B = 4
 * Output 1:
 * 0
 * Explanation 1:
 * Target 4 is found at index 0 in A.
 * <p>
 * <p>
 * Input 2:
 * A = [5, 17, 100, 3]
 * B = 6
 * Output 2:
 * -1
 **/
public class RotatedSortedArraySearch {
    // DO NOT MODIFY THE LIST
    public int search(final List<Integer> list, int b) {
        int k = findk(list);
        if (list.size() == 1) return list.contains(b) ? 1 : -1;
        int ans = -1;

        if (b < list.get(list.size() - 1)) {
            ans = binarysrch(list, k, list.size() - 1, b);
        } else {
            ans = binarysrch(list, 0, k - 1, b);
        }
        return ans;

    }

    private int binarysrch(List<Integer> list, int beg, int end, int b) {
        while (beg <= end) {
            int mid = (beg + end) / 2;
            if (list.get(mid) == b) return mid;
            if (list.get(mid) < b) beg = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    private int findk(List<Integer> list) {
        int beg = 0;
        int end = list.size() - 1;
        int n = list.size() - 1;
        while (beg <= end) {
            int mid = (beg + (end - beg) / 2);

            if (list.get(mid) < list.get(n) && (mid == 0 || list.get(mid - 1) > list.get(mid))) return mid;
            if (list.get(mid) > list.get(n)) beg = mid + 1;
            if (list.get(mid) < list.get(n)) end = mid - 1;
        }
        return -1;
    }
}
