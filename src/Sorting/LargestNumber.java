package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Sorting|LargestNumber| on May,2020
 *  
 * Happy Coding :)
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 **/
public class LargestNumber {
    public String largestNumber(int[] nums) {

        ArrayList<String> list = new ArrayList<>();
        for (int x : nums) list.add(x + "");
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String xy = x + y;
                String yx = y + x;
                return xy.compareTo(yx) > 0 ? -1 : 1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String str = sb.toString();
        if (str.replaceAll("0", "").length() == 0) return "0";
        return sb.toString();

    }
}
