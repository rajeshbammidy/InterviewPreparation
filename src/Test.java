

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
    public static int findJudge(int n, int[][] trust) {
        if(n==1)return 1;
        int trustLen = trust.length;
        if (trustLen < n - 1) return -1;
        int dp[] = new int[n + 1];
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < trustLen; i++) {
            dp[trust[i][1]]++;
            set.add(trust[i][0]);
            if (dp[trust[i][1]] > dp[max]) {
                max = trust[i][1];
            }
        }

        if (set.contains(max)) return -1;
        return dp[max] == n - 1 ? max : -1;


    }

    public static void main(String[] args) {

        System.out.println(findJudge(4, new int[][]{{3, 2}, {4, 1}, {3, 1}, {2, 1}, {2, 3}, {4, 3}, {4, 2}, {3, 4}}));
    }
}