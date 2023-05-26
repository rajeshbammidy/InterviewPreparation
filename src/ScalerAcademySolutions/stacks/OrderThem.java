package ScalerAcademySolutions.stacks;

import java.util.*;

/**
 * @Project: InterviewPreparation
 * @Package: ScalerAcademy.stacks
 * Date:Aug, 2022
 * Author: RajeshAatrayan
 * Happy Coding :)
 *
 * Problem Description
 *
 * Given an array of integers A describing ranking of trucks. Your task is to insert these rank in another array B by some means of operations such that B is sorted in ascending order. For performing these operations you can use one stack C.
 *
 * In one Operation you can perform any of the following steps:
 *
 * Remove the first element from A and append at the back of C.
 * Remove the last element from C and append at the back of B.
 * Remove the first element from A and append at the back of B.
 * you can perform these operations any number of times (possibly zero).
 *
 * Return 1 if B can be formed in ascending order using some operations else return 0.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= length of Array
 * All elements of A are distinct.
 *
 *
 *
 * Input Format
 *
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 *
 * Return 1 if B can be formed in ascending order using some operations else return 0.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [5, 1, 2, 4, 3]
 * Input 2:
 *
 * A = [5, 3, 1, 4, 2]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * 1
 *
 *
 * 0
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * Given array A = [5, 1, 2, 4, 3], stack C = [] , array B = []
 * step 1: A = [5, 1, 2, 4, 3]
 *         C = []
 *         B = []
 * step 2: A = [1, 2, 4, 3]
 *         C = [5]
 *         B = []
 * step 3: A = [2, 4, 3]
 *         C = [5]
 *         B = [1]
 * step 4: A = [4, 3]
 *         C = [5]
 *         B = [1, 2]
 * step 5: A = [3]
 *         C = [5, 4]
 *         B = [1, 2]
 * step 6: A = []
 *         C = [5, 4]
 *         B = [1, 2, 3]
 * step 7: A = []
 *         C = [5]
 *         B = [1, 2, 3, 4]
 * step 8: A = []
 *         C = []
 *         B = [1, 2, 3, 4, 5]
 * Array B is in ascending order. So, return 1.
 */
public class OrderThem {

    public int solve(ArrayList<Integer> list) {

        ArrayList<Integer> sortedArray = new ArrayList<>(list);
        Collections.sort(sortedArray);
        HashMap<Integer, Integer> sortedArrayMap = new HashMap();
        for (int i = 0; i < sortedArray.size(); i++) {
            sortedArrayMap.put(sortedArray.get(i), i);
        }

        ArrayList<Integer> bArray = new ArrayList<>();
        Stack<Integer> cStack = new Stack<>();

        for (int x : list) {
            if (cStack.isEmpty()) {
                cStack.push(x);
                continue;
            }


            if ((bArray.isEmpty() && isSmallestElement(sortedArrayMap, x)) || (!bArray.isEmpty() && isEligibleForBarray(bArray, sortedArrayMap, x))) {
                bArray.add(x);
            } else if (cStack.peek() > x) {
                cStack.push(x);
            } else if (cStack.peek() < x) {
                while (!cStack.isEmpty() && cStack.peek() < x) {
                    int element = cStack.pop();
                    if (isEligibleForBarray(bArray, sortedArrayMap, element)) {
                        bArray.add(element);
                    } else {
                        return 0;
                    }
                }
                cStack.push(x);
            }

        }
        return 1;
    }

    private boolean isEligibleForBarray(ArrayList<Integer> bArray, HashMap<Integer, Integer> sortedArrayMap, int x) {
        if (bArray.isEmpty()) {
            return isSmallestElement(sortedArrayMap, x);
        }

        return sortedArrayMap.get(bArray.get(bArray.size() - 1)) + 1 == sortedArrayMap.get(x);
    }

    private boolean isSmallestElement(HashMap<Integer, Integer> sortedArrayMap, int x) {
        return sortedArrayMap.get(x) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new OrderThem().solve(new ArrayList<>(Arrays.asList(2, 4, 6, 1, 3, 7, 8, 5))));
    }
}
