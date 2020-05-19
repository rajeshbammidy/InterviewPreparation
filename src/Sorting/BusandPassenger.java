package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Sorting|BusandPassenger| on May,2020
 *  
 * Happy Coding :)
 **/
public class BusandPassenger {
    static class node {
        int index, value;

        node(int in, int v) {
            index = in;
            value = v;
        }
    }

    public ArrayList<Integer> solve(ArrayList<Integer> l, String inp) {
        ArrayList<node> list = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            list.add(new node(i, l.get(i)));
        }
        Collections.sort(list, new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return o1.value - o2.value;
            }
        });
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < inp.length(); i++) {
            if (inp.charAt(i) == '0') {
                stack.add(list.get(k).index + 1);
                res.add(stack.peek());
                k++;
            } else {
                res.add(stack.pop());

            }
        }

        return res;
    }
}
