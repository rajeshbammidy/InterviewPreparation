

import com.sun.deploy.util.ArrayUtil;
import netscape.security.UserTarget;
import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.MARSHAL;


import javax.print.attribute.HashAttributeSet;
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

    public int firstUniqChar(String s) {
        int arr[] = new int[26];
        Arrays.fill(arr, -1);
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == -1) {
                arr[s.charAt(i) - 'a'] = i;
            } else {
                arr[s.charAt(i) - 'a'] = Integer.MAX_VALUE;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (arr[i] != -1)
                min = Math.min(min, arr[i]);
        }
        return min == Integer.MAX_VALUE ? -1 : min;

    }

    public static void main(String[] args) {
//3*10 - 2%5/2sou
        System.out.println(new Test().firstUniqChar("loveleetcode"));


    }
}