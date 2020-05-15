

import com.sun.deploy.util.ArrayUtil;
import com.sun.org.apache.regexp.internal.RE;
import netscape.security.UserTarget;
import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.MARSHAL;


import javax.print.attribute.HashAttributeSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

import static BinarySearch.IsPerfectSquare.isPerfectSquare;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Oct,2019
 * Happy Coding :)
 */


public class Test {
    int kadanesAlgo(int arr[]) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i = 0; i < n; i++) {

            curSum += arr[i];
            maxSum = Math.max(curSum, maxSum);
            if (curSum < 0) curSum = 0;
        }
        return maxSum;
    }

    public int maxSubarraySumCircular(int[] arr) {

        int maxSubArraySum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -arr[i];
        }
        maxSubArraySum = kadanesAlgo(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -arr[i];
            sum += arr[i];
        }
        int actualKadanesSum = kadanesAlgo(arr);
        System.out.println(actualKadanesSum);

        return Math.max(actualKadanesSum, sum + maxSubArraySum==0?Integer.MIN_VALUE: sum + maxSubArraySum);

    }

    public static void main(String[] args) {
        System.out.println(new Test().maxSubarraySumCircular(new int[]{-2,-3,-1}));


    }
}