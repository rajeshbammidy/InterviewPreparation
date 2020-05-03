

import com.sun.deploy.util.ArrayUtil;
import netscape.security.UserTarget;
import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.MARSHAL;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Oct,2019
 * Happy Coding :)
 */


public class Test {
    public int numJewelsInStones(String J, String S) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : S.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int sum = 0;
        for (char ch : J.toCharArray()) {
            if (map.get(ch) != null) {
                sum += map.get(ch);
            }
        }
        return sum;

    }

    public static void main(String[] args) {
//3*10 - 2%5/2sou

        System.out.println(30 - 2 % 5 / 2);


    }
}