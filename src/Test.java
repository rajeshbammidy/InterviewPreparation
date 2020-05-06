

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

    public int majorityElement(int[] nums)
    {
        Stack<Integer> stack=new Stack<>();
        for(int x:nums){

            if(stack.isEmpty()){
                stack.add(x);
                continue;
            }
            if(stack.peek()==x){
                stack.add(x);
            }
            else
            stack.pop();
        }
        return stack.peek();

    }

    public static void main(String[] args) {
//3*10 - 2%5/2sou
        System.out.println(new Test().majorityElement(new int[]{3,2,3}));


    }
}