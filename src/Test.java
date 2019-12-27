import oracle.sql.ARRAY;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Oct,2019
 * Happy Coding :)
 */


public class Test {


    public static void main(String[] args) throws Exception {
        Integer arr[] = {1, 6, 1, 4, 5, 2};
        ArrayList<Integer> res = new ArrayList<>(Arrays.asList(arr));


        String title = getTitle("To and Fro");
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