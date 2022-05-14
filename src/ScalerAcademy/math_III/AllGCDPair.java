package ScalerAcademy.math_III;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.math_III / AllGCDPair
 * Date: May, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Problem Description
 * Given an array of integers A of size N containing GCD of every possible pair of elements of another array.
 *
 * Find and return the original numbers used to calculate the GCD array in any order. For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 10000
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The first and only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Find and return the original numbers which are used to calculate the GCD array in any order.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [2, 2, 2, 2, 8, 2, 2, 2, 10]
 * Input 2:
 *
 * A = [5, 5, 5, 15]
 *
 *
 * Example Output
 * Output 1:
 *
 * [2, 8, 10]
 * Output 2:
 *
 * [5, 15]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Initially, array A = [2, 2, 2, 2, 8, 2, 2, 2, 10].
 * 2 is the gcd between 2 and 8, 2 and 10.
 * 8 and 10 are the gcds pair with itself.
 * Therefore, [2, 8, 10] is the original array.
 * Explanation 2:
 *
 * Initially, array A = [5, 5, 5, 15].
 * 5 is the gcd between 5 and 15.
 * 15 is the gcds pair with itself.
 * Therefore, [5, 15] is the original array.
 *
 *
 * Approach:
 * For any given array arr,if you find the GCD of every pair and denote in terms of n*n matrix, the diagonal elements will
 * gcd of the same number itself, therefore we just have to find the diagonal elements.
 *
 * ^^ the above approach will work only when the gcd of pairs are given in the order.
 *
 *
 *
 * Let's see the approach which will work for unordered pair as well.
 * Approach:
 * The appraoch is based on the fact that,the element in the given input could be a gcd produced by doing gcd with same number
 * which is an element in the res array or the other way of saying is the element could be diagonal element.
 *
 * We know that gcd(a,b)=x then x must lie between [1,min(a,b)];
 * sort the array in reverseOrder
 * create a res array
 * if the res array is empty insert first value into it
 * if the array is not empty the element e can form gcd in pairs with the elements in res,store the gcd in map.
 *
 *
 */
public class AllGCDPair {
 /*   public int[] solve(int[] arr) {
        int n = (int) Math.sqrt(arr.length);
        int res[] = new int[n];
        int j = 0;
        for (int i = 0; i < arr.length; i += n) {
            res[j] = arr[j + i];
            j++;
        }
        return res;
    }*/

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public ArrayList<Integer> solve(ArrayList<Integer> list) {
        int n = (int) Math.sqrt(list.size()); // this will be the size of res array list
        HashMap<Integer, Integer> map = new HashMap<>();
        Collections.sort(list, Collections.reverseOrder());
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
            if (map.containsKey(element) && map.get(element) > 0) {
                map.put(element, map.get(element) - 1);
            } else {
                for (int j = 0; j < res.size(); j++) {
                    int gcd = gcd(res.get(i), element);
                    if (map.containsKey(gcd)) {
                        map.put(gcd, map.get(gcd) + 2);
                    } else {
                        map.put(gcd, 2);
                    }
                }
                res.add(element);
            }

        }
        return res;
    }
}
