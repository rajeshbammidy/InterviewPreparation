

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        long node1Dist[] = new long[n];
        long node2Dist[] = new long[n];
        Arrays.fill(node1Dist, Integer.MAX_VALUE);
        Arrays.fill(node2Dist, Integer.MAX_VALUE);
        node1Dist[node1] = 0;
        node2Dist[node2] = 0;
        dfs(node1, node1Dist, edges, 0);
        dfs(node2, node2Dist, edges, 0);
        System.out.println(Arrays.toString(node1Dist));
        System.out.println(Arrays.toString(node2Dist));
        int minMaxDistance = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (node1Dist[i] != Integer.MAX_VALUE && node1Dist[i] != Integer.MAX_VALUE) {
                if (minMaxDistance > Math.max(node1Dist[i], node2Dist[i])) {
                    minMaxDistance = (int) Math.max(node1Dist[i], node2Dist[i]);
                    index = i;
                }
            }
            System.out.println(index);


        }
        return index;

    }

    private void dfs(int node1, long nodeDist[], int[] edges, int distance) {
        if (node1 == -1) return;

        int next = edges[node1];
        if (next == -1) return;
        if (nodeDist[next] > distance + 1) {
            nodeDist[next] = distance + 1;
            dfs(next, nodeDist, edges, distance + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Main().closestMeetingNode(new int[]{5, -1, 3, 4, 5, 6, -1, -1, 4, 3}, 0, 0));
    }

}


