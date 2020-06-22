import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|Codechef| on Jun,2020
 *  
 * Happy Coding :)
 **/
public class Codechef {

    static class node {
        int beg, end;
        int val;

        public node(int beg, int end) {
            this.beg = beg;
            this.end = end;

        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        String nInp = bf.readLine();
        if (nInp != null) {
            n = Integer.parseInt(nInp);
        }

        Queue<node> queue = new LinkedList<>();
        int wbeg = 1, wend = n;

        queue.add(new node(wbeg, wend));
        int k = 0;
        while (true) {
            node temp = queue.poll();
            int mid = temp.beg + (temp.end - temp.beg) / 2;
            System.out.println(mid);
            String ans = bf.readLine();
            k++;

            if (ans != null) {

                if (ans.equals("G")) {
                    //true
                    if (mid + 1 <= temp.end) {
                        queue.add(new node(mid + 1, temp.end));
                    }

                    //false
                    if (mid - 1 >= temp.beg) {
                        queue.add(new node(temp.beg, mid - 1));
                    }

                } else if (ans.equals("L")) {

                    //true

                    if (mid - 1 >= temp.beg) {
                        queue.add(new node(temp.beg, mid - 1));
                    }

                    //false
                    if (mid + 1 <= temp.end) {
                        queue.add(new node(mid + 1, temp.end));
                    }


                } else {
                    break;
                }

            }


        }


    }
}