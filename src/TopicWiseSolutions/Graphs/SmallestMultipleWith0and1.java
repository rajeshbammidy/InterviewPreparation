package TopicWiseSolutions.Graphs;

import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Graphs|SmallestMultipleWith0and1| on Jul,2020
 *  
 * Happy Coding :)
 **/
public class SmallestMultipleWith0and1 {
    static class node {
        int rem;
        String ans;

        public node(int node, String dist) {
            this.rem = node;
            this.ans = dist;
        }
    }

    public String multiple(int n) {
        if (n == 1) return 1 + "";
        Queue<node> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        queue.add(new node(1, "1"));
        while (!queue.isEmpty()) {
            node temp = queue.poll();
            int r = temp.rem;
            String ps = temp.ans;
            int lr = (r * 10) % n + 0;
            if (!set.contains(lr)) {
                queue.add(new node(lr, ps + "0"));
                if (lr == 0) return ps + "0";
            }

            int rr = ((r % n * 10 % n) % n + 1) % n;
            if (!set.contains(rr)) {
                queue.add(new node(rr, ps + "1"));
                if (rr == 0) return ps + "1";
            }
            temp = null;


        }
        return "";
    }
}
