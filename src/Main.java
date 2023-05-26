

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static int longestOnes(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
        }
        return j - i;
    }

    public static void main(String[] args) {
        int nums[] = {};
        int value = longestOnes(new int[]{}, 3);

        int i = 0;
        int sum = 0;
        int k = 3;
        int count = 0;
        while (i < nums.length && sum < value && k > 0) {
            if (nums[i] == 0) {
                k--;
            }
            sum++;
        }
        if (sum == value) count++;



    }
}


// This code is contributed by hritikrommie



