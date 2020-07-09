import java.util.*;


public class Test {
    int ans = Integer.MAX_VALUE;

    void soln(int arr[][], int d, int p) {
        boolean visited[] = new boolean[arr[0].length];
        int numVisited = 0;
        backtrack(arr, visited, numVisited, p, 0, 0);
        System.out.println(ans);
    }

    private void backtrack(int[][] arr, boolean[] visited, int numVisited, int p, int s, int sum) {
        if(s<0 || s>=arr[0].length)return;

        if (numVisited == p) {
            ans = Math.min(ans, sum);
            System.out.println(Arrays.toString(visited) + " "+ans);
        }

        for (int i = s; i < arr[0].length; i++) {
            numVisited++;
            sum += arr[0][i];
            visited[i] = true;

            for (int j = 0; j < arr.length; j++) {
                if (valid(i + 1, arr) && !visited[i + 1]) {
                    sum += arr[j][i + 1];
                    visited[i + 1] = true;
                    numVisited++;
                    backtrack(arr, visited, numVisited, p, i+2, sum);
                    sum -= arr[j][i + 1];
                    visited[i + 1] = false;
                    numVisited--;
                }
            }

            for (int j = 0; j < arr.length; j++) {
                if (valid(i - 1, arr) && !visited[i - 1]) {
                    sum += arr[j][i - 1];
                    visited[i - 1] = true;
                    numVisited++;
                    backtrack(arr, visited, numVisited, p, i-2, sum);
                    sum -= arr[j][i - 1];
                    visited[i - 1] = false;
                    numVisited--;
                }
            }

            numVisited--;
            sum -= arr[0][i];
            visited[i] = false;


        }


    }

    private boolean valid(int i, int[][] arr) {
        return i >= 0 && i < arr.length;
    }

    public static void main(String[] str) {
      new Test().soln(new int[][]{{1,2,1,0},{2,3,0,1},{3,1,4,2}},3,4);

    }

}