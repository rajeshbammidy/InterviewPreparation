package Graphs;

import java.util.ArrayList;
import java.util.*;

/**
 * Created by RajeshAatrayan|InterviewPreparation|Graphs|CaptureRegionsonBoard| on Jul,2020
 *  
 * Happy Coding :)
 *
 *
 * Approach:If we have any O node at the border ie.. at the top row or first col or last col or last row then what ever
 * nodes with value O cannot be turned into X,so lets perform a bfs or dfs traversal on the extreme border and mark all the O nodes to
 * some delimeters indicating that those cannot be changes to X,rest of the O's any how can be changed.
 **/
public class CaptureRegionsonBoard {

    static class node {
        int x;
        int y;

        node(int i, int j) {
            x = i;
            y = j;
        }
    }

    public void solve(ArrayList<ArrayList<Character>> list) {
        int m = list.size() - 1;
        int n = list.get(0).size() - 1;
        ArrayList<node> inpc = new ArrayList<>();

        /**
         * Find the O nodes at extreme borders
         */
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (list.get(i).get(j) == 'O' && ((i == 0) || (j == 0) || (i == m) || (j == n))) {
                    inpc.add(new node(i, j));
                }

            }
        }

        /**
         * Perform a bfs/dfs traversal on those extreme O nodes and mark all their O adjacent nodes to some delimeter
         */
        for (int i = 0; i < inpc.size(); i++) {
            node temp = inpc.get(i);
            int x = temp.x;
            int y = temp.y;

            if (list.get(x).get(y) == 'O') {
                bfs(list, temp, m, n);
            }
        }

        /**
         * Changing the delimeters to O
         * and remaining O's to X
         */
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (list.get(i).get(j) == 'O') {
                    list.get(i).set(j, 'X');
                } else if (list.get(i).get(j) == '-') {
                    list.get(i).set(j, 'O');
                }

            }
        }

    }

    private void bfs(ArrayList<ArrayList<Character>> list, node root, int m, int n) {
        Queue<node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            node temp = queue.poll();
            list.get(temp.x).set(temp.y, '-');

            //right
            if (isValid(temp.x, temp.y + 1, m, n)) {
                int x = temp.x;
                int y = temp.y + 1;
                if (list.get(x).get(y) == 'O') {

                    queue.add(new node(x, y));
                }


            }
            //check left
            if (isValid(temp.x, temp.y - 1, m, n)) {
                int x = temp.x;
                int y = temp.y - 1;
                if (list.get(x).get(y) == 'O') {

                    queue.add(new node(x, y));
                }


            }

            //down
            if (isValid(temp.x + 1, temp.y, m, n)) {
                int x = temp.x + 1;
                int y = temp.y;
                if (list.get(x).get(y) == 'O') {

                    queue.add(new node(x, y));


                }
            }

            //up
            if (isValid(temp.x - 1, temp.y, m, n)) {
                int x = temp.x - 1;
                int y = temp.y;
                if (list.get(x).get(y) == 'O') {

                    queue.add(new node(x, y));


                }
            }

        }
    }


    private boolean isValid(int x, int y, int m, int n) {

        return (x >= 0 && x <= m) && (y >= 0 && y <= n);
    }
}
