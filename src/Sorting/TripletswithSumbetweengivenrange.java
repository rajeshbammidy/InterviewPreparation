package Sorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Sorting|TripletswithSumbetweengivenrange| on May,2020
 *  
 * Happy Coding :)
 *
 * Triplets with Sum between given range
 * Given an array of real numbers greater than zero in form of strings. Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 . Return 1 for true or 0 for false.
 * Example: Given [0.6, 0.7, 0.8, 1.2, 0.4] , You should return 1 as 0.6+0.7+0.4=1.7 1<1.7<2 Hence, the output is 1.
 * O(n) solution is expected. Note: You can assume the numbers in strings don't overflow the primitive data type and there are no leading zeroes in numbers. Extra memory usage is allowed.
 **/
public class TripletswithSumbetweengivenrange {
    public int solve(ArrayList<String> inp) {
        ArrayList<Double> list = new ArrayList<>();
        for (String x : inp) {
            list.add(Double.parseDouble(x));
        }
        double a = list.get(0), b = list.get(1), c = list.get(2);
        ArrayList<Double> cur = new ArrayList<>();
        cur.add(a);
        cur.add(b);
        cur.add(c);
        double sum = a + b + c;

        if (sum > 1 && sum < 2) return 1;
        for (int i = 3; i < list.size(); i++) {


            if (sum > 2) {
                double max = Collections.max(cur);
                sum -= max;
                cur.remove(new Double(max));
                cur.add(list.get(i));
                sum+=list.get(i);

            } else if (sum < 1) {
                double min = Collections.min(cur);
                sum -= min;
                cur.remove(new Double(min));
                cur.add(list.get(i));
                sum+=list.get(i);
            }
            if (sum > 1 && sum < 2) return 1;
        }


        return 0;

    }
}
