package ScalerAcademy.hashing2;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.hashing2 / DiffkII
 * Date: Jul, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 *
 * Example :
 *
 * Input :
 *
 * A : [1 5 3]
 * k : 2
 * Output :
 *
 * 1
 * as 3 - 1 = 2
 *
 * Return 0 / 1 for this problem.
 **/
public class DiffkII {
    public int diffPossible(final int[] array, int k) {
        if (array.length < 2) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i] - k) && map.get(array[i] - k) != i) return 1;
        }
        return 0;

    }
}
