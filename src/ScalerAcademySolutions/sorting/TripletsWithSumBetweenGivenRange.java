package ScalerAcademySolutions.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Project: InterviewPreparation
 * Package: ScalerAcademy.sorting / TripletsWithSumBetweenGivenRange
 * Date: Jun, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 *
 * Given an array of real numbers greater than zero in form of strings. Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 . Return 1 for true or 0 for false.
 *
 * Example:
 * Given [0.6, 0.7, 0.8, 1.2, 0.4] ,
 *
 * You should return 1
 *
 * as
 *
 * 0.6+0.7+0.4=1.7
 *
 * 1<1.7<2
 *
 * Hence, the output is 1.
 *
 * O(n) solution is expected.
 *
 * Note: You can assume the numbers in strings don't overflow the primitive data type and there are no leading zeroes in numbers. Extra memory usage is allowed.
 **/
public class TripletsWithSumBetweenGivenRange {

    public int solve(ArrayList<String> list) {
        ArrayList<Double> doubles = new ArrayList<>();
        list.forEach((x) -> doubles.add(Double.parseDouble(x)));

        double sum = 0;
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(3, Collections.reverseOrder());
        PriorityQueue<Double> minHeap = new PriorityQueue<>(3);
        for (int i = 0; i < 3; i++) {
            sum += doubles.get(i);
            maxHeap.add(doubles.get(i));
            minHeap.add(doubles.get(i));
        }
        if (sum > 1 && sum < 2) {
            return 1;
        }
        for (int i = 3; i < doubles.size(); i++) {
            double currElement = doubles.get(i);
            if (sum < 1) {
                sum -= minHeap.poll();
                minHeap.add(currElement);
            } else {
                sum -= maxHeap.poll();
                maxHeap.add(currElement);
            }
            sum += currElement;

            if (sum > 1 && sum < 2) {
                return 1;
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        new TripletsWithSumBetweenGivenRange().solve(new ArrayList<String>(Arrays.asList(new String[]{"2.673662", "2.419159", "0.573816", "2.454376", "0.403605", "2.503658", "0.806191"})));
    }
}
