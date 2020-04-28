

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

interface BinaryMatrix {
    public int get(int row, int col);

    public List<Integer> dimensions

            ();
};

public class Test {

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int ans = dim.get(1) + 1;
        int col = dim.get(1);
        int row = dim.get(0);
        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && i < row && j >= 0 && j < col) {

            int t = binarySearch(binaryMatrix, 1, i, j);
            if (t != -1 && t < ans) {
                ans = t;
                j = t;
            }
            t--;

        }
        return ans;


    }

    private int binarySearch(BinaryMatrix binaryMatrix, int k, int row, int end) {
        int beg = 0;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            if (binaryMatrix.get(row, mid) == k && (mid - 1 < 0 || binaryMatrix.get(row, mid - 1) == 0)) {
                return mid;
            } else if (binaryMatrix.get(row, mid) < k) {
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(74));


        // System.out.println(new Test().subarraySum(new int[]{-1, -1, 1}, 0));
    }
}