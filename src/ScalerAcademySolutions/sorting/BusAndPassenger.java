package ScalerAcademySolutions.sorting;

import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.sorting / BusAndPassenger
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * There is bus having N rows, each row consist of two seats of equal size. Given an array A where A[i] determines the width of seats in the ith row.
 *
 * There are 2*N passengers of type 0 and type 1 (exactly N passengers of type 0 and exactly N passengers of type 1).
 *
 * Type 0 : Type 0 passenger always chooses a row where both seats are empty. Among these rows, he chooses the one with the smallest seat width and takes one of the seats in it.
 *
 * Type 1 : Type 1 always chooses a row where exactly one seat is occupied (by a type 0 passenger). Among these rows, he chooses the one with the largest seat width and takes the vacant place in it.
 *
 * You are given a string B determining the order the passenger entering the bus where B[i] is either '0' (type 0 passenger) or '1' (type 1 passenger).
 *
 * Return an array of intergers C, where C[i] determines row taken by ith passenger.
 *
 *
 * Input Format
 *
 * The argument given is the integer array A and string B.
 * Output Format
 *
 * Return an array of integers C, where C[i] determines row taken by passenger i.
 * Constraints
 *
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 10^5
 * length of string = 2 * length of array
 * B[i] is either '0' or '1'.
 * All array elements are distinct.
 * For Example
 *
 * Input 1:
 * A = [3, 1]
 * B = "0011"
 * Output 1:
 * C= [2, 1, 1, 2]
 *
 * Input 2:
 * A = [10, 8, 9, 11, 13, 5]
 * B = "010010011101"
 * Output 2:
 * C= [6, 6, 2, 3, 3, 1, 4, 4, 1, 2, 5, 5]
 **/
public class BusAndPassenger {

    public int[] solve(int[] seats, String passengerFlow) {
        Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        for (int i = 0; i < seats.length; i++) {
            treeMap.put(seats[i], i + 1);
        }
        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = treeMap.entrySet().iterator();
        int ans[] = new int[passengerFlow.length()];
        for (int i = 0; i < passengerFlow.length(); i++) {
            if (passengerFlow.charAt(i) == '0') {
                Map.Entry<Integer, Integer> curEntry = iterator.next();
                stack.push(curEntry);
                ans[i] = curEntry.getValue();
            } else {
                Map.Entry<Integer, Integer> curEntry = stack.pop();
                ans[i] = curEntry.getValue();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new BusAndPassenger().solve(new int[]{10, 21, 28, 3, 15, 1, 6}, "00101101010011");
    }
}
