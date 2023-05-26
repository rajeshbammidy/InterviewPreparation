package TopicWiseSolutions.Graphs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by RajeshAatrayan|InterviewPreparation|TopicWiseSolutions.Graphs|PrimsAlgorithm.java| on Jul,2019
 * Happy Coding :)
 * <p>
 * Prims works for only connected weighted undirected graph
 */
public class PrimsAlgorithm {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number of vertices in a graph");
        int v = scanner.nextInt();
        int arr[][] = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {

            for (int j = 1; j <= v; j++) {
                System.out.println("Enter the weight at " + i + "-> " + j);
                arr[i][j] = scanner.nextInt();
            }
        }

        prims(arr, v, 1);
    }

    private static void prims(int[][] arr, int v, int src) {
        int d[] = new int[v + 1];
        int parent[] = new int[v + 1];
        int visited[] = new int[v + 1];
        int temp[][] = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            d[i] = arr[src][i];
            parent[i] = src;
            visited[i] = 0;
        }
        int u = 0, k = 1, cost = 0;
        visited[src] = 1;

        for (int i = 1; i < v; i++) {
            int min = Integer.MAX_VALUE;
            int flag = 0;
            for (int j = 1; j <= v; j++) {

                if (visited[j] == 0 && d[j] < min) {
                    min = d[j];
                    u = j;
                    flag = 1;
                }
            }

            if (flag == 1) {
                visited[u] = 1;
                temp[k][1] = parent[u];
                temp[k++][2] = u;
                cost += d[u];

                for (int x = 1; x <= v; x++) {
                    if (visited[x] == 0 && d[x] > arr[u][x]) {
                        d[x] = arr[u][x];
                        parent[x] = u;
                    }
                }

            }


        }
        System.out.println(Arrays.deepToString(temp));
        System.out.println("The total cost is :" + cost);


    }
}
