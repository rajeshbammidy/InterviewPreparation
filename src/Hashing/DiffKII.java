package Hashing;

import java.util.HashSet;
import java.util.List;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Hashing|null.java| on Dec,2019
 * Happy Coding :)
 * <p>
 * Diffk II
 * Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j. Example : Input :
 * A : [1 5 3]
 * k : 2
 * Output :
 * 1
 * as 3 - 1 = 2
 * Return 0 / 1 for this problem.
 */
public class DiffKII {
    public int diffPossible(final List<Integer> a, int b) {
        HashSet<Integer> visited = new HashSet<Integer>();
        for (Integer number : a) {
            /**
             * Lets say a-b=k
             * considering only a-k=b or a=k+b will not work here so we need to consider both the cases
             *
             */
            if (visited.contains(number + b) || visited.contains(number - b)) return 1;
            visited.add(number);
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
