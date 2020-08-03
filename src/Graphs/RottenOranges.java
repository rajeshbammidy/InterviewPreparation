package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Graphs|RottenOranges| on Jul,2020
 *  
 * Happy Coding :)
 **/
public class RottenOranges {
    /**
     * A custom class to store the indexe's of rotten oranges
     */
    static class O {
        int x;
        int y;

        O(int i, int j) {
            x = i;
            y = j;
        }
    }

    public int solve(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        Queue<O> queue = new LinkedList<>();
        /**
         * Traverse the entire matrix and store the rotten oranges places
         */
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 2) {
                    queue.add(new O(i, j));
                }
            }
        }
        queue.add(new O(-1, -1));//indicates end
        int ans = 0;
        while (!queue.isEmpty()) {
            boolean first = false;
            while (!isDelimeter(queue.peek())) {
                O temp = queue.peek();
                //check right
                if (isValid(temp.x, temp.y + 1, m, n)) {
                    int x = temp.x;
                    int y = temp.y + 1;
                    /**
                     * Instead of checking like this you can increment the ans variable for every end ie..(-1,-1)
                     */
                    if (arr[x][y] == 1) {
                        if (!first) {
                            ans++;
                            first = true;

                        }

                        arr[x][y] = 2;
                        queue.add(new O(x, y));
                    }


                }

                //check left
                if (isValid(temp.x, temp.y - 1, m, n)) {
                    int x = temp.x;
                    int y = temp.y - 1;
                    if (arr[x][y] == 1) {
                        if (!first) {
                            ans++;
                            first = true;

                        }

                        arr[x][y] = 2;
                        queue.add(new O(x, y));
                    }


                }

                //down
                if (isValid(temp.x + 1, temp.y, m, n)) {
                    int x = temp.x + 1;
                    int y = temp.y;
                    if (arr[x][y] == 1) {
                        if (!first) {
                            ans++;
                            first = true;

                        }

                        arr[x][y] = 2;
                        queue.add(new O(x, y));
                    }


                }

                //up
                if (isValid(temp.x - 1, temp.y, m, n)) {
                    int x = temp.x - 1;
                    int y = temp.y;
                    if (arr[x][y] == 1) {
                        if (!first) {
                            ans++;
                            first = true;

                        }

                        arr[x][y] = 2;
                        queue.add(new O(x, y));
                    }


                }
                queue.poll();

            }
            queue.poll();
            if (!queue.isEmpty()) queue.add(new O(-1, -1));


        }

        return checkRest(arr) ? -1 : ans;

    }

    private boolean checkRest(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int x, int y, int m, int n) {

        return (x >= 0 && x < m) && (y >= 0 && y < n);
    }

    private boolean isDelimeter(O peek) {
        return peek.x == -1 && peek.y == -1;
    }
}
