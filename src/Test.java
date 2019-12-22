import oracle.sql.ARRAY;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Oct,2019
 * Happy Coding :)
 */


public class Test {
    public ArrayList<Integer> solve(ArrayList<Integer> listA, ArrayList<Integer> listB, int sum) {

        int ans = Integer.MAX_VALUE;

        int m = listA.size();
        int n = listB.size();
        int i = 0;
        int j = n - 1;
        int c = 0, d = 0;
        int prevj = Integer.MAX_VALUE;
        while (i < m && j >= 0) {
            int a = listA.get(i);
            int b = listB.get(j);
            int dif = Math.abs(listA.get(i) + listB.get(j) - sum);
            if (dif < ans || (dif == ans && j < prevj)) {
                ans = dif;
                c = listA.get(i);
                d = listB.get(j);
            }

            if (a + b > sum) {

                prevj = j;
                j--;
            } else {
                i++;
            }

        }

        ArrayList<Integer> res = new ArrayList<>(Arrays.asList(new Integer[]{c, d}));
        return res;

    }

    public static void main(String[] args) throws Exception {
        Integer arr[] = {1, 6, 1, 4, 5, 2};
        ArrayList<Integer> res = new ArrayList<>(Arrays.asList(arr));


        String title = getTitle("Find the closest pair from two sorted arrays");
        System.out.println(title);

    }

    private static String getTitle(String str) {
        String res = "";
        for (String x : str.split("\\s")) {
            res += (x.charAt(0) + "").toUpperCase() + x.substring(1);
        }
        return res;

    }


}