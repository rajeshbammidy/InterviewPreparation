package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Graphs|DFS.java| on Jul,2019
 * Happy Coding :)
 * Similar to Preorder traversal
 */
public class DFS {
    static int visited[];
    public static void main(String[] args)throws  Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of vertices");
        int n = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter the number of Edges");
        visited=new int[n+1];
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

        printDFS(graph, 1, n);
    }

    private static void printDFS(int[][] graph, int st, int n) {
        if(visited[st]==0){
            System.out.println(st);
            visited[st] = 1;
            for(int i=1;i<=n;i++){
                if(visited[i]==0&&graph[st][i]==1){
                    printDFS(graph,i,n);
                }
            }
        }
    }
}
