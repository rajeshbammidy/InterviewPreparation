package ScalerAcademySolutions.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.sorting / LargestNumber
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Problem Description
 * Given an array A of non-negative integers, arrange them such that they form the largest number.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 *
 *
 * Problem Constraints
 * 1 <= len(A) <= 100000
 * 0 <= A[i] <= 2*109
 *
 *
 *
 * Input Format
 * The first argument is an array of integers.
 *
 *
 *
 * Output Format
 * Return a string representing the largest number.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [3, 30, 34, 5, 9]
 * Input 2:
 *
 * A = [2, 3, 9, 0]
 *
 *
 * Example Output
 * Output 1:
 *
 * "9534330"
 * Output 2:
 *
 * "9320"
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
 * Explanation 2:
 *
 * Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 **/
public class LargestNumber {
    public String largestNumber(final List<Integer> list) {
        ArrayList<String> strNums = new ArrayList<>();
        list.forEach((x) -> strNums.add(Integer.toString(x)));
        strNums.sort(new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String xy = x + y;
                String yx = y + x;
                return xy.compareTo(yx) > 0 ? -1 : 1;
            }
        });
        StringBuilder builder = new StringBuilder();
        strNums.forEach((x) -> builder.append(x));
        return builder.toString().replaceAll("0", "").length() == 0 ? "0" : builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new ArrayList<>(Arrays.asList(new Integer[]{0, 0, 0, 0}))));
    }
}
