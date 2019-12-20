package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Graphs|BFSandDFSForDisConnectedGraph.java| on Jul,2019
 * Happy Coding :)
 *
 * To traverse the disconnected graph use visited array to traverse the unvisited nodes again
 */
public class BFSandDFSForDisConnectedGraph {
    static int visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of vertices");
        int n = Integer.parseInt(bufferedReader.readLine());
        visited = new int[n + 1];
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
            graph[end][st] = 1;
        }

        printBFS(graph, 1, n);
        for (int x = 1; x < visited.length; x++) {
            if (visited[x] == 0) {
                printBFS(graph, x, n);
            }
        }

    }

    private static void printBFS(int[][] graph, int st, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(st);

        visited[st] = 1;//to check the visited nodes
        System.out.println(st);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (graph[u][i] == 1 && visited[i] == 0) {
                    System.out.println(i);

                    visited[i] = 1;
                    queue.add(i);
                }
            }
        }


    }
}
