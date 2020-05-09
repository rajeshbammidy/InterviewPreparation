

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
    public static boolean isPerfectSquare(int num) {
        if (num == 1 || num == 0) return false;
        long beg = 1;
        long end = num;
        while (beg <= end) {
            long mid = beg + (end - beg) / 2;
            if (mid * mid == num) return true;

            if (mid * mid < num) beg = mid + 1;
            else end = mid - 1;

        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(1));

    }
}