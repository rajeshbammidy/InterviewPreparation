

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
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;
        for (int i = 0; i < coordinates.length - 2; i++) {
            int x1 = coordinates[i][0];
            int y1 = coordinates[i][1];
            int x2 = coordinates[i + 1][0];
            int y2 = coordinates[i + 1][1];
            int x3 = coordinates[i + 2][0];
            int y3 = coordinates[i + 2][1];

            int lhs = (y2 - y1) * (x3 - x2);
            int rhs = (y3 - y2) * (x2 - x1);
            if (lhs != rhs) return false;
        }
        return true;

    }


    public static void main(String[] args) {


    }
}