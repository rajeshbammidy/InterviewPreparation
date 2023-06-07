

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static class Node {
        public Node(String end, double cost) {
            this.end = end;
            this.cost = cost;
        }
        String end;
        double cost;

    }

    static double maxCost = -1.0;

    public static void main(String[] args) throws Exception {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        int i = 0;
        HashMap<String, ArrayList<Node>> graph = new HashMap<>();
        String source = "";
        String target = "";

        maxCost = -1.0;
        while ((line = in.readLine()) != null) {
            if (i == 0) {
                String semiDelimeter[] = line.split(";");
                for (String sed : semiDelimeter) {
                    String comDelimeter[] = sed.split(",");
                    String src = comDelimeter[0];
                    String dest = comDelimeter[1];
                    double cost = Double.parseDouble(comDelimeter[2]);
                    if (graph.get(src) == null) graph.put(src, new ArrayList<>());
                    graph.get(src).add(new Node(dest, cost));
                }

            } else if (i == 1) {
                source = line;

            } else {
                target = line;
            }
        }
        HashSet<String> visited = new HashSet<>();

        dfs(graph, source, target, 1, visited);
        System.out.println(maxCost);

    }

    private static void dfs(HashMap<String, ArrayList<Node>> graph, String source, String target, double cost, HashSet<String> visited) {
        visited.add(source);
        if (source.equals(target)) {
            maxCost = Math.max(maxCost, cost);
        }
        if (!graph.containsKey(source)) return;

        for (Node node : graph.get(source)) {
            if (!visited.contains(node.end)) {
                dfs(graph, node.end, target, cost * node.cost, visited);
            }
        }
        visited.remove(source);
    }
}