package TopicWiseSolutions.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Strings.Backtracking|NumberofSquarefulArrays| on May,2020
 *  
 * Happy Coding :)
 *
 * Number of Squareful TopicWiseSolutions.Strings.Arrays
 * Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square. Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[ i ] != A2[ i ].
 * Input Format
 * The only argument given is the integer array A.
 * Output Format
 * Return the number of permutations of A that are squareful.
 * Constraints
 * 1 <= length of the array <= 12
 * 1 <= A[i] <= 10^9
 * For Example
 * Input 1:
 *     A = [2, 2, 2]
 * Output 1:
 *     1
 *
 * Input 2:
 *     A = [1, 17, 8]
 * Output 2:
 *     2
 **/
public class NumberofSquarefulArrays {
    static int count = 0;

    public int numSquarefulPerms(int[] arr) {
        count = 0;
        ArrayList<Integer> aux = new ArrayList<>();
        boolean visited[] = new boolean[arr.length];
        Arrays.sort(arr);
        backtrack(arr, visited, aux);
        return count;
    }

    private void backtrack(int[] arr, boolean[] visited, ArrayList<Integer> aux) {

        if (aux.size() == arr.length) {
            count++;
        }


        for (int i = 0; i < arr.length; i++) {
            if (visited[i] || i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;
            if (aux.isEmpty()) {
                aux.add(arr[i]);
                visited[i] = true;
                backtrack(arr, visited, aux);
                visited[i] = false;
                aux.remove(aux.size() - 1);

            } else {
                if (IsPerfectSquare(aux.get(aux.size() - 1), arr[i])) {
                    aux.add(arr[i]);
                    visited[i] = true;
                    backtrack(arr, visited, aux);
                    visited[i] = false;
                    aux.remove(aux.size() - 1);
                }
            }

        }
    }

    private boolean IsPerfectSquare(int a, int b) {
        int num = a + b;
        double sqrt = Math.sqrt(num);
        return sqrt - Math.floor(sqrt) == 0;
    }

}
