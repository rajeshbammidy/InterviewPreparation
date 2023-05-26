package TopicWiseSolutions.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Graphs|BFS.java| on Jul,2019
 * Happy Coding :)
 * Similar to Level Order traversal
 */
public class BFS {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of vertices");
        int n = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter the number of Edges");
        int e = Integer.parseInt(bufferedReader.readLine());

        int graph[][] = new int[n + 1][n + 1];
        System.out.println("Enter the begin vertex and vertex which have an edges");
        for (int i = 1; i <= e; i++) {
            System.out.println("Enter the starting vertex");
            int st = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Enter the ending vertex");
            int end = Integer.parseInt(bufferedReader.readLine());
            graph[st][end] = 1;
            graph[end][st]=1;
        }

        printBFS(graph, 1, n);
    }

    private static void printBFS(int[][] graph, int st, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(st);
        HashSet<Integer> set = new HashSet<>();
        set.add(st);//to check the visited nodes
        System.out.println(st);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (graph[u][i] == 1 && !set.contains(i)) {
                    System.out.println(i);
                    set.add(i);
                    queue.add(i);
                }
            }
        }


    }
}
