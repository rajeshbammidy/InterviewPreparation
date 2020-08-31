package Graphs;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Graphs|EvaluateDivision| on Aug,2020
 *  
 * Happy Coding :)
 *
 * 399. Evaluate Division
 **/

import java.util.*;

public class EvaluateDivision {
    static class Node {
        Double value;
        String ch;

        public Node(Double value, String ch) {
            this.value = value;
            this.ch = ch;
        }
    }

    static double cp = 1.0;
    static boolean found = false;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, ArrayList<Node>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if (map.containsKey(a)) {
                map.get(a).add(new Node(values[i], b));
            } else {
                map.put(a, new ArrayList<Node>());
                map.get(a).add(new Node(values[i], b));
            }

            if (map.containsKey(b)) {
                map.get(b).add(new Node(1.0 / values[i], a));
            } else {
                map.put(b, new ArrayList<Node>());
                map.get(b).add(new Node(1.0 / values[i], a));
            }
        }
        double res[] = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {

            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (map.containsKey(a) && map.containsKey(b)) {
                HashSet<String> set = new HashSet<>();
                cp = 1.0;
                found = false;

                dfs(map, a, b, set);
                if (found)
                    res[i] = cp;
                else res[i] = -1.0;
            } else {
                res[i] = -1.0;
            }

        }
        return res;
    }

    private boolean dfs(HashMap<String, ArrayList<Node>> map, String a, String b, HashSet<String> set) {


        set.add(a);

        for (Node x : map.get(a)) {

            String ch = x.ch;
            double val = x.value;

            if (!set.contains(ch)) {
                cp *= val;
                if (ch.equals(b)) return true;
                if (dfs(map, ch, b, set)) {
                    found = true;
                    return true;
                }
                cp /= val;
            }


        }
        return false;
    }
}
