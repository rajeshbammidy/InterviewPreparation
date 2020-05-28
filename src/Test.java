

import com.sun.deploy.util.ArrayUtil;
import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import netscape.security.UserTarget;
import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.MARSHAL;
import sun.rmi.runtime.Log;


import javax.print.attribute.HashAttributeSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static BinarySearch.IsPerfectSquare.isPerfectSquare;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Oct,2019
 * Happy Coding :)
 */


public class Test {
    public int[] countBits(int num) {
        int arr[] = new int[num + 1];
        if(num==0)return arr;
        arr[0] = 0;
        arr[1] = 1;
        int in = 0;
        for (int i = 1; i <= num; i++) {

            if ((i & i - 1) == 0) {
                in = 0;
                arr[i] = arr[in++] + 1;

            } else {
                arr[i] = arr[in++] + 1;
            }


        }

        return arr;


    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(91));
        new Test().countBits(92);
    }
}