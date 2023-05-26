package TopicWiseSolutions.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Graphs|GetPath.java| on Jul,2019
 * Happy Coding :)
 * <p>
 * If there exists a path then getpath between two vertices
 */
public class GetPath {
    static int visited[];
    static Stack<Integer> path = new Stack<>();

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
        System.out.println("Enter the starting node");
        int st = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter the ending node");
        int end = Integer.parseInt(bufferedReader.readLine());

        boolean result = getPathUsingDFS(graph, st, end, n);
        if (result) System.out.println(path);

        // getPathUsingBFS(graph, st, end, n); //To getPathUsingBFS
    }

    private static void getPathUsingBFS(int[][] graph, int st, int end, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int visited[] = new int[n + 1];

        queue.add(st);
        visited[st] = 1;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (visited[i] == 0 && graph[u][i] == 1) {
                    map.put(i, u);
                    queue.add(i);
                    visited[i] = 1;
                    if (i == end) {
                        printValues(map, i);
                        break;
                    }
                }
            }


        }

    }

    private static void printValues(Map<Integer, Integer> map, int i) {
        System.out.println(i);
        while (map.get(i) != null) {

            i = map.get(i);
            System.out.println(i);
        }

    }

    static boolean met = false;

    private static boolean getPathUsingDFS(int[][] graph, int st, int end, int n) {
        if (st == end) {
            path.push(st);
            return true;
        } else if (visited[st] == 0) {
            visited[st] = 1;
            for (int i = 1; i <= n; i++) {
                if (visited[i] == 0 && graph[st][i] == 1) {
                    // path.push(i);
                    boolean found = getPathUsingDFS(graph, i, end, n);
                    if (found == true) {
                        path.push(st);
                        return true;
                    }

                }
            }


        }
        return false;

    }
}
