


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
    public void reverseString(char[] str) {
      for(int i=0;i<str.length/2;i++){
          char c=str[i];
          char d=   str[str.length-i-1];
          str[str.length-i-1]=c;
          str[i]=d;

      }


    }

    public static void main(String[] args) {
        new Test().reverseString(new char[]{'a','b','c'});
    }
}