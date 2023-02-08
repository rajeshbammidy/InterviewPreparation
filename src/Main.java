

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

    public static void main(String[] args) {

        List<String> queries = Arrays.asList("Friend", "Total");
        List<Integer> s1 = Arrays.asList(1, 2);
        List<Integer> s2 = Arrays.asList(2, 3);
        System.out.println(new Main().solve(3, queries, s1, s2));
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

}


