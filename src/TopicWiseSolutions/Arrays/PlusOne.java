package TopicWiseSolutions.Arrays;

import java.util.ArrayList;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Arrays|PlusOne| on Jul,2020
 *  
 * Happy Coding :)
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 **/
public class PlusOne {
    public int[] plusOne(int[] arr) {
        int n = arr.length - 1;
        int c = 1;
        if (arr.length == 0 || arr == null) return new int[]{};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = n; i >= 0; i--) {
            int curSum = arr[i] + c;
            c = curSum / 10;
            list.add(curSum % 10);
        }
        //System.out.println(list);
        if (c > 0) list.add(c);
        int ans[] = new int[list.size()];
        n = ans.length - 1;
        for (int i = 0; i < list.size(); i++) {
            ans[n - i] = list.get(i);
        }
        return ans;

    }
}
