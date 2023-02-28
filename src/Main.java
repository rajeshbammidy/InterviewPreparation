

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static class Node {
        int i;
        int j;
        int distance;

        public Node(int i, int j, int distance) {
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int res[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    int distance = findDistance(mat, i, j);
                    res[i][j] = distance;
                } else {
                    res[i][j] = 0;
                }
            }

        }
        return res;

    }

    private int findDistance(int[][] mat, int i, int j) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<Solution.Node> queue = new LinkedList<>();
        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
        queue.add(new Solution.Node(i, j, 0));
        visited.add(new Pair<Integer, Integer>(i, j));
        int dirX[] = {0, -1, 0, 1};
        int dirY[] = {-1, 0, 1, 0};
        while (!queue.isEmpty()) {
            Solution.Node node = queue.poll();
            for (int k = 0; k < dirX.length; k++) {
                int nextRow = dirX[k] + node.i;
                int nextCol = dirY[k] + node.j;

                if (isValid(nextRow, nextCol, m, n) && !visited.contains(new Pair<Integer, Integer>(nextRow, nextCol))) {
                    if (mat[nextRow][nextCol] == 0) return node.distance + 1;
                    queue.add(new Solution.Node(nextRow, nextCol, node.distance + 1));
                    visited.add(new Pair<Integer, Integer>(nextRow, nextCol));
                }

            }

        }
        return -1;

    }

    private boolean isValid(int nextRow, int nextCol, int m, int n) {
        return nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n;
    }

    static Integer dp[][];

    public static void main(String[] args) {
        dp = new Integer[4][(int) 1e6];
        System.out.println(new Main().getMinCost(new int[]{1, 1, 3, 4}, new int[]{3, 1, 2, 3}, 4, 0, 0, 0));
    }

    public boolean isAlienSorted(String[] words, String order) {
        words = new String[]{"hello", "app"};
        order = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<Character> list = new ArrayList<Character>();
        for (char ch : order.toCharArray()) {
            list.add(ch);
        }
        for (int i = 1; i < words.length; i++) {
            if (!compare(words[i - 1], words[i], list)) {
                return false;
            }
        }
        return true;

    }

    private boolean compare(String word, String word1, ArrayList<Character> list) {
        int i = 0;
        while (i < word.length() && i < word1.length()) {
            if (word.charAt(i) == word1.charAt(i)) i++;
            else if (list.indexOf(word.charAt(i)) > list.indexOf(word1.charAt(i))) return false;
            else return true;
        }
        if (word.length() > word1.length()) return false;
        return true;
    }


    static int parent[];
    static int height[];

    /**
     * PathCompression
     */
    static int find(int x) {
        if (x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    /**
     * Union By Rank
     */
    static void union(int x, int y) {
        int x_rep = find(x);
        int y_rep = find(y);
        if (x_rep == y_rep) return;
        if (height[x_rep] > height[y_rep]) {
            parent[y_rep] = x_rep;
        } else if (height[x_rep] < height[y_rep]) {
            parent[x_rep] = y_rep;
        } else {
            parent[y_rep] = x_rep;
            height[x_rep]++;
        }

    }

    int solve(int n, List<String> query, List<Integer> student1, List<Integer> student2) {
        parent = new int[n + 1];
        height = new int[n + 1];
        int ans = 0;

        for (int i = 0; i < query.size(); i++) {
            String q = query.get(i);
            if (q.equals("Friend")) {
                union(student1.get(i), student2.get(i));
            } else {
                int xP = find(student1.get(i));
                int yP = find(student2.get(i));
                for (int j = 1; j <= n; j++) {
                    if (find(j) == xP || yP == find(j)) ans++;
                }

            }
        }
        return ans;

    }


    int solve(int n, int initialEnergy[], int th) {

        int beg = 0;
        int end = Integer.MAX_VALUE;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            int sum = findSum(initialEnergy, mid);
            if (sum < th) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return beg - 1;
    }

    private int findSum(int[] initialEnergy, int mid) {
        int sum = 0;
        for (int x : initialEnergy) {
            sum += Math.max(x - mid, 0);
        }
        return sum;
    }

    private static int getMinCost(int[] cost, int[] time, int N, int pTask, int pTime, int index) {
        if (pTime >= (N - pTask)) {
            return 0;
        }
        if (index == N) return Integer.MAX_VALUE;
        if (dp[index][N - pTask - pTime] == null) {
            for (int i = index; i < N; i++) {

            }
            int lt = getMinCost(cost, time, N, pTask + 1, pTime + time[index], index + 1);
            if (lt != Integer.MAX_VALUE) {
                lt += cost[index];
            }
            int rt = getMinCost(cost, time, N, pTask, pTime, index + 1);

            dp[index][N - pTask - pTime] = Math.min(lt, rt);
        }
        return dp[index][N - pTask - pTime];

    }

    static class Task {
        int idx;
        int cost;
        int time;

        public Task(int idx, int cost, int time) {
            this.idx = idx;
            this.cost = cost;
            this.time = time;
        }
    }

}


