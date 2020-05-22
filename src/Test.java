

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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static BinarySearch.IsPerfectSquare.isPerfectSquare;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Oct,2019
 * Happy Coding :)
 */


public class Test {
    static class node {
        String ch;
        int freq;

        public node(char ch, int index) {
            this.ch = ch+"";
            this.freq = index;
        }
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<node> list = new ArrayList<>();
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                int ind = map.get(ch);
                list.get(ind).freq += 1;
                list.get(ind).ch= list.get(ind).ch+ch;

            } else {
                map.put(ch, i++);
                list.add(new node(ch, 1));
            }
        }

        Collections.sort(list, new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return -(o1.freq-o2.freq);
            }
        });
        StringBuilder sb=new StringBuilder();
        for(node x:list)sb.append(x.ch);
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(new Test().frequencySort(""));
    }
}