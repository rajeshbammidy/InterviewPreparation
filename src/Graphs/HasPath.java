package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Graphs|HasPath.java| on Jul,2019
 * Happy Coding :)
 * <p>
 * This is to check whether there exists a path between the start and end index;
 */
public class HasPath {
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
        System.out.println("Enter the starting node");
        int st = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter the ending node");
        int end = Integer.parseInt(bufferedReader.readLine());

        boolean hasPath = getHasPathBfs(graph, st, end, n);
        if (hasPath) {
            System.out.println("There exists a pathBetween " + st + " " + end);
        } else {
            System.out.println("There is no path");
        }

        getHasPathDFS(graph, st, end, n);
    }
static boolean met=false;
    private static boolean getHasPathDFS(int[][] graph, int st, int end, int n) {
        if (st == end) {
            return true;
        }
        else if (visited[st] == 0) {
            System.out.println(st);
            visited[st] = 1;
            for (int i = 1; i <= n; i++) {
                if (visited[i] == 0 && graph[st][i] == 1) {
                    boolean res= getHasPathDFS(graph, i, end, n);
                    if(res==true){
                        return true;
                    }
                }
            }


        }
        return false;

    }

    private static boolean getHasPathBfs(int[][] graph, int st, int end, int n) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(st);
        HashSet<Integer> set = new HashSet<>();
        set.add(st);//to check the visited nodes
        System.out.println(st);
        if(st==end){
            return true;
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (graph[u][i] == 1 && !set.contains(i)) {

                    set.add(i);
                    queue.add(i);
                    if (i == end) return true;
                }
            }
        }

        return false;
    }
}
